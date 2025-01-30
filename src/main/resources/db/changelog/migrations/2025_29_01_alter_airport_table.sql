alter table flight_airport
    drop column city,
    add city_id bigint not null,
    add constraint fk_airport_city_id foreign key (city_id) references flight_city (id);

