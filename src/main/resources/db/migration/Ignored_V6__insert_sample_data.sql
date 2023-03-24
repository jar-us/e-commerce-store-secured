-- Insert data into the categories table:
INSERT INTO categories (name) VALUES ('Electronics');
INSERT INTO categories (name) VALUES ('Clothing');
INSERT INTO categories (name) VALUES ('Books');
INSERT INTO categories (name) VALUES ('Appliances');
INSERT INTO categories (name) VALUES ('Sports');
INSERT INTO categories (name) VALUES ('Toys');
INSERT INTO categories (name) VALUES ('Furniture');
INSERT INTO categories (name) VALUES ('Food');
INSERT INTO categories (name) VALUES ('Beauty');
INSERT INTO categories (name) VALUES ('Jewelry');
INSERT INTO categories (name) VALUES ('Movies');
INSERT INTO categories (name) VALUES ('Gardening');
INSERT INTO categories (name) VALUES ('Pet Supplies');


-- Insert data into the products table:
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('iPhone 13', 'Latest Apple iPhone model', 999.00, 50, 1);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('T-shirt', 'Cotton T-shirt', 19.99, 100, 2);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Harry Potter and the Philosopher''s Stone', 'Fantasy novel by J.K. Rowling', 10.99, 200, 3);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Refrigerator', 'Large capacity refrigerator', 999.00, 50, 1);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Basketball', 'Official size basketball', 19.99, 100, 2);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('LEGO Star Wars', 'Building set based on Star Wars movie', 79.99, 200, 3);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Sofa', 'Comfortable sofa for your living room', 799.00, 20, 4);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Organic Apples', 'Fresh organic apples from local farm', 2.99, 500, 5);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Lipstick', 'Long-lasting matte lipstick', 12.99, 300, 6);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Diamond Earrings', 'Stunning diamond earrings', 999.99, 10, 7);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('The Matrix', 'Science fiction movie directed by the Wachowskis', 9.99, 1000, 8);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Gardening Gloves', 'Durable gardening gloves', 7.99, 200, 9);
INSERT INTO products (name, description, price, stock_quantity, category_id) VALUES ('Dog Food', 'Healthy dog food for all breeds', 29.99, 100, 10);



-- Insert data into the customers table:
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('John', 'Doe', 'john.doe@example.com', '123 Main St', 'New York', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Jane', 'Smith', 'jane.smith@example.com', '456 Market St', 'Los Angeles', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Amy', 'Lee', 'amy.lee@example.com', '789 Broadway', 'Chicago', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Tom', 'Smith', 'tom.smith@example.com', '987 Pine St', 'San Francisco', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Emily', 'Johnson', 'emily.johnson@example.com', '345 Oak Ave', 'Miami', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Adam', 'Brown', 'adam.brown@example.com', '543 Maple Blvd', 'Dallas', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Maggie', 'Nguyen', 'maggie.nguyen@example.com', '432 Pine St', 'Los Angeles', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('David', 'Wong', 'david.wong@example.com', '3456 Main St', 'New York', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Rachel', 'Garcia', 'rachel.garcia@example.com', '678 Elm St', 'San Francisco', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Lucas', 'Chen', 'lucas.chen@example.com', '987 Oak Ave', 'Chicago', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Anna', 'Kim', 'anna.kim@example.com', '1234 Maple Blvd', 'Miami', 'USA');
INSERT INTO customers (first_name, last_name, email, address, city, country) VALUES ('Steven', 'Taylor', 'steven.taylor@example.com', '5678 Pine St', 'Dallas', 'USA');



-- Insert data into the orders table:
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (1, '2023-03-20 12:00:00', 1019.99, 'Processing');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (2, '2023-03-20 15:30:00', 30.98, 'Shipped');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (1, '2023-03-20 12:00:00', 1019.99, 'Processing');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (2, '2023-03-20 15:30:00', 30.98, 'Shipped');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (3, '2023-03-21 09:00:00', 150.00, 'Processing');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (4, '2023-03-21 11:30:00', 599.00, 'Cancelled');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (5, '2023-03-21 13:00:00', 10.99, 'Shipped');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (6, '2023-03-21 14:30:00', 200.00, 'Processing');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (7, '2023-03-21 15:30:00', 40.00, 'Shipped');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (8, '2023-03-21 16:00:00', 499.99, 'Processing');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (9, '2023-03-21 17:30:00', 70.00, 'Shipped');
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES (10, '2023-03-21 19:00:00', 1500.00, 'Processing');


-- Insert data into the order_items table:
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (1, 1, 1, 999.00);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (1, 2, 1, 19.99);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (2, 3, 2, 10.99);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (1, 1, 1, 999.00);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (1, 2, 1, 19.99);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (2, 3, 2, 10.99);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (3, 4, 1, 150.00);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (4, 5, 1, 599.00);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (5, 6, 1, 10.99);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (6, 7, 2, 100.00);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (7, 8, 1, 40.00);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (8, 9, 1, 499.99);
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (9, 10, 2, 35.00);



