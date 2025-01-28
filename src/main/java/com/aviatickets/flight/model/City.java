package com.aviatickets.flight.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flight_city")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_city_seq")
    @SequenceGenerator(
            name = "flight_city_seq",
            sequenceName = "flight_city_seq",
            allocationSize = 1
    )
    private Long id;
    
    private String name;
    private String country;
    private String timezone;
}
