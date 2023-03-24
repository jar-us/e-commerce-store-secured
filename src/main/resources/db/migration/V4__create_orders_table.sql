-- Create the orders table
CREATE TABLE orders
(
    id           SERIAL PRIMARY KEY,
    customer_id  INTEGER        NOT NULL,
    order_date   TIMESTAMP      NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    status       VARCHAR(255)   NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers (id)
);