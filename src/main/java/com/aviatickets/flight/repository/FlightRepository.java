package com.aviatickets.flight.repository;

import com.aviatickets.flight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
