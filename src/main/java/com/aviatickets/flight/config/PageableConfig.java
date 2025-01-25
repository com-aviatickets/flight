package com.aviatickets.flight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.data.web.config.SortHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfig {

    private static final int DEFAULT_PAGE_NUMBER = 1;
    private static final int DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;
    private static final String DEFAULT_SORT_FIELD = "id";


    @Bean
    public PageableHandlerMethodArgumentResolverCustomizer customizer() {
        return pageableResolver -> {
            //по умолчанию Spring поддерживает максимальный размер страницы 2000
            pageableResolver.setMaxPageSize(Integer.MAX_VALUE);
            pageableResolver.setFallbackPageable(
                    PageRequest.of(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE, Sort.by(DEFAULT_SORT_FIELD).ascending())
            );
        };
    }

    @Bean
    SortHandlerMethodArgumentResolverCustomizer sortResolverCustomizer() {
        return sortResolver -> sortResolver.setFallbackSort(Sort.by(DEFAULT_SORT_FIELD).ascending());
    }

}
