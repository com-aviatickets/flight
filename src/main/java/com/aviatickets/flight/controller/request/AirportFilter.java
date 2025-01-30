package com.aviatickets.flight.controller.request;

import com.aviatickets.flight.model.City;

import java.util.Set;

public record AirportFilter(
        Set<Long> id,
        Set<City> city,
        Set<String> iataCode,
        Set<String> icaoCode
        ) {
}
