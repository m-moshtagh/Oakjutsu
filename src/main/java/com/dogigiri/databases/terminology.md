# Database

Database is a large scale software to store the Application state(data) to retrieve later. This saves a lot of memory
and makes our applications stateless and isolated from data, so if we get into trouble with app, our database will be
alright. We can also manipulate Our data using Queries we send to DB.

## SQL

A Language to interact and Query database in order to get or manipulate data.

## Database Models

- Hierarchical model:
  This model is an old inefficient way to store data. which uses One-to-many relationship only. There will be lots of
  redundant
  data because we can't maintain the relations between two upper nodes. Sub children are tightly coupled with upper
  level ones.
  XML is way of storing data in hierarchical model.

- Network model:
  This model is like Hierarchical but with allowing Many-to-many relationship. Managing data in big scale was a problem
  in this model.

- Relational model:
  Data relationships here follow a table structure. We maintain relations with table_ids.

### DBMS or RDBMS

The software that allows us to manage our data.

### Table

representation of our entities are called Tables which consist of Rows & Columns. Table will have a name and
their columns are their Degree. each row will represent a record in the table. What type of data is in a column is
called Domain or Constraints. We can also call columns, attributes. a single record of data is also called tuple. each
tuple should follow the constraints. Multiple rows of data is called Cardinality.

### Primary Key

The thing that makes it possible to make relationships between tables is primary keys. This is a unique identifier for
each record.

### Foreign key

To reference other data from somewhere else we use foreign key which is the primary key on the dependent table.

### Schema

In order to categorize our tables we use schema.

### ACID

- Atomicity: We can make small transactions into one so if we failed one, the whole thing is failed.
- Consistency
- Isolation
- Durability

### Transactions

Transaction are end to end requests to process an input and get the results. sometimes a transaction might consist of
multiple queries but, if one of them fails, the whole transaction should fail.

### OLTP(Online Transaction Processing)

In companies, we have some databases that process day to day transactions like logging in and doing business.

### OLAP(Online Analytical Processing)

This is where we take our OLTP things and put it in a warehouse and, then we start doing all types of analytical
processing on the data to extract what's valuable on that.
