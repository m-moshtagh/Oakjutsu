## JPA data repositories
***
### CrudRepository
In order to create a data repository, we can create an interface
and extend the CrudRepository interface coming from jpa package.
We have three abstract interfaces for this functionality:
1. CrudRepository
2. PagingAndSortingRepository
3. JPARepository

These three will provide us with Automatic query functions. Also, If we want some custom query hibernate can generate
it for us. for example for a findByLastName() query we can add this method in interface and hibernate will generate it
for us.

