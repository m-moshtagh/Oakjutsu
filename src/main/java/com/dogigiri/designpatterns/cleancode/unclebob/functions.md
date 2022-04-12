# Functions

***

## Functions Rules

Functions should be small, 4 lines is ok and of course We need long highly descriptive names for our functions.
Old good point says that function should do only one thing. in order to achieve that we continue extracting that
function until we cannot extract it anymore.(extract till you drop)

## Function Structure

With this topic we are going to get rid of the function complex declaration with lots of arguments, switch and if statements, assigning statements and complex try catch blocks that make our code look obscure.

### Arguments

We should act with arguments as liability not asset. We need to have maximum *three* arguments. If we pass more than 3, We need to reconsider to pass an object to it.
For constructors, it's always preferable to use Builder pattern.
No Boolean Arguments ever, because in that case we are declaring that the function can do two different things.
We also should not pass output argument instead, we should return value.
We should also prevent passing or expecting to pass null argument instead we should create two functions.
Defensive programming, which means writing all sort of null checks in the function itself is code smell. For public APIs this is recommended but working with team, we should prevent it.

### Step down rule

This rule tells us to move the important parts to top and details to bottom. In class, we move public methods to top and private method to bottom. We can also follow every public method by corresponding private methods.

### Switch statements

First we'll explore why we hate switch cases.
For example, we have two modules: A & B. module A is dependant to B which means module A has source code dependency to B, so we need to import it in module A. What we do in this case is to define an interface which module B implements to backward the source code dependency.
Switch statement is like above case, it is dependant to all cases so if one case changes the whole switch and what module dependant to switch is affected.
One way to resolve this is to use polymorphism. which makes these submodules dependant to interface. this will lead to factory for their creation.
With the factory we get to concepts of Main partition and application partition. main is consisted of low-level stuff like factories and configurations. The dependencies between these two parts should be pointed one direction. they should both point toward application partition, application partition can not be dependant to main partition. Therefore, we use Dependency Injection.
Long if else statements also follow this.

### Paradigms

After all these years, functional, structured and object-oriented paradigms survived the case.

#### Functional Programming

This was the first paradigm that was invented.
We can write programs without any assignment statements. instead of declaring variables we pass them through functions as arguments. instead of loop through variables we, recurse through function arguments.
The output of function only depends on the arguments not any statement of the system, so function always return same output with same arguments.
The side effect is temporal coupling which means functions need to be called in order. for example first open connection to DB then close it. This is solved by passing a block to functions.

##### Command Query Separation

One Best practice is to separate command functions from query functions because command functions can completely change the state of application but queries not.
We sometimes write functions which return something for example user after login but absolutely this operation changed the state of system. We also, return null if it fails. But Here best practice is to throw exception if something goes wrong and return nothing(void) when operation was successful.

##### Tell Don't Ask

For doing operations, It's always recommended that We don't ask anything for object state, because object knows its state better than anyone. for example:

```java
if(user.isLoggedIn)
    user.executeCommand();
else
    annunciater.promptLogin();
```

> It's better to write the above code like this:

```java
try{
    user.executeCommand();
} catch(User.NotLoggedIn e){
    annunciator.prompedLogin();
}
```

However, still we ask the user if it's loggedIn or not we can solve this by passing the block to it:

```java
user.executeCommand(command, annunciator);
```

> The law of Demeter: This law tells us to not make chain of functions.

#### Structured Programming

Structured programming says that all algorithms should be composed out of three basic operations:

* sequence: Consists of two blocks which the first blocks output feeds the second block and, second block uses first block output to operate.
* selection: There are two blocks separated by a boolean so, depending on the boolean value each block can be executed.
* iteration: a block runs consecutively until a boolean value changes.

So according to this no mather how complex algorithm is, it has single entrance at the top and single exit at bottom.

##### Error Handling

It's always good to throw uncheckedExceptions. 
