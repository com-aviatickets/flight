package com.aviatickets.flight.controller.request;

import java.util.Set;

public record AirportFilter(
        Set<Long> id,
        Set<String> city,
        Set<String> iataCode,
        Set<String> icaoCode
        ) {
}
