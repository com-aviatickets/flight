package com.aviatickets.flight.repository.specification;

import com.aviatickets.flight.controller.request.AirportFilter;
import com.aviatickets.flight.model.Airport;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AirportSpecification {

    public static final String ID_FIELD = "id";
    public static final String NAME_FIELD = "name";
    public static final String COUNTRY_FIELD = "country";
    public static final String CITY_FIELD = "city";
    public static final String IATA_CODE_FIELD = "iataCode";
    public static final String ICAO_CODE_FIELD = "icaoCode";
    public static final String TIMEZONE_FIELD = "timezone";

    public static Specification<Airport> byFilter(AirportFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (ObjectUtils.isNotEmpty(filter.id())) {
                predicates.add(root.get(ID_FIELD).in(filter.id()));
            }

            if (ObjectUtils.isNotEmpty(filter.name())) {
                predicates.add(root.get(NAME_FIELD).in(filter.name()));
            }

            if (ObjectUtils.isNotEmpty(filter.country())) {
                predicates.add(root.get(COUNTRY_FIELD).in(filter.country()));
            }

            if (ObjectUtils.isNotEmpty(filter.city())) {
                predicates.add(root.get(CITY_FIELD).in(filter.city()));
            }

            if (ObjectUtils.isNotEmpty(filter.iataCode())) {
                predicates.add(root.get(IATA_CODE_FIELD).in(filter.iataCode()));
            }

            if (ObjectUtils.isNotEmpty(filter.icaoCode())) {
                predicates.add(root.get(ICAO_CODE_FIELD).in(filter.icaoCode()));
            }

            if (ObjectUtils.isNotEmpty(filter.timezone())) {
                predicates.add(root.get(TIMEZONE_FIELD).in(filter.timezone()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
