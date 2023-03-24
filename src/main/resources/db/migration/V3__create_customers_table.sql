-- Create the customers table
CREATE TABLE customers
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(255)        NOT NULL,
    last_name  VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    address    TEXT                NOT NULL,
    city       VARCHAR(255)        NOT NULL,
    country    VARCHAR(255)        NOT NULL
);