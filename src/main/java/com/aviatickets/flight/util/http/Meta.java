package com.aviatickets.flight.util.http;

import org.springframework.data.domain.Sort;

public record Meta(
        int page,
        int size,
        long total,
        String sortField,
        Sort.Direction sortDir
) {
}
