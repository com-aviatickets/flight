package com.aviatickets.flight.service;

import com.aviatickets.flight.model.City;
import com.aviatickets.flight.repository.CityRepository;
import com.aviatickets.flight.util.http.ListResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.aviatickets.flight.util.http.HttpUtils.listOk;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository repository;

    public ListResult<City> findCity(String name) {
        if (name == null || name.length() < 3) {
            return listOk(new ArrayList<>());
        }
        return listOk(repository.findByName(name));
    }

}
