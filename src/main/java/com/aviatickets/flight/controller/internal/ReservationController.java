package com.aviatickets.flight.controller.internal;

import com.aviatickets.flight.controller.request.ReservationRequest;
import com.aviatickets.flight.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.aviatickets.flight.controller.ControllerConstants.INTERNAL;

@RestController
@RequestMapping(INTERNAL + "/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<String> reserveSeat (@RequestBody ReservationRequest request) {
        String responseMessage = reservationService.reserveSeat(request.getFlightId(), request.getSeatNumber());
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping
    public ResponseEntity<Void> cancelReservation (@RequestParam Long flightId, @RequestParam String seatNumber) {
        reservationService.cancelReservation(flightId, seatNumber);
        return ResponseEntity.noContent().build();
    }
}
