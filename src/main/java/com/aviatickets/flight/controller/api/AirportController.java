package com.aviatickets.flight.controller.api;

import com.aviatickets.flight.controller.request.AirportFilter;
import com.aviatickets.flight.model.Airport;
import com.aviatickets.flight.service.AirportService;
import com.aviatickets.flight.util.http.HttpUtils;
import com.aviatickets.flight.util.http.PageableResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.aviatickets.flight.controller.ControllerConstants.API;

@RestController
@RequestMapping(API + "/airport")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public PageableResult<Airport> getAllAirports(@PageableDefault Pageable pageable, AirportFilter filter) {
        return HttpUtils.pageableOk(airportService.findAll(pageable, filter));
    }

    @GetMapping("/{id}")
    public Airport getAirport(@PathVariable Long id) {
        return airportService.findById(id);
    }

}
