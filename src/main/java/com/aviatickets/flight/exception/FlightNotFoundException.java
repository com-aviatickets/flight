package com.aviatickets.flight.exception;

import com.aviatickets.flight.controller.internal.FlightController;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}
