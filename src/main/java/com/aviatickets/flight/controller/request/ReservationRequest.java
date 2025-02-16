package com.aviatickets.flight.controller.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationRequest {
    private Long flightId;
    private String seatNumber;

    public ReservationRequest() {
        this.flightId = flightId;
        this.seatNumber = seatNumber;
    }

}
