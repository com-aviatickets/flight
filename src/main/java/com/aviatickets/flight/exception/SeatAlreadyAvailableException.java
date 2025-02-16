package com.aviatickets.flight.exception;

public class SeatAlreadyAvailableException extends RuntimeException {
    public SeatAlreadyAvailableException(String message) {
        super(message);
    }
}
