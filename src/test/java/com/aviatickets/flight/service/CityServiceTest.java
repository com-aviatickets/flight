package com.aviatickets.flight.service;

import com.aviatickets.flight.model.City;
import com.aviatickets.flight.repository.CityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    @Mock
    private CityRepository repository;

    @InjectMocks
    private CityService service;

    @Test
    @DisplayName("GET http://localhost:8080/api/city?name={cityName} 200")
    public void givenCities_whenFindByName_thenReturnListResult() {

        City houston = new City(1L, "Houston", "Canada", "America/Vancouver");
        List<City> allCities = List.of(houston);
        String cityName = "houston";

        when(repository.findByName(cityName)).thenReturn(allCities);

        assertThat(service.findCity(cityName)).isNotNull();
        assertThat(service.findCity(cityName).data().size()).isEqualTo(1);
        assertThat(service.findCity(cityName).data().stream()
                .findFirst()
                .get()
                .getName()
                .toLowerCase()).isEqualTo(cityName.toLowerCase());
    }

    @Test
    @DisplayName("GET http://localhost:8080/api/city?name={cityNameIsEmptyOrNull} 200")
    public void givenCities_whenFindByName_withIncorrectParameters_thenReturnEmptyListResult() {

        String cityNameIsEmpty = "";
        String cityNameIsLessThenThree = "ho";

        lenient().when(repository.findByName(cityNameIsEmpty)).thenReturn(new ArrayList<>());
        assertThat(service.findCity(cityNameIsEmpty)).isNotNull();
        assertThat(service.findCity(cityNameIsEmpty).data().size()).isEqualTo(0);

        lenient().when(repository.findByName(null)).thenReturn(new ArrayList<>());
        assertThat(service.findCity(null)).isNotNull();
        assertThat(service.findCity(null).data().size()).isEqualTo(0);

        lenient().when(repository.findByName(cityNameIsLessThenThree)).thenReturn(new ArrayList<>());
        assertThat(service.findCity(cityNameIsLessThenThree)).isNotNull();
        assertThat(service.findCity(cityNameIsLessThenThree).data().size()).isEqualTo(0);
    }
}
