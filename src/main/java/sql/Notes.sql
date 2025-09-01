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


 //limit and off set

 SELECT id, name, salary
 FROM employees
 ORDER BY id
 LIMIT 5 OFFSET 5;
 --offset-skip first 5 records
 --limt- shows only 5