CREATE TABLE IF NOT EXISTS customer
(
    id    serial unique PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL,
    email VARCHAR(254) NOT NULL,
    phone VARCHAR(50)  NOT NULL
    );

CREATE TABLE orders
(
    id serial unique PRIMARY KEY ,
    created_date  timestamp  NOT NULL ,
    customer_id integer NOT NULL ,
    number integer NOT NULL,
    FOREIGN KEY (customer_id)  REFERENCES customer(id)
    );

CREATE TABLE IF NOT EXISTS order_detail
(
    id    serial unique PRIMARY KEY ,
    order_id integer NOT NULL,
    flower_id  integer,
    bouquet_id  integer,
    quantity integer NOT NULL,
    FOREIGN KEY (order_id)  REFERENCES orders(id),
    FOREIGN KEY (flower_id)  REFERENCES flower(id),
    FOREIGN KEY (bouquet_id)  REFERENCES bouquet(id)
);

CREATE TABLE IF NOT EXISTS flower
(
    id    serial PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    price integer NOT NULL
);

CREATE TABLE IF NOT EXISTS bouquet
(
    id  serial unique PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    price integer NOT NULL,
    package_id integer,
FOREIGN KEY (package_id)  REFERENCES package(id)
    );

CREATE TABLE IF NOT EXISTS package
(
    id    serial unique PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    price integer NOT NULL
    );

CREATE TABLE IF NOT EXISTS bouquet_detail
(
    id serial unique PRIMARY KEY ,
    flower_id integer NOT NULL,
    bouquet_id integer NOT NULL,
    quantity integer NOT NULL,
    FOREIGN KEY (bouquet_id)  REFERENCES bouquet(id),
    FOREIGN KEY (flower_id)  REFERENCES flower(id)
    );
