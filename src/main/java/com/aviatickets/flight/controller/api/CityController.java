package com.aviatickets.flight.controller.api;

import com.aviatickets.flight.model.City;
import com.aviatickets.flight.service.CityService;
import com.aviatickets.flight.util.http.ListResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.aviatickets.flight.controller.ControllerConstants.API;

@RestController
@RequestMapping(API + "/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ListResult<City> getCityByName(@RequestParam String name) {
        return cityService.findCity(name);
    }
}
