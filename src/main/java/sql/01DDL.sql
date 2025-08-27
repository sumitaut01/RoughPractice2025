CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    status VARCHAR(20) DEFAULT 'active' CHECK (status IN ('active', 'inactive'))
);

CREATE TABLE profiles (
    profile_id SERIAL PRIMARY KEY,
    user_id INT UNIQUE REFERENCES users(user_id) ON DELETE CASCADE,
    full_name VARCHAR(100),
    bio TEXT,
    dob DATE
);


--select * from products
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price NUMERIC(10,2) CHECK (price >= 0),
    stock INT DEFAULT 0 CHECK (stock >= 0),
    created_at TIMESTAMP DEFAULT NOW()
);

-- Index for faster lookups
CREATE INDEX idx_products_category ON products(category);

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

CREATE TABLE payments (
    payment_id SERIAL PRIMARY KEY,
    order_id INT UNIQUE REFERENCES orders(order_id) ON DELETE CASCADE,
    amount NUMERIC(10,2) NOT NULL,
    method VARCHAR(20) CHECK (method IN ('credit_card','debit_card','paypal','upi')),
    paid_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE audit_logs (
    log_id SERIAL PRIMARY KEY,
    table_name VARCHAR(50),
    operation VARCHAR(20),
    changed_at TIMESTAMP DEFAULT NOW(),
    changed_data JSONB
);

CREATE TABLE tags (
    tag_id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE,
    metadata JSONB,
    related_tags TEXT[]
);

CREATE TABLE sales (
    sale_id SERIAL,
    sale_date DATE NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    PRIMARY KEY (sale_id, sale_date)   -- include partition key
) PARTITION BY RANGE (sale_date);

-- Example partitions
CREATE TABLE sales_2025_q1 PARTITION OF sales
FOR VALUES FROM ('2025-01-01') TO ('2025-04-01');

CREATE TABLE sales_2025_q2 PARTITION OF sales
FOR VALUES FROM ('2025-04-01') TO ('2025-07-01');



-- Step 1: Create a function to log changes
CREATE OR REPLACE FUNCTION log_audit_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO audit_logs(table_name, operation, changed_data)
        VALUES (TG_TABLE_NAME, TG_OP, row_to_json(NEW));
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO audit_logs(table_name, operation, changed_data)
        VALUES (TG_TABLE_NAME, TG_OP, json_build_object(
            'old', row_to_json(OLD),
            'new', row_to_json(NEW)
        ));
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO audit_logs(table_name, operation, changed_data)
        VALUES (TG_TABLE_NAME, TG_OP, row_to_json(OLD));
        RETURN OLD;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

-- Step 2: Create triggers on users table
CREATE TRIGGER users_audit_trigger
AFTER INSERT OR UPDATE OR DELETE ON users
FOR EACH ROW EXECUTE FUNCTION log_audit_changes();

-- Step 3: Create triggers on products table
CREATE TRIGGER products_audit_trigger
AFTER INSERT OR UPDATE OR DELETE ON products
FOR EACH ROW EXECUTE FUNCTION log_audit_changes();


-- Trigger function already created earlier:
-- log_audit_changes()

-- Triggers on orders
CREATE TRIGGER orders_audit_trigger
AFTER INSERT OR UPDATE OR DELETE ON orders
FOR EACH ROW EXECUTE FUNCTION log_audit_changes();

-- Triggers on order_items
CREATE TRIGGER order_items_audit_trigger
AFTER INSERT OR UPDATE OR DELETE ON order_items
FOR EACH ROW EXECUTE FUNCTION log_audit_changes();

-- Triggers on payments
CREATE TRIGGER payments_audit_trigger
AFTER INSERT OR UPDATE OR DELETE ON payments
FOR EACH ROW EXECUTE FUNCTION log_audit_changes();


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



--A materialized view to cache heavy queries (manual refresh needed).

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

-- Refresh when needed
REFRESH MATERIALIZED VIEW best_selling_products;
