package com.aviatickets.flight.service;

import com.aviatickets.flight.exception.FlightNotFoundException;
import com.aviatickets.flight.exception.SeatAlreadyBookedException;
import com.aviatickets.flight.exception.SeatNotFoundException;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Seat;
import com.aviatickets.flight.model.SeatStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {
    private final FlightService flightService;
    private final SeatService seatService;
    @Transactional
    public void reserveSeat(Long flightId, String seatNumber) throws FlightNotFoundException, SeatNotFoundException, SeatAlreadyBookedException {
        Flight flight = flightService.findById(flightId);

        Seat seat = seatService.findByFlightAndSeatNumber(flight, seatNumber)
                .orElseThrow(() -> new SeatNotFoundException("There is no seat with this number on this flight"));

        if (seat.getStatus() == SeatStatus.BOOKED) {
            throw new SeatAlreadyBookedException("An attempt to book an already booked seat");
        }

        seat.setStatus(SeatStatus.BOOKED);
        seatService.save(seat);
    }
    @Transactional
    public void cancelReservation(Long flightId, String seatNumber) throws FlightNotFoundException, SeatNotFoundException {
        Flight flight = flightService.findById(flightId);

        Seat seat = seatService.findByFlightAndSeatNumber(flight, seatNumber)
                .orElseThrow(() -> new SeatNotFoundException("There is no seat with this number on this flight"));

        if (seat.getStatus() == SeatStatus.AVAILABLE) {
            log.info("Attempt to cancel reservation for an already available seat: {}", seatNumber);
            return;
        }
    }
}
