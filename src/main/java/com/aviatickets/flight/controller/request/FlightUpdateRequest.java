package com.aviatickets.flight.controller.request;


import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class FlightUpdateRequest {
    String flightNumber;
    String terminal;
    String gate;
    BigDecimal price;
}
