create sequence if not exists flight_airport_seq
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;

create table if not exists flight_airport (
    id bigint primary key default nextval('flight_airport_seq'),
    name varchar not null,
    country varchar not null,
    city varchar not null,
    iata_code varchar not null,
    icao_code varchar not null,
    timezone varchar not null ,
    description varchar,
    site varchar
)