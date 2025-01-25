package com.aviatickets.flight.controller.response;

public record ErrorDto(
        String message,
        String status,
        int code
) {
}
