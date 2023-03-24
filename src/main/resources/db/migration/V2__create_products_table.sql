-- Create the products table
CREATE TABLE products
(
    id             SERIAL PRIMARY KEY,
    name           VARCHAR(255)   NOT NULL,
    description    TEXT,
    price          NUMERIC(10, 2) NOT NULL,
    stock_quantity INTEGER        NOT NULL,
    category_id    INTEGER,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);