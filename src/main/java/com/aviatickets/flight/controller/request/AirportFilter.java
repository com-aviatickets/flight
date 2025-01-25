package com.aviatickets.flight.controller.request;

import java.util.Set;

public record AirportFilter(
        Set<Long> id,
        Set<String> name,
        Set<String> country,
        Set<String> city,
        Set<String> iataCode,
        Set<String> icaoCode,
        Set<String> timezone
        ) {
}
