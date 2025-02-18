alter table flight_airport
    drop column if exists name,
    drop column if exists country,
    drop column if exists timezone;