package com.aviatickets.flight.controller.request;

import com.aviatickets.flight.model.Flight;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public record FlightFilter(
        Set<String> departureCity,
        Set<String> arrivalCity,
        ZonedDateTime departureTimeFrom,
        ZonedDateTime departureTimeTo,
        ZonedDateTime arrivalTimeFrom,
        ZonedDateTime arrivalTimeTo,
        Integer priceFrom,
        Integer priceTo,
        Integer maxBaggageAllowance
) {

    public Predicate<Flight> toPredicate() {
        return f -> departureCiryPredicate().test(f) &&
                        arrivalCiryPredicate().test(f) &&
                        departureTimePredicate().test(f) &&
                        arrivalTimePredicate().test(f) &&
                        pricePredicate().test(f) &&
                        maxBaggageAllowancePredicate().test(f);
    }

    private Predicate<Flight> departureCiryPredicate() {
        return f -> ObjectUtils.isEmpty(departureCity) || departureCity.contains(f.getDepartureAirport().getCity());
    }

    private Predicate<Flight> arrivalCiryPredicate() {
        return f -> ObjectUtils.isEmpty(arrivalCity) || arrivalCity.contains(f.getArrivalAirport().getCity());
    }

    private Predicate<Flight> departureTimePredicate() {
        return f -> {
            if (departureTimeFrom == null || departureTimeTo == null) {
                return true;
            }
            return departureTimeFrom.isBefore(departureTimeTo) &&
                    f.getDepartureTime().isAfter(departureTimeFrom) &&
                    f.getDepartureTime().isBefore(departureTimeTo);
        };
    }

    private Predicate<Flight> arrivalTimePredicate() {
        return f -> {
            if (arrivalTimeFrom == null || arrivalTimeTo == null) {
                return true;
            }
            return arrivalTimeFrom.isBefore(arrivalTimeTo) &&
                    f.getArrivalTime().isAfter(arrivalTimeFrom) &&
                    f.getArrivalTime().isBefore(arrivalTimeTo);
        };
    }

    private Predicate<Flight> pricePredicate() {
        return f -> {
            if (priceFrom == null || priceTo == null) {
                return true;
            }
            BigDecimal priceFrom = BigDecimal.valueOf(this.priceFrom);
            BigDecimal priceTo = BigDecimal.valueOf(this.priceTo);

            return f.getPrice().compareTo(priceFrom) >= 0 && f.getPrice().compareTo(priceTo) <= 0;
        };
    }

    private Predicate<Flight> maxBaggageAllowancePredicate() {
        return f -> Objects.isNull(maxBaggageAllowance) || f.getBaggageAllowance() >= maxBaggageAllowance;
    }

}
