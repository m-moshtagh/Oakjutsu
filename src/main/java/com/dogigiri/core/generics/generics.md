# Generics

## Concept

Generics in java provides a way to define parameterized types means, Enables types to be parameters for
classes/interfaces. It implements strict type safety checks at compile time.

E, T K, V these are type parameters. These are placeholders on what type the Generic Type is going to work with.
When we pass concrete classes to generic types like List<String>, String will be a type arguments.

The <> operator allows to type inference the type argument From one side when initializing a generic type.

### Rules

Primitives can not be passed as type arguments. The boxing and unboxing between Wrappers and Primitives will be done
automatically.

naming conventions for type parameters

* E -> Element: used in all collection classes
* T -> Type:
* K -> Key:
* V -> Value:
* N -> Number:
* S U V -> more than one parameter

### Problem without generics

When we define generalized types or types that have raw types. We mostly encounter two problems:

* Explicit casting will be needed trying to parse the object
* If the type is not the one we're trying to fetch runtime can not cast exception will be thrown.

```java
import java.util.List;

public class WithoutGeneric {
    public static void main(String[] args) {
        List items = new ArrayList(); // List of raw types
        items.add("book");
        items.add(212);

        String s = (String) items.get(0);
        String f = items.get(1); // throws runtime exception
    }
}
```

### Magic with generics

Nowadays with generics we can define types with custom parameterized types for example a String arraylist or List of
Products without defining ProductList class explicitly because in JDK `java.util.List` is a generic type.

```java
import java.util.List;

public class withGeneric {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("books");
        items.add(22); // compile time error

        String item = items.get(0);
    }
}
```

## Boundary types

WE can also restrict our Generic classes by boundary types. we can extend Classes and interfaces.

for example:
`Generic<T extends Cloneable & Comparable>` -> this means only types that implement cloneable interface are allowed.

## Generic methods

We can also define Generic methods which have benefits of not defining all parameters as Object.
we can have multiple parameters in generic type separated by comma.
we can have generic methods inside non-generic class

## ? wildcard

is the wildcard we pass as a generic type. with this java crates a virtual class named CAPTURE#1, and it's like
the object class. when ? extends a class we can only read values from it. but for writing it we should use super keyword