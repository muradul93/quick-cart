-- Create Customer table
# CREATE TABLE customer (
#                           id BIGINT PRIMARY KEY,
#                           name VARCHAR(255) NOT NULL,
#                           email VARCHAR(255) NOT NULL,
#                           phone_number VARCHAR(20) NOT NULL
# );
#
# -- Create Item table
# CREATE TABLE item (
#                       id BIGINT PRIMARY KEY,
#                       name VARCHAR(255) NOT NULL,
#                       price DECIMAL(10, 2) NOT NULL
# );
#
# -- Create Sale table
# CREATE TABLE sale (
#                       id BIGINT PRIMARY KEY,
#                       item_id BIGINT NOT NULL,
#                       sale_date_time TIMESTAMP NOT NULL,
#                       amount DECIMAL(10, 2) NOT NULL,
#                       FOREIGN KEY (item_id) REFERENCES item(id)
# );
#
# -- Create Wishlist table
# CREATE TABLE wishlist (
#                           id BIGINT PRIMARY KEY,
#                           customer_id BIGINT NOT NULL,
#                           item_id BIGINT NOT NULL,
#                           FOREIGN KEY (customer_id) REFERENCES customer(id),
#                           FOREIGN KEY (item_id) REFERENCES item(id)
# );

-- Insert initial data into Customer table
INSERT INTO customer (id, name, email, phone_number) VALUES (1, 'Muradul Mostafa', 'muradul.mostafa@example.com', '1234567890');
INSERT INTO customer (id, name, email, phone_number) VALUES (2, 'Jane Smith', 'jane.smith@example.com', '0987654321');
INSERT INTO customer (id, name, email, phone_number) VALUES (3, 'John Doe', 'john.doe@example.com', '1122334455');
INSERT INTO customer (id, name, email, phone_number) VALUES (4, 'Alice Johnson', 'alice.johnson@example.com', '2233445566');
INSERT INTO customer (id, name, email, phone_number) VALUES (5, 'Bob Brown', 'bob.brown@example.com', '3344556677');
INSERT INTO customer (id, name, email, phone_number) VALUES (6, 'Carol White', 'carol.white@example.com', '4455667788');
INSERT INTO customer (id, name, email, phone_number) VALUES (7, 'David Black', 'david.black@example.com', '5566778899');
INSERT INTO customer (id, name, email, phone_number) VALUES (8, 'Eve Green', 'eve.green@example.com', '6677889900');

-- Insert initial data into Item table
INSERT INTO item (id, name, price) VALUES (1, 'Laptop', 999.99);
INSERT INTO item (id, name, price) VALUES (2, 'Smartphone', 499.99);
INSERT INTO item (id, name, price) VALUES (3, 'Tablet', 299.99);
INSERT INTO item (id, name, price) VALUES (4, 'Headphones', 199.99);
INSERT INTO item (id, name, price) VALUES (5, 'Smartwatch', 149.99);
INSERT INTO item (id, name, price) VALUES (6, 'Camera', 599.99);
INSERT INTO item (id, name, price) VALUES (7, 'Printer', 89.99);
INSERT INTO item (id, name, price) VALUES (8, 'Monitor', 199.99);
INSERT INTO item (id, name, price) VALUES (9, 'Keyboard', 49.99);
INSERT INTO item (id, name, price) VALUES (10, 'Mouse', 29.99);

-- Insert initial data into Wishlist table
INSERT INTO wishlist (id, customer_id, item_id) VALUES (1, 1, 1);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (2, 2, 2);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (3, 1, 2);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (4, 3, 1);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (5, 3, 2);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (6, 4, 1);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (7, 4, 2);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (8, 5, 1);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (9, 5, 2);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (10, 6, 1);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (11, 6, 2);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (12, 7, 1);
INSERT INTO wishlist (id, customer_id, item_id) VALUES (13, 7, 2);

-- Insert additional data into Sale table for the current month
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (1, 1, '2024-08-01T10:00:00', 999.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (2, 2, '2024-08-02T11:00:00', 499.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (3, 3, '2024-08-01T10:00:00', 299.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (4, 4, '2024-08-02T11:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (5, 5, '2024-08-03T12:00:00', 149.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (6, 6, '2024-08-04T13:00:00', 599.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (7, 7, '2024-08-05T14:00:00', 89.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (8, 8, '2024-08-06T15:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (9, 9, '2024-08-07T16:00:00', 49.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (10, 10, '2024-08-08T17:00:00', 29.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (11, 1, '2024-08-09T18:00:00', 999.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (12, 2, '2024-08-10T19:00:00', 499.99);




-- Insert additional data into Sale table for the previous month
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (13, 3, '2024-07-01T10:00:00', 299.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (14, 4, '2024-07-02T11:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (15, 5, '2024-07-03T12:00:00', 149.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (16, 6, '2024-07-04T13:00:00', 599.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (17, 7, '2024-07-05T14:00:00', 89.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (18, 8, '2024-07-06T15:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (19, 9, '2024-07-07T16:00:00', 49.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (20, 10, '2024-07-08T17:00:00', 29.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (21, 1, '2024-07-09T18:00:00', 999.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (22, 2, '2024-07-10T19:00:00', 499.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (23, 1, '2024-07-11T10:00:00', 999.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (24, 2, '2024-07-12T11:00:00', 499.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (25, 3, '2024-07-13T12:00:00', 299.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (26, 4, '2024-07-14T13:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (27, 5, '2024-07-15T14:00:00', 149.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (28, 6, '2024-07-16T15:00:00', 599.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (29, 7, '2024-07-17T16:00:00', 89.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (30, 8, '2024-07-18T17:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (31, 9, '2024-07-19T18:00:00', 49.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (32, 10, '2024-07-20T19:00:00', 29.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (33, 1, '2024-07-21T10:00:00', 999.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (34, 1, '2024-07-21T10:00:00', 999.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (35, 3, '2024-07-23T12:00:00', 299.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (36, 4, '2024-07-24T13:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (37, 5, '2024-07-25T14:00:00', 149.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (38, 6, '2024-07-26T15:00:00', 599.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (39, 7, '2024-07-27T16:00:00', 89.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (40, 8, '2024-07-28T17:00:00', 199.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (41, 9, '2024-07-29T18:00:00', 49.99);
INSERT INTO sale (id, item_id, sale_date_time, amount) VALUES (42, 10, '2024-07-30T19:00:00', 29.99);