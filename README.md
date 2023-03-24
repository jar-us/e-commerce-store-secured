# E-Commerce Store

The E-Commerce Store Management System is a user-friendly online platform that streamlines e-commerce operations. It
emphasizes designing and implementing a robust database schema to handle core functions like product catalog management,
customer management, and order processing.

This Spring Boot project utilizes Flyway, Spring Data JPA, and PostgreSQL, featuring tables for categories, products,
customers, orders, and order items.

---

## Database

The database schema consists of five main tables:

<b>Categories Table</b>: This table stores information about the different product categories available in the
e-commerce
store. Each category has a unique ID and a name.

<b>Products Table</b>: The products table contains detailed information about each product, including its name,
description,
price, stock quantity, and associated category. A foreign key constraint is used to link the products to their
respective categories.

<b>Customers Table</b>: This table holds essential information about the customers, such as their first name, last name,
email
address, physical address, city, and country. The email field is unique to prevent duplicate accounts.

<b>Orders Table</b>: The orders table stores data related to customer orders, including a unique order ID, the
associated
customer ID, order date, total amount, and order status. A foreign key constraint is used to link the orders to the
corresponding customers.

<b>Order Items Table</b>: This table maintains information about the individual items in each order, such as the order
ID,
product ID, quantity, and price. Foreign key constraints are used to link the order items to the corresponding orders
and products.

By implementing this database schema, the E-Commerce Store can efficiently manage product catalogs,
customer accounts, and order processing, ensuring a smooth and reliable e-commerce experience for both customers and
businesses.

---

## Prerequisites

### Before running the tests:

You need to have Postgres container running and a database named postgres created.
Additionally, you need to have a Postgres container with the following details:

- Name: postgres_db_test
- Username: postgres
- Password: 123
- Port mapping: 5433:5432

You can use the following command to start the container:

```shell
docker run --name postgres-test-db -e POSTGRES_PASSWORD=123 -p 5433:5432 -d postgres
```

### Before starting application:

You need to have Postgres container running and a database named postgres created.
Additionally, you need to have a Postgres container with the following details:

- Name: postgres_db_test
- Username: postgres
- Password: 123
- Port mapping: 5432:5432

You can use the following command to start the container:

```shell
docker run --name postgres-db -e POSTGRES_PASSWORD=123 -p 5432:5432 -d postgres
```

---

## Running the project

You can run the project using the following command:

```shell
./mvnw spring-boot:run
```

---

## Running the tests

```shell
./mvnw test
```

---

## Build with

- Spring Boot
- Spring Data JPA
- Flyway
- Postgres
- Maven

---

## Author

- [Suraj Sharma](https://github.com/jar-us)

---

