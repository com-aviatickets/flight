package com.aviatickets.flight.service;

import com.aviatickets.flight.controller.request.FlightFilter;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.repository.FlightRepository;
import com.aviatickets.flight.util.http.HttpUtils;
import com.aviatickets.flight.util.http.PageableResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FlightService {

    public static final String FLIGHT_NOT_FOUND = "Flight not found by id %d";

    private final FlightRepository flightRepository;

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
}
