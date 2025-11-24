Why use a cursor?

Cursors are helpful when:

You need to process large result sets without loading everything into memory.
You need to perform some logic on each row one at a time.

You are writing loops in PL/pgSQL.

🔹 Basic Cursor Workflow

Declare the cursor
Open it
Fetch rows from it
Close it

🔹 Example: Using a cursor in psql (SQL shell)
BEGIN;

DECLARE emp_cursor CURSOR FOR
    SELECT empid, sal FROM employee ORDER BY sal DESC;

FETCH NEXT FROM emp_cursor;   -- Returns first row
FETCH NEXT FROM emp_cursor;   -- Next row...

CLOSE emp_cursor;

COMMIT;

🔹 Cursor inside a PL/pgSQL function
DO $$
DECLARE
    rec RECORD;
    cur CURSOR FOR SELECT empid, sal FROM employee;
BEGIN
    OPEN cur;

    LOOP
        FETCH cur INTO rec;
        EXIT WHEN NOT FOUND;

        RAISE NOTICE 'Employee: %, Salary: %', rec.empid, rec.sal;
    END LOOP;

    CLOSE cur;
END $$;

🔹 Types of cursors
Cursor Type	Description
Simple cursor	Default, forward-only
Scrollable cursor	Allows moving forward/backward
WITH HOLD cursor	Remains open after COMMIT
NO SCROLL cursor	Only forward movement

Example of scrollable cursor:

DECLARE c1 SCROLL CURSOR FOR SELECT * FROM employee;

🔹 Important Notes

Cursors are read-only unless declared FOR UPDATE.

Slower than set-based operations—use only when needed.

Commonly used inside backend logic, not typical user SQL.

Summary

A cursor in PostgreSQL = a mechanism to iterate through query results row-by-row, mainly used in stored procedures and functions when you need procedural control.




Here are clear, practical examples of using a cursor in PostgreSQL, including reading rows and updating rows with a cursor.

✅ 1. SIMPLE CURSOR EXAMPLE (row-by-row reading)

This example loops through all employees and prints their salary.

DO $$
DECLARE
    rec RECORD;
    cur CURSOR FOR
        SELECT empid, sal
        FROM employee
        ORDER BY empid;
BEGIN
    OPEN cur;

    LOOP
        FETCH cur INTO rec;
        EXIT WHEN NOT FOUND;

        RAISE NOTICE 'EmpID: %, Salary: %', rec.empid, rec.sal;
    END LOOP;

    CLOSE cur;
END $$;

What it does:

Declares a cursor cur

Opens it

Loops and fetches one row at a time

Prints each row

Closes the cursor

✅ 2. CURSOR WITH UPDATE (updating rows from a cursor)

This increases salary by 10% for employees of dept 10.

DO $$
DECLARE
    rec employee%ROWTYPE;

    -- Cursor that locks rows for update
    cur CURSOR FOR
        SELECT * FROM employee WHERE dept = 10 FOR UPDATE;
BEGIN
    OPEN cur;

    LOOP
        FETCH cur INTO rec;
        EXIT WHEN NOT FOUND;

        UPDATE employee
        SET sal = sal * 1.10
        WHERE CURRENT OF cur;
    END LOOP;

    CLOSE cur;
END $$;

Notes:

FOR UPDATE locks rows so you can update them safely.

WHERE CURRENT OF cur updates exactly the row currently fetched.

✅ 3. SCROLLABLE CURSOR (move forward/backward)
BEGIN;

DECLARE emp_cur SCROLL CURSOR FOR
    SELECT empid, sal FROM employee ORDER BY sal DESC;

FETCH NEXT FROM emp_cur;   -- Highest salary
FETCH NEXT FROM emp_cur;   -- Next highest

FETCH PRIOR FROM emp_cur;  -- Move back one row

CLOSE emp_cur;

COMMIT;

✅ 4. CURSOR WITH HOLD (stays open after COMMIT)
BEGIN;

DECLARE emp_cur CURSOR WITH HOLD FOR
    SELECT * FROM employee;

COMMIT;

FETCH NEXT FROM emp_cur;  -- Still works (cursor survived COMMIT)

📝 Summary of what you now have

✔ Simple cursor
✔ Cursor that updates rows
✔ Scrollable cursor
✔ Cursor that survives commit