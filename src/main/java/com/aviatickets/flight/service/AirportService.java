package com.aviatickets.flight.service;

import com.aviatickets.flight.controller.request.AirportFilter;
import com.aviatickets.flight.model.Airport;
import com.aviatickets.flight.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static com.aviatickets.flight.repository.specification.AirportSpecification.byFilter;

@Service
@RequiredArgsConstructor
public class AirportService {

    public static final String AIRPORT_NOT_FOUND = "Airport not found by id %d";

    private final AirportRepository repository;

    public Page<Airport> findAll(@PageableDefault Pageable pageable, AirportFilter filter) {
        return repository.findAll(byFilter(filter), pageable);
    }

    public Airport findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException(AIRPORT_NOT_FOUND.formatted(id)));
    }

}
