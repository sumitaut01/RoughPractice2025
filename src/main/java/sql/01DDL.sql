1. Users & Profiles
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    status VARCHAR(20) DEFAULT 'active' CHECK (status IN ('active', 'inactive'))
);


SERIAL → auto-increment primary key.

CHECK constraint → allows only active or inactive.

UNIQUE ensures no duplicate usernames or emails.

DEFAULT NOW() auto-fills timestamp.

CREATE TABLE profiles (
    profile_id SERIAL PRIMARY KEY,
    user_id INT UNIQUE REFERENCES users(user_id) ON DELETE CASCADE,
    full_name VARCHAR(100),
    bio TEXT,
    dob DATE
);


One-to-one with users (UNIQUE on user_id).

ON DELETE CASCADE → deleting a user deletes profile automatically.

2. Products
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price NUMERIC(10,2) CHECK (price >= 0),
    stock INT DEFAULT 0 CHECK (stock >= 0),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_products_category ON products(category);


Index on category for faster filtering.

CHECK ensures no negative prices/stock.

3. Orders & Order Items
CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    order_date TIMESTAMP DEFAULT NOW(),
    status VARCHAR(20) CHECK (status IN ('pending','shipped','delivered','cancelled'))
);

CREATE TABLE order_items (
    order_id INT REFERENCES orders(order_id) ON DELETE CASCADE,
    product_id INT REFERENCES products(product_id),
    quantity INT NOT NULL CHECK (quantity > 0),
    price NUMERIC(10,2) NOT NULL,
    PRIMARY KEY(order_id, product_id)
);


Orders: linked to a user.

Order items: composite PK (order_id, product_id).

ON DELETE CASCADE ensures when an order is deleted → its items are removed.

4. Payments
CREATE TABLE payments (
    payment_id SERIAL PRIMARY KEY,
    order_id INT UNIQUE REFERENCES orders(order_id) ON DELETE CASCADE,
    amount NUMERIC(10,2) NOT NULL,
    method VARCHAR(20) CHECK (method IN ('credit_card','debit_card','paypal','upi')),
    paid_at TIMESTAMP DEFAULT NOW()
);


One-to-one with order (UNIQUE order_id).

Supports only valid methods.

5. Audit Logs
CREATE TABLE audit_logs (
    log_id SERIAL PRIMARY KEY,
    table_name VARCHAR(50),
    operation VARCHAR(20),
    changed_at TIMESTAMP DEFAULT NOW(),
    changed_data JSONB
);


Stores history of changes in JSON format.

Trigger function logs INSERT/UPDATE/DELETE for multiple tables.

6. Tags
CREATE TABLE tags (
    tag_id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE,
    metadata JSONB,
    related_tags TEXT[]
);


Example of using arrays (related_tags) and JSONB for flexible metadata.

7. Partitioned Sales Table
CREATE TABLE sales (
    sale_id SERIAL,
    sale_date DATE NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    PRIMARY KEY (sale_id, sale_date)
) PARTITION BY RANGE (sale_date);


Data split into partitions (2025_q1, 2025_q2 etc.) for query performance.

Each partition stores rows based on date ranges.

8. Triggers & Audit Function
CREATE OR REPLACE FUNCTION log_audit_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO audit_logs(table_name, operation, changed_data)
        VALUES (TG_TABLE_NAME, TG_OP, row_to_json(NEW));
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO audit_logs(table_name, operation, changed_data)
        VALUES (TG_TABLE_NAME, TG_OP, json_build_object('old', row_to_json(OLD), 'new', row_to_json(NEW)));
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO audit_logs(table_name, operation, changed_data)
        VALUES (TG_TABLE_NAME, TG_OP, row_to_json(OLD));
    END IF;
    RETURN COALESCE(NEW, OLD);
END;
$$ LANGUAGE plpgsql;


Automatically captures changes in JSON format.

Applied to users, products, orders, order_items, payments.

9. Views
CREATE OR REPLACE VIEW user_orders_summary AS
SELECT
    u.user_id,
    u.username,
    COUNT(o.order_id) AS total_orders,
    COALESCE(SUM(p.amount), 0) AS total_spent
FROM users u
LEFT JOIN orders o ON u.user_id = o.user_id
LEFT JOIN payments p ON o.order_id = p.order_id
GROUP BY u.user_id, u.username;


Shows each user’s total orders & amount spent.

Dynamic view → updates with new data.

10. Materialized View
CREATE MATERIALIZED VIEW best_selling_products AS
SELECT
    p.product_id,
    p.name,
    SUM(oi.quantity) AS total_quantity_sold,
    SUM(oi.quantity * oi.price) AS total_revenue
FROM products p
JOIN order_items oi ON p.product_id = oi.product_id
GROUP BY p.product_id, p.name
ORDER BY total_quantity_sold DESC;


Pre-computes expensive queries (e.g. best sellers).

Needs manual refresh:

REFRESH MATERIALIZED VIEW best_selling_products;


✅ This schema covers core Postgres features:

Constraints (PRIMARY KEY, UNIQUE, CHECK)

Relationships (REFERENCES, ON DELETE CASCADE)

Indexes

JSON & arrays

Partitioning

Triggers & audit logging

Views & materialized views