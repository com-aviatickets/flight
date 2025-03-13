package com.aviatickets.flight.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    @JsonIgnore
    private Flight flight;

    public Seat(String seatCode, Flight flight) {
        this.seatNumber = seatCode;
        this.flight = flight;
        this.status = SeatStatus.AVAILABLE;
    }
}
