package com.aviatickets.flight.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "flight_flight")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_flight_seq")
    @SequenceGenerator(
            name = "flight_flight_seq",
            sequenceName = "flight_flight_seq",
            allocationSize = 1
    )
    private Long id;
    private String flightNumber;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;
    private String terminal;
    private String gate;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private BigDecimal price;
    private Integer availableSeats;
    private Integer baggageAllowance;


}
