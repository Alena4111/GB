INSERT INTO customer (name, email, phone) VALUES
('Егор Иванов', '111@jr.com', '+7 (191) 322-22-33'),
('Ольга', '222@jr.com', '+7 (191) 223-33-22');

INSERT INTO package (name, price) VALUES
('Органза', '1000'),
('Плёнка', '200'),
('Сетка', '1200'),
('Фетр', '500');

INSERT INTO flower (name, price) VALUES
('Роза', '200'),
('Хризантема', '150'),
('Пион', '400'),
('Лилия', '500'),
('Гипсофила', '200'),
('Ромашка', '100');

INSERT INTO bouquet (name, price, package_id) VALUES
('Букет с 9 розами', '2500', (select p.id from package p where p.name = 'Органза')),
('Букет с 7 розами', '2300', (select p.id from package p where p.name = 'Плёнка')),
('Букет красный', '3000', (select p.id from package p where p.name = 'Сетка')),
('Букет розовый', '2000', (select p.id from package p where p.name = 'Сетка')),
('Букет праздничный', '5000', (select p.id from package p where p.name = 'Фетр'));
;

INSERT INTO bouquet_detail (flower_id, bouquet_id, quantity) VALUES
((select f.id from flower f where f.name = 'Роза'),(select b.id from bouquet b where b.name = 'Букет с 9 розами'), 9),
((select f.id from flower f where f.name = 'Роза'),(select b.id from bouquet b where b.name = 'Букет с 7 розами'), 7),
((select f.id from flower f where f.name = 'Хризантема'),(select b.id from bouquet b where b.name = 'Букет красный'), 4),
((select f.id from flower f where f.name = 'Роза'),(select b.id from bouquet b where b.name = 'Букет красный'), 3),
((select f.id from flower f where f.name = 'Пион'),(select b.id from bouquet b where b.name = 'Букет розовый'), 5),
((select f.id from flower f where f.name = 'Гипсофила'),(select b.id from bouquet b where b.name = 'Букет розовый'), 1),
((select f.id from flower f where f.name = 'Лилия'),(select b.id from bouquet b where b.name = 'Букет праздничный'), 1),
((select f.id from flower f where f.name = 'Ромашка'),(select b.id from bouquet b where b.name = 'Букет праздничный'), 3),
((select f.id from flower f where f.name = 'Роза'),(select b.id from bouquet b where b.name = 'Букет праздничный'), 5);

INSERT INTO orders (created_date, customer_id, number) VALUES
('01-01-2022', (select c.id from customer c where c.name = 'Егор Иванов'), '11'),
('03-20-2022', (select c.id from customer c where c.name = 'Егор Иванов'), '12'),
('03-07-2022', (select c.id from customer c where c.name = 'Ольга'), '13');

INSERT INTO order_detail (order_id, flower_id, bouquet_id, quantity) VALUES
((select o.id from orders o where o.number = '11'), (select f.id from flower f where f.name = 'Роза'), null, '33'),
((select o.id from orders o where o.number = '11'), (select f.id from flower f where f.name = 'Хризантема'), null, '13'),
((select o.id from orders o where o.number = '12'), null, (select b.id from bouquet b where b.name = 'Букет красный'), '1'),
((select o.id from orders o where o.number = '13'), null, (select b.id from bouquet b where b.name = 'Букет праздничный'), '4');