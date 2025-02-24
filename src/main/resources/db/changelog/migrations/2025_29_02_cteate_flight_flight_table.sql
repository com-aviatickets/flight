create sequence if not exists flight_flight_seq
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;

create table if not exists flight_flight (
    id bigint primary key default nextval('flight_flight_seq'),
    flight_number varchar not null,
    departure_airport_id bigint not null,
    arrival_airport_id bigint not null,
    terminal varchar,
    gate varchar,
    departure_time timestamp with time zone,
    arrival_time timestamp with time zone,
    price decimal(10, 2),
    baggage_allowance int,
    foreign key (departure_airport_id) references flight_airport(id),
    foreign key (arrival_airport_id) references flight_airport(id)
    );