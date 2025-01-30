package com.aviatickets.flight.util.http;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Collection;

@SuppressWarnings("unused")
public class HttpUtils {

    public static <T> ListResult<T> listOk(Collection<T> collection) {
        return new ListResult<>(collection);
    }

    public static <T> PageableResult<T> pageableOk(Page<T> page) {
        Meta meta = composeMetaObject(page);
        return new PageableResult<>(page.getContent(), meta);
    }

    public static <T> UnpagedResult<T> unpagedOk(Collection<T> all) {
        return new UnpagedResult<>(all, new Meta(1, all.size(), all.size(), null, null));
    }

    public static <T> PageableResult<T> pageableOk(Collection<T> all, int page, int size, long total,Sort sort) {
        Meta meta = new Meta(page, size, total, extractSortProperty(sort), extractSortDir(sort));
        return new PageableResult<>(all, meta);
    }

    private static <T> Meta composeMetaObject(Page<T> page) {
        return new Meta(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                extractSortProperty(page.getSort()),
                extractSortDir(page.getSort())
        );
    }

    private static <T> Sort.Direction extractSortDir(Sort sort) {
        return sort.stream().findFirst().map(Sort.Order::getDirection).orElse(null);
    }

    private static String extractSortProperty(Sort sort) {
        return sort.stream().findFirst().map(Sort.Order::getProperty).orElse(null);
    }



}
