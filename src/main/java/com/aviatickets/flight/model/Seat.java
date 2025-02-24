package com.aviatickets.flight.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flight_seat")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
