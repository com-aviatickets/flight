package com.aviatickets.flight.service;

import com.aviatickets.flight.exception.FlightNotFoundException;
import com.aviatickets.flight.exception.SeatAlreadyBookedException;
import com.aviatickets.flight.exception.SeatNotFoundException;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Seat;
import com.aviatickets.flight.model.SeatStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final FlightService flightService;
    private final SeatService seatService;
    @Transactional
    public String reserveSeat(Long flightId, String seatNumber) throws FlightNotFoundException, SeatNotFoundException, SeatAlreadyBookedException {
        Flight flight = flightService.findById(flightId);

        Optional<Seat> optionalSeat = seatService.findByFlightAndSeatNumber(flight, seatNumber);
        if (optionalSeat.isEmpty()) {
            throw new SeatNotFoundException("There is no seat with this number on this flight");
        }

        Seat seat = optionalSeat.get();
        if (seat.getStatus() == SeatStatus.BOOKED) {
            throw new SeatAlreadyBookedException("An attempt to book an already booked seat");
        }

        seat.setStatus(SeatStatus.BOOKED);
        seatService.save(seat);
        return "Successfully booked";
    }
    @Transactional
    public void cancelReservation(Long flightId, String seatNumber) throws FlightNotFoundException, SeatNotFoundException {
        Flight flight = flightService.findById(flightId);

        Optional<Seat> optionalSeat = seatService.findByFlightAndSeatNumber(flight, seatNumber);
        if (optionalSeat.isEmpty()) {
            throw new SeatNotFoundException("There is no seat with this number on this flight");
        }

        Seat seat = optionalSeat.get();
        if (seat.getStatus() == SeatStatus.AVAILABLE) {
            System.out.println("Attempt to cancel reservation for an already available seat: " + seatNumber);
            return;
        }

        seat.setStatus(SeatStatus.AVAILABLE);
        seatService.save(seat);
    }
}
