package com.aviatickets.flight.controller.internal;

import com.aviatickets.flight.controller.request.FlightFilter;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.service.FlightService;
import com.aviatickets.flight.util.http.PageableResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.aviatickets.flight.controller.ControllerConstants.INTERNAL;

@RestController
@RequestMapping(INTERNAL + "/flight")
@RequiredArgsConstructor
public class InternalFlightController {

    private final FlightService flightService;

    @GetMapping("/{id}")
    public Flight findById(@PathVariable Long id) {
        return flightService.findById(id);
    }

    @GetMapping
    public PageableResult<Flight> findAll(@PageableDefault Pageable pageable, FlightFilter filter) {
        return flightService.findAll(pageable, filter);
    }

}
