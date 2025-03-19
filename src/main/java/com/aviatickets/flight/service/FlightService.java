package com.aviatickets.flight.service;

import com.aviatickets.flight.controller.request.FlightCreateRequest;
import com.aviatickets.flight.controller.request.FlightUpdateRequest;
import com.aviatickets.flight.controller.request.FlightFilter;
import com.aviatickets.flight.model.Airport;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Seat;
import com.aviatickets.flight.repository.AirportRepository;
import com.aviatickets.flight.repository.FlightRepository;
import com.aviatickets.flight.util.http.HttpUtils;
import com.aviatickets.flight.util.http.PageableResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FlightService {

    public static final String FLIGHT_NOT_FOUND = "Flight not found by id %d";

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new NoSuchElementException(FLIGHT_NOT_FOUND.formatted(id)));
    }

    public PageableResult<Flight> findAll(Pageable pageable, FlightFilter filter) {
        Page<Flight> flights = flightRepository.findAll(pageable);

        return HttpUtils.pageableOk(
                flights.stream().filter(filter.toPredicate()).toList(),
                pageable.getPageNumber(),
                pageable.getPageSize(),
                flights.getTotalElements(),
                flights.getSort()
        );
    }

    @Transactional
    public Flight createFlight(FlightCreateRequest createRequest) {
        if (createRequest.getDepartureAirportId().equals(createRequest.getArrivalAirportId())){
           throw new  IllegalArgumentException("Аэропорт прибытия и Аэропорт отправления похожи");
        }
        Airport departureAirport = getAirportById(createRequest.getDepartureAirportId());
        Airport arrivalAirport = getAirportById(createRequest.getArrivalAirportId());

        Flight flight = Flight.builder()
                .flightNumber(createRequest.getFlightNumber())
                .arrivalAirport(arrivalAirport)
                .departureAirport(departureAirport)
                .terminal(createRequest.getTerminal())
                .gate(createRequest.getGate())
                .departureTime(createRequest.getDepartureTime())
                .arrivalTime(createRequest.getArrivalTime())
                .price(createRequest.getPrice())
                .baggageAllowance(createRequest.getBaggageAllowance())
                .version(0)
                .build();

        createSeats(flight, createRequest.getSeats());

        return flightRepository.save(flight);

    }

    private Airport getAirportById(Long airportId) {
        return airportRepository.findById(airportId)
                .orElseThrow(() -> new NoSuchElementException("По id %d не найден аэропорт".formatted(airportId)));
    }

    private void createSeats(Flight flight, List<String> seatCodes) {
        List<Seat> seats = seatCodes.stream()
                .map(seatCode -> new Seat(seatCode, flight))
                .collect(Collectors.toList());

        flight.setSeats(seats);
    }


    @Transactional
    public Flight updateFlight(Long flightId, FlightUpdateRequest updateRequest) {
        Flight existingFlight = flightRepository.findById(flightId)
                .orElseThrow(() -> new NoSuchElementException(String.format(FLIGHT_NOT_FOUND, flightId)));

        Flight newFlight = Flight.builder()
                .flightNumber(existingFlight.getFlightNumber())
                .departureAirport(existingFlight.getDepartureAirport())
                .arrivalAirport(existingFlight.getArrivalAirport())
                .terminal(existingFlight.getTerminal())
                .gate(existingFlight.getGate())
                .departureTime(existingFlight.getDepartureTime())
                .arrivalTime(existingFlight.getArrivalTime())
                .price(existingFlight.getPrice())
                .baggageAllowance(existingFlight.getBaggageAllowance())
                .seats(new ArrayList<>(existingFlight.getSeats()))
                .version(existingFlight.getVersion() + 1)
                .build();

        if (updateRequest.getFlightNumber() != null) {
            newFlight.setFlightNumber(updateRequest.getFlightNumber());
        }
        if (updateRequest.getTerminal() != null) {
            newFlight.setTerminal(updateRequest.getTerminal());
        }
        if (updateRequest.getGate() != null) {
            newFlight.setGate(updateRequest.getGate());
        }
        if (updateRequest.getPrice() != null) {
            newFlight.setPrice(updateRequest.getPrice());
        }


        return flightRepository.save(newFlight);
    }


}



