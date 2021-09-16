## SOLID Principles
***
### Why SOLID?
OOP is a great paradigm to make software products but There should be some principles
to lead the design into much more flexibility and quality code which is easy to maintain. <br>
These 5 principles aim at dependency management in OOP software design. 

### Single Responsibility
* The class is only supposed to do one job.
* The class should only change for one reason.
* Avoid God classes.
* Divide big classes into small ones.

### Open Closed
* Class should be open for extension but closed for modification.
* We need to be able to extend a class behavior, without modifying it.
  * Having Private variables and using getters and setters when we only need them.
* Use abstract base classes.
> In order to achieve this principle, All we have to do is to bring a layer of abstraction to our code in order
> to have simple extension. Polymorphism can help us achieve this.
> All we have to do is to create abstract class or interface and each time create a class that implements a new feature 
> then use runtime polymorphism to use the specific class we want.

### Liskov Substitution
* Objects in a program should be replaceable by their subtypes without altering the correctness of program.
* Violations will often fail the "is a" test.
* A square is a rectangle however, a rectangle is not a square.

### Interface Segregation
* Make fine-grained interfaces that are client specific.
* Many client specific interfaces are better than one general purpose interface.
* Keep components focused and minimize dependencies between them.
* Avoid God interfaces. like, Single responsibility principle.
> The brief work this principle wants is to not create fat interfaces and, avoid creating methods that target class of 
> interface might not implement them.
> </br> We can implement multiple interfaces in Java so, we can have multipurpose 
> interfaces easily.

### Dependency Inversion
* Abstraction should not depend upon details.
* Details should depend upon the abstraction.
* Important that higher level and lower level objects depend on the same abstract interaction.
* This is not the same as Dependency Injection - which is how objects obtain dependant objects.
> What Dependency Inversion Principle says is that instead of a high-level module depending on a low-level module,
> both should depend on an abstraction. 
> 