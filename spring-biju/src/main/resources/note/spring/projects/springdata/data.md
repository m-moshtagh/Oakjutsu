## Spring Data 
***
### JPA Repository
This project implements repository pattern and eliminates lots of JPA boilerplate codes for us.
All we have to do is to create an interface which extends `CrudRepository<T, ID>`
CrudRepository gives us access to lots of functions implemented in JPA specification.
<br> This Project uses hibernate beneath it.

### Spring data JPA query methods
When we create a spring data repository we gain access to lots of pre implemented query methods and, we don't need
to create SQL or JPQL query methods in order to query our database.