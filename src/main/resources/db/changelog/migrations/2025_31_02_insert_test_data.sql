INSERT INTO flight_flight (id, flight_number, departure_airport_id, arrival_airport_id, terminal, gate, departure_time, arrival_time, price, baggage_allowance)
VALUES
    (1, 'FL123', 1, 2, 'A', '1', '2023-10-01T10:00:00Z', '2023-10-01T12:00:00Z', 150.00, 20),
    (2,'FL234', 1, 3, 'B', '2', '2023-10-02T14:00:00Z', '2023-10-02T16:30:00Z', 200.00, 30),
    (3,'FL345', 2, 1, 'C', '3', '2023-10-03T09:00:00Z', '2023-10-03T11:15:00Z', 180.00, 25),
    (4,'FL456', 2, 3, 'D', '4', '2023-10-04T13:00:00Z', '2023-10-04T15:45:00Z', 220.00, 15),
    (5,'FL567', 3, 1, 'E', '5', '2023-10-05T11:00:00Z', '2023-10-05T13:30:00Z', 160.00, 20),
    (6,'FL678', 3, 2, 'F', '6', '2023-10-06T08:00:00Z', '2023-10-06T10:00:00Z', 190.00, 30),
    (7,'FL789', 1, 2, 'G', '7', '2023-10-07T15:00:00Z', '2023-10-07T17:00:00Z', 170.00, 20),
    (8,'FL890', 2, 3, 'H', '8', '2023-10-08T12:00:00Z', '2023-10-08T14:30:00Z', 210.00, 25),
    (9,'FL901', 3, 1, 'I', '9', '2023-10-09T16:00:00Z', '2023-10-09T18:00:00Z', 155.00, 20),
    (10,'FL012', 1, 3, 'J', '10', '2023-10-10T10:30:00Z', '2023-10-10T12:45:00Z', 230.00, 30);

INSERT INTO flight_seat (seat_number, status, flight_id) VALUES
    ('1A', 'AVAILABLE', 1),
    ('1B', 'AVAILABLE', 1),
    ('1C', 'AVAILABLE', 1),
    ('1D', 'AVAILABLE', 1),
    ('1E', 'AVAILABLE', 1),

    ('2A', 'AVAILABLE', 2),
    ('2B', 'AVAILABLE', 2),
    ('2C', 'AVAILABLE', 2),
    ('2D', 'AVAILABLE', 2),
    ('2E', 'AVAILABLE', 2),

    ('3A', 'AVAILABLE', 3),
    ('3B', 'AVAILABLE', 3),
    ('3C', 'AVAILABLE', 3),
    ('3D', 'AVAILABLE', 3),
    ('3E', 'AVAILABLE', 3),

    ('4A', 'AVAILABLE', 4),
    ('4B', 'AVAILABLE', 4),
    ('4C', 'AVAILABLE', 4),
    ('4D', 'AVAILABLE', 4),
    ('4E', 'AVAILABLE', 4),

    ('5A', 'AVAILABLE', 5),
    ('5B', 'AVAILABLE', 5),
    ('5C', 'AVAILABLE', 5),
    ('5D', 'AVAILABLE', 5),
    ('5E', 'AVAILABLE', 5),

    ('6A', 'AVAILABLE', 6),
    ('6B', 'AVAILABLE', 6),
    ('6C', 'AVAILABLE', 6),
    ('6D', 'AVAILABLE', 6),
    ('6E', 'AVAILABLE', 6),

    ('7A', 'AVAILABLE', 7),
    ('7B', 'AVAILABLE', 7),
    ('7C', 'AVAILABLE', 7),
    ('7D', 'AVAILABLE', 7),
    ('7E', 'AVAILABLE', 7),

    ('8A', 'AVAILABLE', 8),
    ('8B', 'AVAILABLE', 8),
    ('8C', 'AVAILABLE', 8),
    ('8D', 'AVAILABLE', 8),
    ('8E', 'AVAILABLE', 8),

    ('9A', 'AVAILABLE', 9),
    ('9B', 'AVAILABLE', 9),
    ('9C', 'AVAILABLE', 9),
    ('9D', 'AVAILABLE', 9),
    ('9E', 'AVAILABLE', 9),

    ('10A', 'AVAILABLE', 10),
    ('10B', 'AVAILABLE', 10),
    ('10C', 'AVAILABLE', 10),
    ('10D', 'AVAILABLE', 10),
    ('10E', 'AVAILABLE', 10);