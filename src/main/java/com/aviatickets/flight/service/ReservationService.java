package com.aviatickets.flight.service;

import com.aviatickets.flight.exception.FlightNotFoundException;
import com.aviatickets.flight.exception.SeatAlreadyAvailableException;
import com.aviatickets.flight.exception.SeatAlreadyBookedException;
import com.aviatickets.flight.exception.SeatNotFoundException;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Seat;
import com.aviatickets.flight.model.SeatStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final FlightService flightService;
    private final SeatService seatService;

    public String reserveSeat(Long flightId, String seatNumber) throws FlightNotFoundException, SeatNotFoundException, SeatAlreadyBookedException {
        Flight flight = flightService.findById(flightId);
        if (flight == null) {
            throw new FlightNotFoundException("No flight found for this id");
        }

        Seat seat = seatService.findByFlightAndSeatNumber(flight, seatNumber);
        if (seat == null) {
            throw new SeatNotFoundException("There is no seat with this number on this flight");
        }

        if (seat.getStatus() == SeatStatus.BOOKED) {
            throw new SeatAlreadyBookedException("An attempt to book an already booked seat");
        }

        seat.setStatus(SeatStatus.BOOKED);
        seatService.save(seat);
        return "Successfully booked";
    }

    public void cancelReservation(Long flightId, String seatNumber) throws FlightNotFoundException, SeatNotFoundException, SeatAlreadyAvailableException {
        Flight flight = flightService.findById(flightId);
        if (flight == null) {
            throw new FlightNotFoundException("No flight found for this id");
        }

        Seat seat = seatService.findByFlightAndSeatNumber(flight, seatNumber);
        if (seat == null) {
            throw new SeatNotFoundException("There is no seat with this number on this flight");
        }

        if (seat.getStatus() == SeatStatus.AVAILABLE) {
            throw new SeatAlreadyAvailableException("The seat is already available");
        }

        seat.setStatus(SeatStatus.AVAILABLE);
        seatService.save(seat);
    }
}
