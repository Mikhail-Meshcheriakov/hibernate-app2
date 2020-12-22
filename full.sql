BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title varchar(255), price integer);
INSERT INTO products (title, price) VALUES
('milk', 56),
('bread', 34),
('eggs', 58),
('cheese', 583),
('flour', 64),
('potatoes', 49),
('tea', 210);

DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers (id bigserial PRIMARY KEY, name varchar(255));
INSERT INTO buyers (name) VALUES
('Ivan'),
('Alex'),
('Mikhail'),
('Anton');

DROP TABLE IF EXISTS buyers_products CASCADE;
CREATE TABLE buyers_products (buyers_id bigint REFERENCES buyers (id), products_id bigint REFERENCES products (id));
INSERT INTO buyers_products (buyers_id, products_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 7),
(2, 2),
(2, 4),
(2, 7),
(3, 1),
(1, 3),
(3, 6),
(3, 7),
(4, 5),
(4, 2),
(4, 4),
(1, 2),
(1, 7),
(2, 4),
(4, 2);

COMMIT;