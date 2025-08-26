--drop table users
--
--drop table profiles
--drop table products
--drop table orders
--drop table payments
--
--drop table tags
--drop table order_items
--drop table sales

-- Insert into users
INSERT INTO users (username, email, status) VALUES
('alice', 'alice@example.com', 'active'),
('bob', 'bob@example.com', 'inactive'),
('charlie', 'charlie@example.com', 'active'),
('diana', 'diana@example.com', 'active');

-- Insert into profiles (1:1 with users)
INSERT INTO profiles (user_id, full_name, bio, dob) VALUES
(1, 'Alice Johnson', 'Love shopping and books', '1990-05-12'),
(2, 'Bob Smith', 'Coffee addict and coder', '1988-11-23'),
(3, 'Charlie Brown', 'Runner and traveler', '1995-03-07');

-- Insert into products
INSERT INTO products (name, category, price, stock) VALUES
('Laptop', 'Electronics', 75000.00, 10),
('Headphones', 'Electronics', 2500.00, 50),
('Coffee Mug', 'Home', 300.00, 200),
('Notebook', 'Stationery', 120.00, 500),
('Backpack', 'Travel', 1500.00, 30);

-- Insert into orders
INSERT INTO orders (user_id, status) VALUES
(1, 'pending'),
(1, 'shipped'),
(2, 'delivered'),
(3, 'cancelled'),
(4, 'pending');

-- Insert into order_items (M:N orders ↔ products)
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 75000.00),  -- Alice ordered a Laptop
(1, 2, 2, 2500.00),   -- Alice also ordered 2 Headphones
(2, 3, 4, 300.00),    -- Alice’s 2nd order, Coffee Mugs
(3, 5, 1, 1500.00),   -- Bob ordered a Backpack
(4, 4, 10, 120.00);   -- Charlie ordered 10 Notebooks

-- Insert into payments (1:1 with orders)
INSERT INTO payments (order_id, amount, method) VALUES
(1, 80000.00, 'credit_card'),
(2, 1200.00, 'upi'),
(3, 1500.00, 'paypal');

-- Insert into tags (JSON + Arrays)
INSERT INTO tags (name, metadata, related_tags) VALUES
('electronics', '{"type": "category", "popular": true}', ARRAY['gadgets','tech']),
('stationery', '{"type": "category", "popular": false}', ARRAY['school','office']),
('travel', '{"type": "category"}', ARRAY['bags','outdoor']);

-- Insert into sales (partitioned table)
INSERT INTO sales (sale_date, amount) VALUES
('2025-01-05', 5000.00),
('2025-02-10', 12000.00),
('2025-03-15', 8000.00),
('2025-04-20', 15000.00),
('2025-05-18', 6000.00);




-- Insert into users
INSERT INTO users (username, email, status) VALUES ('eve', 'eve@example.com', 'active');

-- Update a product
UPDATE products SET price = 2600 WHERE product_id = 2;

-- Delete a user
DELETE FROM users WHERE user_id = 2;

-- Check audit logs
SELECT * FROM audit_logs ORDER BY changed_at DESC;


INSERT INTO orders (user_id, status) VALUES (1, 'pending');

-- Update an order
UPDATE orders SET status = 'shipped' WHERE order_id = 1;

-- Insert order_items
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (1, 3, 2, 300.00);

-- Delete a payment
DELETE FROM payments WHERE payment_id = 2;

-- See all logs
SELECT log_id, table_name, operation, changed_data, changed_at
FROM audit_logs
ORDER BY log_id DESC;

SELECT * FROM user_orders_summary ORDER BY total_spent DESC;


--Window Functions – ranking orders by value

--A query to rank each user’s orders by total amount spent.

SELECT
    o.order_id,
    u.username,
    SUM(oi.quantity * oi.price) AS order_total,
    RANK() OVER (PARTITION BY u.user_id ORDER BY SUM(oi.quantity * oi.price) DESC) AS order_rank
FROM orders o
JOIN users u ON o.user_id = u.user_id
JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id, u.username, u.user_id
ORDER BY u.username, order_rank;


