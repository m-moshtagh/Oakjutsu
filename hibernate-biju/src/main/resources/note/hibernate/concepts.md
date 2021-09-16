## Java Persistence API
JPA is the Java specification which hibernate is written to.
***
###ORM
Object Relational Mapping is a design pattern which allows us to represent
our database tables as POJOs and vise versa. <br> In order to do a full ORM
we need to create entities using JPA specification and also manage their relationships.
We have One to One, One to many, Many to One and Many to many relationships.

### Entities (Java POJOs)
* We create Java POJOs and mark them with `@Entity` from `jakarta.persistence` package
> We don't use hibernate implementation of `@Entity`
* Then we need to specify the Primary Key and annotate it with `@Id` and specify
how this is going to be generated with `@GeneratedValue(strategy=OPTION)`
* Define Table Relationships on dependencies of class.
* Implement equal() & hashcode() methods in order to provide distinction to our POJO.
* Implement toString() method