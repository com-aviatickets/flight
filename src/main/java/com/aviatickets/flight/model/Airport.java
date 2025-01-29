package com.aviatickets.flight.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="city_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City city;
    private String iataCode;
    private String icaoCode;
    private String description;
    private String site;

}
