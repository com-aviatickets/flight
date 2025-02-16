package com.aviatickets.flight.service;

import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Seat;
import com.aviatickets.flight.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public Seat findByFlightAndSeatNumber(Flight flight, String seatNumber) {
        return seatRepository.findByFlightAndSeatNumber(flight, seatNumber);
    }

    @Transactional
    public void save(Seat seat) {
        seatRepository.save(seat);
    }
}
