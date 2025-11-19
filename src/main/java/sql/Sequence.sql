What is a Sequence?

A sequence is a special database object that provides a continuous series of integers.
It is independent of any table and can be used anywhere you need unique numbers.

🔹 Why sequences?
They are commonly used when you want something like:

Auto-increment primary keys
Invoice numbers
Order IDs

🔹 Example: Creating a sequence
CREATE SEQUENCE user_id_seq
START 1
INCREMENT BY 1;

🔹 Using a sequence
SELECT nextval('user_id_seq');   -- Gets the next number
SELECT currval('user_id_seq');   -- Gets the last number in this session
SELECT setval('user_id_seq', 100);  -- Manually set value

🔹 Using a sequence for a table column
CREATE TABLE users (
    id BIGINT DEFAULT nextval('user_id_seq'),
    name TEXT
);

🔹 Modern PostgreSQL alternative: SERIAL or GENERATED

Postgres provides shortcuts:

✔ Using SERIAL
Automatically creates and links a sequence:

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name TEXT
);

✔ Using identity columns (recommended):
CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT
);

📝 Summary
Feature	Description
Sequence	Object generating unique auto-increment numbers
nextval()	Get the next number
currval()	Get the most recent value used
SERIAL	Shortcut to auto-increment
IDENTITY	Standard SQL way to auto-increment