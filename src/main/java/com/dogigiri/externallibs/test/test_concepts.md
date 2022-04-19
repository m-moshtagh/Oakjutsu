# Testing Software

***

## Basics

![Testing Software](pics/test1.png)
![Testing Software](pics/test2.png)
![Testing Software](pics/test3.png)
![Testing Software](pics/test4.png)
![Testing Software](pics/test5.png)
![Testing Software](pics/test6.png)
![Testing Software](pics/test7.png)

## Testing Frameworks

![frameworks](pics/framework1.png)
![frameworks](pics/framework2.png)
![frameworks](pics/framework3.png)
![frameworks](pics/framework4.png)
![frameworks](pics/framework5.png)
![frameworks](pics/framework6.png)
![frameworks](pics/framework7.png)
![frameworks](pics/framework8.png)
![frameworks](pics/framework9.png)
![frameworks](pics/framework10.png)

## Beyond Testing with CI/CD

![CI/CD](pics/ci1.png)
![CI/CD](pics/ci2.png)
![CI/CD](pics/ci3.png)
![CI/CD](pics/ci4.png)
![CI/CD](pics/ci5.png)

We can simply add our project for CI pipeline in circleci for free. We just need a .circleci directory and a config.

## Test Driven Development

In TDD, we usually create Test classes and test the usage of the class we want to write then we create the class We want.
And evolve it with each test case.

![TDD](pics/TDD.png)

## Test Execution

We can add custom configuration in IDE Run/Debug settings. We can also choose directory and select run with test coverage. This shows us how much of the class contents are covered in the test classes.

Maven surefire plugin also runs our tests when we call maven test lifecycle. We can add `,group>` & `<excluded-group>` to run specific Junit tags.

Maven FailSafe plugin helps us with Integration test. The classes name convention for integration tests are ending with IT. This plugin kicks in inside verify lifecycle. We can see the report XML file inside target directory.

We can also generate reports and Web documents using Maven Site plugin and Surefire-reporting. This will generate Web resources in target directory for us.

All the above tasks can be done using gradle too.
