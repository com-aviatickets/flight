create sequence if not exists flight_city_seq
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;

create table if not exists flight_city (
    id bigint primary key default nextval('flight_city_seq'),
    name varchar not null,
    country varchar not null,
    timezone varchar not null
)