CREATE SEQUENCE IF NOT EXISTS stock_id_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS stocks (
    id bigint PRIMARY KEY DEFAULT nextval('stock_id_seq'),
    name VARCHAR(255) NOT NULL,
    price double precision default 0.0,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);