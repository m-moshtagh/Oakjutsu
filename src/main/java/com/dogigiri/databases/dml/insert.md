# Insert rows in tables

## Syntax

Whenever we want to add a row to a table we use insert command. The general syntax is like below:

```roomsql
INSERT INTO 
table_name (column_one, column_two) 
VALUES ('value1', 'value2')
```

> We can pass `DEFAULT` in `VALUES` clause if we want the default value to be set in the row. For Auto Incremented
> columns It is recommended to pass DEFAULT.

> We can also pass multiple values clauses separated by comma to add multiple rows in table.

> MysQL has a built-in function named LAST_INSERTED_ID() which provides the last id of the table we want.

## Insert with sub queries

We can insert into a table using a `SELECT` Query to copy the data we want in that table.

> We need to make sure if we create a table with sub query the constraints won't apply.
