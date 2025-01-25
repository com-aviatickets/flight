package com.aviatickets.flight.repository;

import com.aviatickets.flight.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AirportRepository extends JpaRepository<Airport, Long>, JpaSpecificationExecutor<Airport> {
}
