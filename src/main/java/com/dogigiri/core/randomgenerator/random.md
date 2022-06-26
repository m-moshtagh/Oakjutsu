# Pseudorandom number generators

## Overview

Java 17 introduced new interfaces to enhance the prng types. They all have 

* nextInt()
* nextDouble()
* nextLong()
* nextBoolean()
* isDeprecated()

Four new generators also introduced:

* SplittableRandomGenerator: allows spawn new generator from existing generator.
* JumpableRandomGenerator: allows user to jump ahead a moderate amount of draws
* LeapableRandomGenerator: allows user to jump ahead a large amount of draws
* ArbitraryRandomGenerator: extends leapable and defines arbitrary jump distance to be defined.

## Using

We simply use java.util.Random as before.
