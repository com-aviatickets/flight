create sequence if not exists flight_seat_seq
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;

create table if not exists flight_seat (
    id bigint primary key default nextval('flight_seat_seq'),
    seat_number varchar not null,
    status varchar not null,
    flight_id bigint not null,
    foreign key (flight_id) references flight_flight(id)
    );