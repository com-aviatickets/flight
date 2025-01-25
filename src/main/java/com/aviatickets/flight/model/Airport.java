package com.aviatickets.flight.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flight_airport")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_airport_seq")
    @SequenceGenerator(
            name = "flight_airport_seq",
            sequenceName = "flight_airport_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String country;
    private String city;
    private String iataCode;
    private String icaoCode;
    private String timezone;
    private String description;
    private String site;

}
