package com.aviatickets.flight.service;

import com.aviatickets.flight.exception.FlightNotFoundException;
import com.aviatickets.flight.exception.SeatNotFoundException;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Seat;
import com.aviatickets.flight.model.SeatStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {
    @InjectMocks
    private ReservationService reservationService;
    @Mock
    private FlightService flightService;
    @Mock
    private SeatService seatService;

    private Flight flight;
    private Seat seat;

    @BeforeEach
    public void SetUp() {
        MockitoAnnotations.openMocks(this);
        flight = new Flight();
        flight.setId(1L);
        seat = new Seat();
        seat.setSeatNumber("1A");
        seat.setStatus(SeatStatus.AVAILABLE);
    }
    @Test
    public void testReserveSeat_Success() throws Exception {
        Long flightId = 1L;
        String seatNumber = "1A";

        when(flightService.findById(flightId)).thenReturn(flight);
        when(seatService.findByFlightAndSeatNumber(flight, seatNumber)).thenReturn(Optional.of(seat));
        reservationService.reserveSeat(flightId, seatNumber);
        assertEquals(SeatStatus.BOOKED, seat.getStatus());
        verify(seatService, times(1)).save(seat);
    }
    @Test
    public void testReserveSeat_FlightNotFound() {
        Long flightId = 1L;
        String seatNumber = "1A";

        when(flightService.findById(flightId)).thenThrow(new FlightNotFoundException("No flight found for this id"));
        Exception exception = assertThrows(FlightNotFoundException.class, () -> {
            reservationService.reserveSeat(flightId, seatNumber);
        });
        assertEquals("No flight found for this id", exception.getMessage());
    }
    @Test
    public void testReserveSeat_SeatNotFound() {
        Long flightId = 1L;
        String seatNumber = "1A";

        when(flightService.findById(flightId)).thenReturn(flight);
        when(seatService.findByFlightAndSeatNumber(flight, seatNumber)).thenReturn(Optional.empty());

        Exception exception = assertThrows(SeatNotFoundException.class, () -> {
            reservationService.reserveSeat(flightId, seatNumber);
        });
        assertEquals("There is no seat with this number on this flight", exception.getMessage());
    }
    @Test
    public void testCancelReservation_SeatAlreadyAvailable() {
        Long flightId = 1L;
        String seatNumber = "1A";
        seat.setStatus(SeatStatus.AVAILABLE);

        when(flightService.findById(flightId)).thenReturn(flight);
        when(seatService.findByFlightAndSeatNumber(flight, seatNumber)).thenReturn(Optional.of(seat));
        reservationService.cancelReservation(flightId, seatNumber);
        verify(seatService, never()).save(seat);
    }
}
