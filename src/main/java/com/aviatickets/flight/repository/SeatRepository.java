package com.aviatickets.flight.repository;

import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findByFlightAndSeatNumber(Flight flight, String seatNumber);
}
