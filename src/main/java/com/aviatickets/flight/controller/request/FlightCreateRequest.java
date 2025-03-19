package com.aviatickets.flight.controller.request;


import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Value
public class FlightCreateRequest {
    String flightNumber;
    Long departureAirportId;
    Long arrivalAirportId;
    String terminal;
    String gate;
    ZonedDateTime departureTime;
    ZonedDateTime arrivalTime;
    BigDecimal price;
    Integer baggageAllowance;
    List<String> seats;



}
