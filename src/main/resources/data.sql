-- Create Customer table
CREATE TABLE IF NOT EXISTS customer (
                                        id BIGINT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        email VARCHAR(255) NOT NULL,
                                        phone_number VARCHAR(20) NOT NULL
);

-- Create Item table
CREATE TABLE IF NOT EXISTS item (
                                    id BIGINT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL,
                                    price DECIMAL(10, 2) NOT NULL
);

-- Create Sale table
CREATE TABLE IF NOT EXISTS sale (
                                    id BIGINT PRIMARY KEY,
                                    item_id BIGINT NOT NULL,
                                    sale_date_time TIMESTAMP NOT NULL,
                                    amount DECIMAL(10, 2) NOT NULL,
                                    FOREIGN KEY (item_id) REFERENCES item(id)
);

-- Create Wishlist table
CREATE TABLE IF NOT EXISTS wishlist (
                                        id BIGINT PRIMARY KEY,
                                        customer_id BIGINT NOT NULL,
                                        item_id BIGINT NOT NULL,
                                        FOREIGN KEY (customer_id) REFERENCES customer(id),
                                        FOREIGN KEY (item_id) REFERENCES item(id)
);

-- Insert initial data into Customer table if not exists
INSERT INTO customer (id, name, email, phone_number)
SELECT 1, 'Muradul Mostafa', 'muradul.mostafa@example.com', '1234567890'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 1);

INSERT INTO customer (id, name, email, phone_number)
SELECT 2, 'Jane Smith', 'jane.smith@example.com', '0987654321'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 2);

INSERT INTO customer (id, name, email, phone_number)
SELECT 3, 'John Doe', 'john.doe@example.com', '1122334455'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 3);

INSERT INTO customer (id, name, email, phone_number)
SELECT 4, 'Alice Johnson', 'alice.johnson@example.com', '2233445566'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 4);

INSERT INTO customer (id, name, email, phone_number)
SELECT 5, 'Bob Brown', 'bob.brown@example.com', '3344556677'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 5);

INSERT INTO customer (id, name, email, phone_number)
SELECT 6, 'Carol White', 'carol.white@example.com', '4455667788'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 6);

INSERT INTO customer (id, name, email, phone_number)
SELECT 7, 'David Black', 'david.black@example.com', '5566778899'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 7);

INSERT INTO customer (id, name, email, phone_number)
SELECT 8, 'Eve Green', 'eve.green@example.com', '6677889900'
WHERE NOT EXISTS (SELECT 1 FROM customer WHERE id = 8);

-- Insert initial data into Item table if not exists
INSERT INTO item (id, name, price)
SELECT 1, 'Laptop', 999.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 1);

INSERT INTO item (id, name, price)
SELECT 2, 'Smartphone', 499.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 2);

INSERT INTO item (id, name, price)
SELECT 3, 'Tablet', 299.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 3);

INSERT INTO item (id, name, price)
SELECT 4, 'Headphones', 199.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 4);

INSERT INTO item (id, name, price)
SELECT 5, 'Smartwatch', 149.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 5);

INSERT INTO item (id, name, price)
SELECT 6, 'Camera', 599.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 6);

INSERT INTO item (id, name, price)
SELECT 7, 'Printer', 89.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 7);

INSERT INTO item (id, name, price)
SELECT 8, 'Monitor', 199.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 8);

INSERT INTO item (id, name, price)
SELECT 9, 'Keyboard', 49.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 9);

INSERT INTO item (id, name, price)
SELECT 10, 'Mouse', 29.99
WHERE NOT EXISTS (SELECT 1 FROM item WHERE id = 10);

-- Insert initial data into Wishlist table if not exists
INSERT INTO wishlist (id, customer_id, item_id)
SELECT 1, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 1);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 2, 2, 2
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 2);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 3, 1, 2
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 3);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 4, 3, 1
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 4);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 5, 3, 2
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 5);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 6, 4, 1
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 6);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 7, 4, 2
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 7);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 8, 5, 1
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 8);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 9, 5, 2
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 9);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 10, 6, 1
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 10);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 11, 6, 2
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 11);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 12, 7, 1
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 12);

INSERT INTO wishlist (id, customer_id, item_id)
SELECT 13, 7, 2
WHERE NOT EXISTS (SELECT 1 FROM wishlist WHERE id = 13);

-- Insert initial data into Sale table with dynamic sale_date_time for the current month if not exists
INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 1, 1, NOW(), 999.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 1);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 2, 2, NOW() - INTERVAL 1 DAY, 499.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 2);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 3, 3, NOW() - INTERVAL 2 DAY, 299.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 3);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 4, 4, NOW() - INTERVAL 3 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 4);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 5, 5, NOW() - INTERVAL 4 DAY, 149.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 5);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 6, 6, NOW() - INTERVAL 5 DAY, 599.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 6);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 7, 7, NOW() - INTERVAL 6 DAY, 89.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 7);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 8, 8, NOW() - INTERVAL 7 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 8);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 9, 9, NOW() - INTERVAL 8 DAY, 49.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 9);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 10, 10, NOW() - INTERVAL 9 DAY, 29.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 10);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 11, 1, NOW() - INTERVAL 10 DAY, 999.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 11);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 12, 2, NOW() - INTERVAL 11 DAY, 499.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 12);

-- Insert initial data into Sale table with dynamic sale_date_time for the previous month if not exists
INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 13, 3, NOW() - INTERVAL 1 MONTH, 299.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 13);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 14, 4, NOW() - INTERVAL 1 MONTH - INTERVAL 1 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 14);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 15, 5, NOW() - INTERVAL 1 MONTH - INTERVAL 2 DAY, 149.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 15);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 16, 6, NOW() - INTERVAL 1 MONTH - INTERVAL 3 DAY, 599.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 16);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 17, 7, NOW() - INTERVAL 1 MONTH - INTERVAL 4 DAY, 89.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 17);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 18, 8, NOW() - INTERVAL 1 MONTH - INTERVAL 5 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 18);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 19, 9, NOW() - INTERVAL 1 MONTH - INTERVAL 6 DAY, 49.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 19);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 20, 10, NOW() - INTERVAL 1 MONTH - INTERVAL 7 DAY, 29.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 20);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 21, 1, NOW() - INTERVAL 1 MONTH - INTERVAL 8 DAY, 999.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 21);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 22, 2, NOW() - INTERVAL 1 MONTH - INTERVAL 9 DAY, 499.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 22);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 23, 1, NOW() - INTERVAL 1 MONTH - INTERVAL 10 DAY, 999.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 23);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 24, 2, NOW() - INTERVAL 1 MONTH - INTERVAL 11 DAY, 499.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 24);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 25, 3, NOW() - INTERVAL 1 MONTH - INTERVAL 12 DAY, 299.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 25);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 26, 4, NOW() - INTERVAL 1 MONTH - INTERVAL 13 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 26);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 27, 5, NOW() - INTERVAL 1 MONTH - INTERVAL 14 DAY, 149.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 27);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 28, 6, NOW() - INTERVAL 1 MONTH - INTERVAL 15 DAY, 599.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 28);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 29, 7, NOW() - INTERVAL 1 MONTH - INTERVAL 16 DAY, 89.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 29);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 30, 8, NOW() - INTERVAL 1 MONTH - INTERVAL 17 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 30);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 31, 9, NOW() - INTERVAL 1 MONTH - INTERVAL 18 DAY, 49.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 31);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 32, 10, NOW() - INTERVAL 1 MONTH - INTERVAL 19 DAY, 29.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 32);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 33, 1, NOW() - INTERVAL 1 MONTH - INTERVAL 20 DAY, 999.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 33);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 34, 1, NOW() - INTERVAL 1 MONTH - INTERVAL 21 DAY, 999.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 34);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 35, 3, NOW() - INTERVAL 1 MONTH - INTERVAL 22 DAY, 299.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 35);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 36, 4, NOW() - INTERVAL 1 MONTH - INTERVAL 23 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 36);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 37, 5, NOW() - INTERVAL 1 MONTH - INTERVAL 24 DAY, 149.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 37);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 38, 6, NOW() - INTERVAL 1 MONTH - INTERVAL 25 DAY, 599.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 38);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 39, 7, NOW() - INTERVAL 1 MONTH - INTERVAL 26 DAY, 89.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 39);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 40, 8, NOW() - INTERVAL 1 MONTH - INTERVAL 27 DAY, 199.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 40);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 41, 9, NOW() - INTERVAL 1 MONTH - INTERVAL 28 DAY, 49.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 41);

INSERT INTO sale (id, item_id, sale_date_time, amount)
SELECT 42, 10, NOW() - INTERVAL 1 MONTH - INTERVAL 29 DAY, 29.99
WHERE NOT EXISTS (SELECT 1 FROM sale WHERE id = 42);