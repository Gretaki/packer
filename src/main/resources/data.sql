insert into item (name, amount, max_amount, unit, scalable_by_distance, scalable_by_night, seasons) values
('First Aid', 1, 1, 'units', false, false, null),
('Sleeping Bag', 1, 1, 'units', false, true, null),
('Tent', 1, 1, 'units', false, true, null),
('Water', 0.1, 3, 'litres', true, false, null),
('Snacks', 0.01, 1, 'kilograms', true, false, null),
('Full Meal', 2, 10, 'units', false, true, null),
('Socks', 1, 5, 'pairs', false, true, null),
('T-shirt', 1, 5, 'units', false, true, null),
('Rain Jacket', 1, 1, 'units', false, true, 'SPRING,AUTUMN'),
('Sun Protection', 1, 1,'units', false, true, 'SUMMER')
;
