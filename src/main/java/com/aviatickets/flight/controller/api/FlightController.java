package com.aviatickets.flight.controller.api;

import com.aviatickets.flight.controller.request.FlightCreateRequest;
import com.aviatickets.flight.controller.request.FlightUpdateRequest;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static com.aviatickets.flight.controller.ControllerConstants.API;

@RestController
@RequestMapping(API + "/flight")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flight createFlight(@RequestBody FlightCreateRequest createRequest) {
        return flightService.createFlight(createRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody FlightUpdateRequest updateRequest) {
        Flight updatedFlight = flightService.updateFlight(id, updateRequest);
        return ResponseEntity.ok(updatedFlight);
    }

}
