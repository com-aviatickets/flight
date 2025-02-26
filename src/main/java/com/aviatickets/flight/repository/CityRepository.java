package com.aviatickets.flight.repository;

import com.aviatickets.flight.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c " +
            "where lower(c.name) like lower(concat(:city, '%'))")
    List<City> findByName(@Param("city") String name);
}
