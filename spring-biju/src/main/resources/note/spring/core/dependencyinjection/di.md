## Dependency Injection
***
### Concept
Injecting a dependant object by another Object is called dependency injection.
It means we don't explicitly `new` the object(initialize), a some sort of third
party object handles the initialization and pass the dependency to us.

### Types of DI
* By class properties - least preferred
  * Can be public or private properties
  * Using private properties is EVIL. 
* By setters
* By constructor(most preferred)

NOTE: Property injection on private fields is EVIL because Spring needs to use reflection
to inject the dependency if the class is immutable(no setters). However, using constructor
solves this problem because injects the value in the time of initialization and also the 
class can remain immutable.
<br>
NOTE: Final fields is also best practice.
<br>
[**Property Injection is EVIL by: Mário Júnior*](https://www.linkedin.com/pulse/avoid-private-field-dependency-injection-here-why-m%C3%A1rio-j%C3%BAnior/)

### Concrete Classes vs Interfaces
* Interfaces is preferred because it gives us the runtime polymorphism ability.
* We can have multiple implementations like Java DataSource.
* Interface Segregation of SOLID principle.

### Inversion of Control
Is a technique to allow dependencies inject at runtime.

### Using DI with Spring
First we need to provide our dependency classes and mark them with one of spring stereotypes.
Then we need to specify them in the dependent class and use one of the methods specified above
with `@Authowired`.

### @Qualifiers
If we have multiple implementations of dependency interface, spring can't figure out
by default which dependency to inject so, We use `@Qualifier(name="dependencyName")`.
NOTE: in constructor injection we need to use this as an argument but, in the others we can do it above `@Authowired`.
```java
public Class(@Qualifier("dependencyClass") DependencyClass deClass){
    this.deClass = deClass;    
}
```

### @Primary 
When we have multiple implementations but, we want one of them to be the default bean so if we don't mention `@Qualifer` 
That been get injected, we can use `@Primary`. We specify it on top the dependency Class declaration.

### Spring Profiles
Profiles allow us to have certain beans that have a specific configuration.
NOTE: we can have multiple beans with one qualifying name and, we can make a
difference between them using this profile. All we have to do is to specify
the active profile in application.properties otherwise, there will be a conflict.
for example, we can have two database configurations and active them by their
profile.
</br>
There's a default profile so that if there's no active profile this is activated.
All we have to do is to pass another argument to `@Profile({"profileName", "default"})`.

