package com.aviatickets.flight.service;

import com.aviatickets.flight.model.City;
import com.aviatickets.flight.repository.CityRepository;
import com.aviatickets.flight.util.http.ListResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static com.aviatickets.flight.util.http.HttpUtils.listOk;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
public class CityServiceTest {

    private final CityService service;

    @Autowired
    public CityServiceTest(CityRepository repository) {
        this.service = new CityService(repository);
    }

    @Test
    @DisplayName("GET http://localhost:8080/api/city?name={cityName} 200")
    public void givenCities_whenFindByName_thenReturnListResult() {

        String cityName = "washington, D.C.";
        ListResult<City> actual = service.findCity(cityName);
        ListResult<City> expected = listOk(generateValidCityData());

        assertThat(actual).isNotNull();
        assertThat(actual.data().size()).isEqualTo(expected.data().size());
        assertThat(actual.data().stream()
                .findFirst()
                .get()
                .getName()
                .toLowerCase()).isEqualTo(expected.data().stream()
                .findFirst()
                .get()
                .getName()
                .toLowerCase());
    }

    @Test
    @DisplayName("GET http://localhost:8080/api/city?name={cityNameIsEmptyOrNull} 200")
    public void givenCities_whenFindByName_withIncorrectParameters_thenReturnEmptyListResult() {

        String cityNameIsEmpty = "";
        String cityNameIsLessThenThree = "ho";

        ListResult<City> actualWithEmptyName = service.findCity(cityNameIsEmpty);
        ListResult<City> actualNameIsLessThenThree = service.findCity(cityNameIsLessThenThree);
        ListResult<City> expected = listOk(new ArrayList<>());


        assertThat(actualWithEmptyName).isNotNull();
        assertThat(actualWithEmptyName.data().size()).isEqualTo(expected.data().size());

        assertThat(actualNameIsLessThenThree).isNotNull();
        assertThat(actualNameIsLessThenThree.data().size()).isEqualTo(expected.data().size());

        assertThat(service.findCity(null)).isNotNull();
        assertThat(service.findCity(null).data().size()).isEqualTo(expected.data().size());
    }

    private List<City> generateValidCityData() {
        List<City> cities = new ArrayList<>();
        cities.add(new City(2L, "Washington, D.C.", "South Korea", "NST"));
        return cities;
    }
}
