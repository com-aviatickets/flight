INSERT INTO flight_city (id, name, country, timezone) VALUES
 (1, 'Jacksonville', 'India', 'HKT'),
 (2, 'Washington, D.C.', 'South Korea', 'NST'),
 (3, 'New York', 'United States', 'UTC'),
 (4, 'Denver, D.C.', 'South Korea', 'NST'),
 (5, 'Charlotte', 'Russia', 'ADT');

INSERT INTO flight_airport (id, city_id, iata_code, icao_code, description, site) VALUES
 (1, (SELECT id from flight_city WHERE id = 5), 'ZCP', 'KIMF', 'Praeclaram beate vivendi et apertam et simplicem et directam viam! Cum enim certe nihil homini possit melius esse quam Graecam. Quando enim nobis, vel dicam aut oratoribus bonis aut poetis, postea quidem.', 'JNARwytVBI'),
 (2, (SELECT id from flight_city WHERE id = 4), 'UDP', 'HRDW', 'Quam ostendis. Sed uti oratione perpetua malo quam.', 'cXih'),
 (3, (SELECT id from flight_city WHERE id = 3), 'MJJ', 'UJWN', 'Adipiscing elit, sed do eiusmod tempor incididunt ut labore et.', 'uEiKTUMp'),
 (4, (SELECT id from flight_city WHERE id = 2), 'CQG', 'ICBP', 'Torquatis.'' Numquam hoc ita defendit Epicurus neque Metrodorus aut quisquam eorum, qui aut saperet aliquid aut ista didicisset. Et quod adest sentire possumus, animo autem et praeterita grate meminit et.', 'sZI'),
 (5, (SELECT id from flight_city WHERE id = 1), 'DDE', 'XWWP', 'Petat aut fugiat aliquid, praeter voluptatem et parvam et non necessariam et quae fugiamus refert.', 'tHeSaAPd');
