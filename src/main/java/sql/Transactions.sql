What is a Transaction? (Core Concept)

A transaction is a group of SQL statements that the database treats as one single unit.
A transaction must follow ACID properties:

Atomicity – all or nothing
Consistency – database remains valid
Isolation – each transaction feels private
Durability – once committed, it stays saved

⭐ Transaction Syntax in PostgreSQL

Three main commands:
BEGIN;       -- Start a transaction
COMMIT;      -- Save all changes
ROLLBACK;    -- Undo all changes


Let’s explore each in detail.
1️⃣ BEGIN — Starting a Transaction

When you type:
BEGIN;


PostgreSQL starts a transaction block.

All SQL statements now become part of this transaction until you run:
COMMIT, or
ROLLBACK

If you don’t explicitly call BEGIN, most SQL clients use auto-commit, meaning:
every statement commits automatically.
2️⃣ COMMIT — Save the Changes Permanently
COMMIT makes all changes permanent and visible to all users.

Example:
BEGIN;
UPDATE employee SET sal = sal + 2000 WHERE empid = 110;
COMMIT;


After COMMIT:

You cannot undo it.
Other sessions see the updated data.
3️⃣ ROLLBACK — Undo Everything Back to BEGIN
ROLLBACK cancels everything done since BEGIN.

Example:
BEGIN;
UPDATE employee SET sal = sal + 5000 WHERE empid = 201;
-- Mistake found
ROLLBACK;


Everything returns to original values.

⚠️ After ROLLBACK, you cannot get the changes back again.
4️⃣ SAVEPOINT — Partial Rollback Inside a Transaction

You can mark checkpoints inside a transaction.
SAVEPOINT sp1;


If something goes wrong after this point:
ROLLBACK TO sp1;


This undoes only the commands after sp1, but keeps previous ones.

⭐ Example: Savepoints in Action
BEGIN;

UPDATE employee SET sal = sal + 1000 WHERE empid = 101;

SAVEPOINT step1;

UPDATE employee SET sal = sal + 2000 WHERE empid = 102;

-- something wrong with 102
ROLLBACK TO step1;

COMMIT;

Final result:

Update for emp 101 is saved

Update for emp 102 is undone

Transaction finishes successfully

5️⃣ Nested Savepoints (multiple checkpoints)
BEGIN;

UPDATE employee SET sal = 40000 WHERE empid = 1;

SAVEPOINT sp1;

UPDATE employee SET sal = 30000 WHERE empid = 2;

SAVEPOINT sp2;

UPDATE employee SET sal = 20000 WHERE empid = 3;

ROLLBACK TO sp2; -- undo update for emp 3
ROLLBACK TO sp1; -- undo update for emp 2

COMMIT; -- only update for emp 1 survives

⭐ How PostgreSQL Transaction REALLY Works (Important)
💡 PostgreSQL does not modify the original row directly.

It creates a new version of the row (MVCC – Multi-Version Concurrency Control)

Other sessions see the old version until COMMIT happens.

After COMMIT, others see the new version.

After ROLLBACK, PostgreSQL discards new versions.

This is why PostgreSQL has:

high concurrency

low locking issues

better performance

6️⃣ Transaction Isolation Levels

PostgreSQL supports 4 isolation levels:

Isolation Level	Description	Problems Avoided
READ UNCOMMITTED	Same as READ COMMITTED	none extra
READ COMMITTED (Default)	Most common	avoids dirty reads
REPEATABLE READ	Stronger consistency	avoids dirty + non-repeatable reads
SERIALIZABLE	Full correctness	avoids all anomalies

Example:

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;


I can teach these with clear examples if you want.

7️⃣ Autocommit Mode

Most SQL tools use autocommit:

Each SQL statement = automatically committed.

Example:

UPDATE employee SET sal = 50000;


This executes:

BEGIN (in background)

UPDATE

COMMIT (auto)

To turn off autocommit:

\set AUTOCOMMIT off

⭐ Stored Procedures and Transactions

Functions cannot COMMIT or ROLLBACK.

Stored procedures can.

Example:

CREATE OR REPLACE PROCEDURE sample_proc()
AS $$
BEGIN
    INSERT INTO t VALUES (1);
    COMMIT;

    INSERT INTO t VALUES (2);
    ROLLBACK;  -- legal only in procedures
END;
$$ LANGUAGE plpgsql;

⭐ Summary Table
Command	Use
BEGIN	Start a transaction
COMMIT	Save all changes permanently
ROLLBACK	Undo all changes
SAVEPOINT	Mark a point for partial undo
ROLLBACK TO SAVEPOINT	Undo only to that point
RELEASE SAVEPOINT	Remove a savepoint
Stored Procedures	Support COMMIT/ROLLBACK
Functions	Cannot use COMMIT/ROLLBACK