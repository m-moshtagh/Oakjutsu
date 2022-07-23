# SQL

Structured Query Language is the language we talk to our Database.

## Query:

Basically all the questions we want to ask from database we use query.

`SELECT [IDENTIFIER] FROM [EXPRESSION];`

This is a simple query or clause.

We can use wildcards like * as identifiers.
In SQL, we can use condition in our query with WHERE keyword.

SQL is a Declarative language which we just announce what we need, and we don't care what happens behind the back. But
Imperative programming We just state everything that needs to be done.

### Categories of SQL commands:

- DCL(Data Control Language): We can Grant or Revoke access
- DDL(Data Definition Language): In order to define or modify our structures we use DDL. Commands like Create, Alger,
  Drop, Truncate, Rename and Comment.
- DQL(Data Query Language): In order to retrieve data select is vital.
- DML(Data Modification Language): We use these commands to interact with data inside database. Insert, Update, Delete,
  Merge, Call, Explain Plan and Lock table.

### SELECT:

IN order to retrieve data from database we can use SELECT.

` SELECT [COLUMNS_TO_FETCH] FROM "SCHEMA_NAME"."TABLE_NAME";`

#### Alias:

WE can also select a field and if the name doesn't look cool we can show it with an alias. we use AS keyword.

`SELECT "emp_no" AS "Employee #" FROM "SCHEMA"."TABLE";`

When we use Functions() We lose column name so, We need to declare an alias after the function call in order to show it.

#### DISTINCT:

We can remove duplicate results in select command using DISTINCT keyword.

`SELECT DISTINCT * FROM TABLE;`

### Filtering Data:

In order to answer more complex queries we need to filter them using WHERE clause and combine them with Logical
operators.

```roomsql
select count("gender") from "public"."customers" 
where gender='F' AND (state='OR' OR state='NSY');
``` 

> In order to chain the where clause with conditions we need to be careful with the operator precedence.

To exclude something in our filter we use NOT keyword.

```roomsql
Select count("firstname") from "public"."customers"
WHERE NOT "age" = 55;
```

> We can specify ranges in our where clause using comparison operators.

The operator precedence is like below:

1. parentheses
2. Multiplication / Division
3. Subtraction / Addition
4. Not
5. AND
6. OR

 ```roomsql
SELECT username from "customers"
    where (age < 30
    OR age >= 50) AND "income" > 50000
    AND  ("country"='Japan'
    OR "country"='Australia');
```

#### Checking null values:

Sometimes we might have null values in our record. First we need to make sure that our required data is not nullable.
In order to check the null value we can use IS keyword. This keyword is capable of checking the null and boolean values.
We also have a function named coalesce(column_name, fallback_value) which can replace null values. We can use it on
multiple columns.

SQL has a three valued Logic system which the result may be true, false and null based on the queries filtering.
We need to be careful about null stuff.

#### filter ranges using: BETWEEN x AND y

This is a more convenient way to filter between ranges than using comparison operators.

```roomsql
SELECT * FROM sql_store.customers c 
	WHERE c.birth_date BETWEEN '1990-1-1' AND '2000-1-1';
``` 

#### IN keyword

Check if a value matches any value in a list of values.
These values are comma separated values inside parentheses.

```roomsql
SELECT * FROM employees where emp_no IN (10001, 10003, 11020);
 -- instead of
 -- WHERE emp-no=foo OR emp_no=bar ...
```

```roomsql
SELECT count(orderId) as number_of_orders FROM orders
 WHERE customerId IN (7888, 1082, 12808, 9623);
```

#### filtering using LIKE keyword:

In order to filter what we may partially know we use LIKE keyword.

```roomsql
SELECT * FROM customers WHERE customerName LIKE 'M%';
```

Patterns is as following:

* %: Any number of characters
* _: One character

Examples:

* LIKE '%2': Fields that end with 2
* LIKE '%2%': Fields that have 2 anywhere in the value
* LIKE '_00%': Fields that have 2 zeros as the second and third character and anything afterward.
* LIKE '2_%_%': Finds any character that start with 2 and are at least 3 characters in length.
* LIKE '2__3': finds any 5 digits number that start with 2 and end with 3.

NOTE: Postgres only uses text for LIKE so, we may need to cast our properties with CAST() function or use :: operator.
CAST(salary AS text); || salary :: text;

NOTE: for insensitive cast we can use LIKE keyword.

> SELECT count( customerId ) FROM customers
> WHERE zip :: text LIKE '%2%'

> SELECT count( customerId ) FROM customers
> WHERE zip :: text LIKE '2_1%'

> SELECT coalesce(state, 'No State') as "State" FROM customers
> WHERE phone::text LIKE '302%';

#### Filtering using REGEXP operator

We can use `REGEXP` instead of `LIKE` and pass regular expression to match String values.

```roomsql
SELECT * FROM sql_store.customers c 
	WHERE c.first_name REGEXP "ELKA|AMBUR";
```

```roomsql
SELECT * FROM sql_store.customers c 
	WHERE c.last_name  REGEXP "EY$|ON$";
```

```roomsql
SELECT * FROM sql_store.customers c 
	WHERE c.last_name  REGEXP "^MY|SE";
```

```roomsql
SELECT * FROM sql_store.customers c 
	WHERE c.last_name  REGEXP "B[RU]";
```

#### Sort using ORDER BY

We can SORT our result with `ORDER BY` keyword. by default the queries are sorted with PK in ascending order. We can
sort with multiple parameters. In MYSQL we can also filter certain columns but sort them with other columns in table,
however This is not applicable in other databases, you can only sort via columns you have filtered.

```roomsql
SELECT *, quantity * unit_price AS total_price
	FROM sql_store.order_items oi 
	WHERE oi.order_id = 2 ORDER BY total_price DESC;
```

> We can also pass numbers to ORDER BY indicating the columns we have filtered base in precedence. This is not best
> practice because the sorting will change if we modify query.

```roomsql
SELECT name, age FROM person ORDER BY 1, 2 ASC;
```

#### LIMIT queries

We can Limit number of rows in result using `LIMIT` keyword. This LIMIT can optionally accept two numbers that indicate
offset. We can use this in pagination.

For example, we want 1-3 in first page and 3-6 in second and 6-9 in third page. offset should be the number which we
want to skip. for third page we need to pass `LIMIT 6, 3` which ignores first 6 results and shows three next results.

### Functions:

We have two kinds of functions: Aggregate and Scalar. Aggregate functions take all the data and produce one result. like
sum(). Scalar functions run against each individual record So we get multiple outputs.

- concat():
  We can concat columns or texts using CONCAT() function. We need to pass columns inside "" and text inside '' as
  arguments.

```roomsql
 SELECT concat( "first_name", ' ', "last_name" ) AS "Name" from "public"."employees";
```

- avg()
- min()
- max()
- sum()
- count()

```roomsql
 SELECT max(salary) as "maximum salary", sum(salary) AS "Total paid salaries" From "public"."salaries" ;
```

### Comments:

We can put single line comments with -- at the beginning of the line. We can also use `*/  */` for multiline comments.

## Joins

When we have relationships between our tables for example in customer table we have order_id we can access the other
table's data in our queries using join keyword.

### Inner join

Inner keyword is optional we can only use join and then `ON` with the fields that the join can happen base on them.

```roomsql
SELECT o.order_code, c.customer_name FROM orders o JOIN cutomers c
    ON o.customer_id = c.customer_id;
```

> If we are joining tables across multiple databases, We need to prefix database name with also aliases.

### Self join

We can also join a table with itself. The syntax is same as above but the different is that we have same database name,
and we need to have different aliases for each of them.
For example, We have employee table that hierarchy of employees is there with column reports_to. We can use self join
to list the manager's name for each person.

```roomsql
SELECT e.employee_id, e.employee_name, m.employee_name AS manager
    FROM employees e JOIN employees m
    ON e.reports_to = m.employee_id
```

#### JOIN more than two tables

```roomsql
SELECT p.payment_id, c.name, pm.name  FROM payments p 
    JOIN clients c ON p.client_id = c.client_id 
    JOIN payment_methods pm ON p.payment_method = pm.payment_method_id;
```

#### Compound join conditions

Sometimes we might have two primary keys in a table. When we want to join this kind of tables we need to provide two
conditions which we call compound join conditions.

```roomsql
SELECT * FROM order_items oi JOIN order_item_notes oin
    ON oi.order_id = oin.order_id
    AND oi.product_id = oin.product_id
```

### Implicit JOIN syntax

We have another way to write these joins, and we just use their names in front of `FROM` and we provide the ON statement
in `WHERE` clause.

> It's not recommended to use this syntax.

```roomsql
SELECT * FROM products p, orders o
    WHERE p.order_id = o.order_id;
```

### Outer Joins

When we join two tables only records that meet the ON statement condition will be shown. But, if we want to show all
tables from each side we can use LEFT/RIGHT outer joins.

> OUTER keyword is also optional.

```roomsql
SELECT p.product_id, p.name, oi.quantity  FROM products p 
	LEFT JOIN order_items oi ON p.product_id  = oi.product_id  ;
```

#### Multiple outer joins

```roomsql
SELECT o.order_id, o.order_date, os.name AS status, s.name AS shipper_name
	FROM orders o 
	LEFT JOIN order_statuses os ON o.status = os.order_status_id 
	LEFT JOIN shippers s ON o.shipper_id = s.shipper_id ;
```

> We can also use self outer join if we want to see all records on individual table.

### USING keyword

Most of the time when we are joining tables, in `ON` statement we provide columns with same names. In these cases we can
only use `USING` keyword and pass the column name to it. This will simplify the syntax. In case of compound primary keys
We can pass columns in it and separate them with comma.

```roomsql
SELECT p.payment_id , c.name  AS client_name, pm.name AS payment_method 
	FROM payments p  
	JOIN clients c USING (client_id)
	JOIN payment_methods pm ON p.payment_method = pm.payment_method_id ;
```

### Natural Joins

MySQL gives us a feature that can join tables automatically base on their similar columns. However, this is not
recommended.

### Cross Joins

This joins every column of one table with other table's columns. We also implicit and explicit syntax for this join.

```roomsql
SELECT * FROM payments p CROSS JOIN orders o
```

```roomsql
SELECT * FROM payments, orders;
```

### UNION results

We can combine query results with union keyword.

```roomsql
SELECT c.customer_id, c.first_name, c.points, 'Bronze'
	FROM customers c WHERE c.points < 2000
UNION 
SELECT c.customer_id, c.first_name, c.points, 'Silver'
	FROM customers c WHERE c.points BETWEEN 2000 AND 3000
UNION 
SELECT c.customer_id, c.first_name, c.points, 'Gold'
	FROM customers c WHERE c.points > 3000
```
