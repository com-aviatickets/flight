package com.aviatickets.flight.service;

import com.aviatickets.flight.controller.request.FlightCreateRequest;
import com.aviatickets.flight.model.Flight;
import com.aviatickets.flight.model.Airport;
import com.aviatickets.flight.repository.FlightRepository;
import com.aviatickets.flight.repository.AirportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class FlightServiceTest {

    @InjectMocks
    FlightService flightService;

    @Mock
    FlightRepository flightRepository;

    @Mock
    AirportRepository airportRepository;

    FlightCreateRequest flightCreateRequest;
    private Airport departureAirport;
    private Airport arrivalAirport;

    @BeforeEach
    void setUp() {
        departureAirport = new Airport();
        departureAirport.setId(1L);

        arrivalAirport = new Airport();
        arrivalAirport.setId(2L);


        flightCreateRequest = new FlightCreateRequest(
                "AB123",
                departureAirport.getId(),
                arrivalAirport.getId(),
                "T1",
                "G12",
                ZonedDateTime.now(),
                ZonedDateTime.now().plusHours(1),
                BigDecimal.valueOf(199.99),
                2,
                List.of("A1", "A2")
        );
    }

    @Test
    void testCreateFlight_AirportsAreTheSame_ShouldThrowIllegalArgumentException() {
        flightCreateRequest = new FlightCreateRequest(
                "AB123",
                departureAirport.getId(),
                departureAirport.getId(),
                "T1",
                "G12",
                ZonedDateTime.now(),
                ZonedDateTime.now().plusHours(1),
                BigDecimal.valueOf(199.99),
                2,
                List.of("A1", "A2")
        );

        when(airportRepository.findById(1L)).thenReturn(Optional.of(departureAirport));
        when(airportRepository.findById(2L)).thenReturn(Optional.of(arrivalAirport));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            flightService.createFlight(flightCreateRequest);
        });

        assertEquals("Аэропорт прибытия и Аэропорт отправления похожи", thrown.getMessage());
    }

    @Test
    void testCreateFlight_AirportsAreDifferent_ShouldCreateFlightSuccessfully() {
        when(airportRepository.findById(eq(1L))).thenReturn(Optional.of(departureAirport));
        when(airportRepository.findById(eq(2L))).thenReturn(Optional.of(arrivalAirport));

        Flight flight = new Flight();
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);
        Flight result = flightService.createFlight(flightCreateRequest);

        assertNotNull(result);
        verify(flightRepository).save(any(Flight.class));
        verify(airportRepository).findById(1L);
        verify(airportRepository).findById(2L);
    }

    @Test
    void testCreateFlight_ShouldThrowExceptionWhenAirportNotFound() {
        when(airportRepository.findById(1L)).thenReturn(Optional.empty());
        when(airportRepository.findById(2L)).thenReturn(Optional.of(arrivalAirport));

        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> {
            flightService.createFlight(flightCreateRequest);
        });

        assertEquals("По id 1 не найден аэропорт", thrown.getMessage());
        verify(airportRepository).findById(1L);
        verify(airportRepository, never()).findById(2L);
    }

    @Test
    void testCreateFlight_ShouldLoadAirportsCorrectly() {
        when(airportRepository.findById(1L)).thenReturn(Optional.of(departureAirport));
        when(airportRepository.findById(2L)).thenReturn(Optional.of(arrivalAirport));

        flightService.createFlight(flightCreateRequest);

        verify(airportRepository).findById(1L);
        verify(airportRepository).findById(2L);
    }
}
