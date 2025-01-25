package com.aviatickets.flight.util.http;

import java.util.Collection;

public record UnpagedResult <T>(
        Collection<? extends T> data,
        Meta meta
) {
}
