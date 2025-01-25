package com.aviatickets.flight.controller.internal;

import com.aviatickets.flight.model.Airport;
import com.aviatickets.flight.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.aviatickets.flight.controller.ControllerConstants.INTERNAL;

@RestController
@RequestMapping(INTERNAL + "/airport")
@RequiredArgsConstructor
public class InternalAirportController {

    private final AirportService airportService;

   @GetMapping("/{id}")
    public Airport findById(@PathVariable Long id) {
        return airportService.findById(id);
    }

}
