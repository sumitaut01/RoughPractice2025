Q. Nth Highest
select * from sales
sale_id|sale_date |amount  |
-------+----------+--------+
      1|2025-01-05| 5000.00|
      2|2025-02-10|12000.00|
      3|2025-03-15| 8000.00|
      4|2025-04-20|15000.00|
      5|2025-05-18| 6000.00|

      select distinct(a.amount) from sales a
      where 1=( select count(distinct(b.amount)) from sales b where b.amount>a.amount )
      ==>amount  |
         --------+
         12000.00|


         // skip first record  offset means
         SELECT DISTINCT salary
         FROM employees
         ORDER BY salary DESC
         OFFSET 1 LIMIT 1;


--Group By
@. Select * from products
product_id|name      |category   |price   |stock|created_at             |
----------+----------+-----------+--------+-----+-----------------------+
         1|Laptop    |Electronics|75000.00|   10|2025-08-26 22:39:25.181|
         3|Coffee Mug|Home       |  300.00|  200|2025-08-26 22:39:25.181|
         4|Notebook  |Stationery |  120.00|  500|2025-08-26 22:39:25.181|
         5|Backpack  |Travel     | 1500.00|   30|2025-08-26 22:39:25.181|
         2|Headphones|Electronics| 2600.00|   50|2025-08-26 22:39:25.181|

        => give me each category with count of products
         select category,count(*) as count from products p
         group by p.category

         category   |count|
         -----------+-----+
         Electronics|    2|
         Travel     |    1|
         Home       |    1|
         Stationery |    1|


--Group By Having>1
select category,count(*) as countofitems from products p
group by p.category
having count(*)>1

category   |countofitems|
-----------+------------+
Electronics|           2|



Q. Using ranks

--using rank

--RANK() gives you ranking with gaps (if ties exist).

SELECT amount, RANK() OVER (ORDER BY amount DESC) AS rnk
FROM sales;

amount  |rnk|
--------+---+
15000.00|  1|
12000.00|  2|
 8000.00|  3|
 6000.00|  4|
 5000.00|  5|


 --Two rows with 1200 both rank 1. Next is 800 with rank 2.

 --To get 2nd highest:

 SELECT amount
 FROM (
     SELECT amount, RANK() OVER (ORDER BY amount DESC) AS rnk
     FROM sales
 ) ranked
 WHERE rnk = 2;

 =>
 amount  |
 --------+
 12000.00|



--Common table Expression
 --With
 with holder as (
 select * from employees where salary>5000
 )

 select * from holder where name like '%A%'
 --id|name |department_id|salary|
 --+-----+-------------+------+
  1|Alice|            1| 70000|
  8|Alice|            1| 70000|


 select * from temp_contacts

 SELECT
     name,
     phone,
     email,
     alternate_contact,
     COALESCE(phone, email, alternate_contact, 'No contact') AS preferred_contact
 FROM temp_contacts;


 --limit and off set

 SELECT id, name, salary
 FROM employees
 ORDER BY id
 LIMIT 5 OFFSET 5;
 --offset-skip first 5 records
 --limt- shows only 5


 How many employees in each department
 SELECT dept_id, COUNT(emp_id) AS deptwise_emp
 FROM employee
 GROUP BY dept_id;

 🔹 2. Department-wise min, max, avg salary
 SELECT dept_id,
        MIN(salary) AS min_sal,
        MAX(salary) AS max_sal,
        AVG(salary) AS avg_sal
 FROM employee
 GROUP BY dept_id;

 🔹 3. Number of employees joined every month (ascending)
 SELECT DATE_TRUNC('month', hire_date) AS hire_month,
        COUNT(emp_id) AS num_employees
 FROM employee
 GROUP BY hire_month
 ORDER BY hire_month ASC;

 🔹 4. List departments having at least 4 employees
 SELECT dept_id, COUNT(emp_id) AS num_employees
 FROM employee
 GROUP BY dept_id
 HAVING COUNT(emp_id) >= 4;

 🔹 5. How many employees joined in January or September
 SELECT EXTRACT(MONTH FROM hire_date) AS hire_month,
        COUNT(emp_id) AS num_employees
 FROM employee
 WHERE EXTRACT(MONTH FROM hire_date) IN (1, 9)
 GROUP BY hire_month;

 🔹 6. Find duplicate records
 SELECT emp_name, dept_id, hire_date, salary, COUNT(*)
 FROM employee
 GROUP BY emp_name, dept_id, hire_date, salary
 HAVING COUNT(*) > 1;


 (Replace column list with all columns that define uniqueness in your table)

 🔹 7. Display particular number of rows (say rows 41–100)
 SELECT *
 FROM employee
 OFFSET 40  --skips 40
 LIMIT 60; -- restrict results to 60

 🔹 8. Max salary department-wise
 SELECT dept_id, MAX(salary) AS max_sal
 FROM employee
 GROUP BY dept_id;

 🔹 9. Departments having more than 3 employees
 SELECT dept_id, COUNT(emp_id) AS num_employees
 FROM employee
 GROUP BY dept_id
 HAVING COUNT(emp_id) > 3;

 🔹 10. Joins

 Inner Join

 SELECT e.emp_id, e.emp_name, d.dept_name
 FROM employee e
 INNER JOIN department d ON e.dept_id = d.dept_id;


 Left Join

 SELECT e.emp_id, e.emp_name, d.dept_name
 FROM employee e
 LEFT JOIN department d ON e.dept_id = d.dept_id;


 Right Join

 SELECT e.emp_id, e.emp_name, d.dept_name
 FROM employee e
 RIGHT JOIN department d ON e.dept_id = d.dept_id;


 Full Outer Join

 SELECT e.emp_id, e.emp_name, d.dept_name
 FROM employee e
 FULL OUTER JOIN department d ON e.dept_id = d.dept_id;





 in postgres, find 3 employess from all department,  top 3 interms of salary
 ChatGPT said:

 Got it 👍 You want to fetch the top 3 highest-paid employees from each department in PostgreSQL.
 You can do this using ROW_NUMBER() (or RANK() / DENSE_RANK()) with a window function:

 SELECT department_id,
        employee_id,
        employee_name,
        salary
 FROM (
     SELECT e.*,ROW_NUMBER() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rn FROM employees e
 ) t
 WHERE rn <= 3
 ORDER BY department_id, salary DESC;

 Explanation:

 PARTITION BY department_id → ensures ranking restarts for each department.

 ORDER BY salary DESC → assigns highest salary as rank 1.

 ROW_NUMBER() → gives a unique sequence (1,2,3…) even if salaries tie.

 WHERE rn <= 3 → filters top 3 per department.



