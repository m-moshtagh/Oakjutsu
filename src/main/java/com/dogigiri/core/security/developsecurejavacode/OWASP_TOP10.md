# OWASP TOP 10

## Security software development life cycle

When we don't consider security issues during our development cycle, The bad result will emerge on both technical and
business sides. We have a Security life cycle which starts from requirement gathering step and goes on till the end of
the software development life cycle.

1. First the development team needs a training
2. In Requirements phase, also on top of business requirements we need to specify security risks and define quality
   gates for our application
3. In Design phase, We need to perform threat modeling, which is to analyze the security threats that might happen in
   our architecture.
4. In implementation phase, We can use plugins, linters to see if our code has security breaches or not. OWASP liner,
   SonarLint are tools which provide hints for us and perform static analysis during our coding.
5. In Verification phase, when we have deployed our application and, we want to test our application on runtime and make
   sure it's secure. Here we need Dynamic/ Fuzz testing.
6. In Release phase, We need to plan to resolve all issues.

![](../pics/sematec-securityLifeCycle.png)
![](../pics/sematec-securityLifeCycle1.png)
![](../pics/sematec-securityLifeCycle2.png)

After analyzing, we give an incident report from the classification of issues.

![](../pics/sematec-securityLifeCycle3.png)

> We should always consider security from the beginning of development.

## Top 10 OWASP Security risks & vulnerabilities

OWASP is open web application software project is a nonprofit created by security GURUs. They have defined lease things
to do to secure applications no matter what language we use. Here we are going to discuss top 10 most critical use-cases
for securing our web application in Java.

OWASP rules are general concepts and are regardless of other industry's data policies. For example GDPR is europe
specific data policies.

![](../pics/sematec-securityLifeCycle4.png)
![](../pics/sematec-securityLifeCycle5.png)

## Injection

when someone tries to send an unexpected invalid data to our application and tries to damage it.

### SQL Injection

> We need to validate the parameter we want to use in our query using parse methods or regular expressions.

![](../pics/sematec-SQLinjection1.png)

> We should always use preparedStatements instead of statements in order to parameterize our queries.

![](../pics/sematec-SQLinjection2.png)
![](../pics/sematec-SQLinjection3.png)
![](../pics/sematec-SQLinjection4.png)

> When using JPA specification frameworks we need to use parameterized queries which are defined using `=: varName` This
> will automatically handle injection. HOWEVER, we still need to validate argument we are going to use for query using
> regex or parse.

![](../pics/sematec-SQLinjection5.png)
![](../pics/sematec-SQLinjection6.png)

> A recommended way to create queries is to use Criteria API which makes our code declarative and also lets us limit
> structure of our query.

![](../pics/sematec-SQLinjection7.png)

> Alongside validation, It's always recommended to limit our data inputs, which is called *_Data Sanitization_*.
> There are two ways to achieve this:

* A whitelist of data that can be used as input
* A blacklist of data that can't be used as input 

![](../pics/sematec-SQLinjection8.png)
![](../pics/sematec-SQLinjection9.png)
![](../pics/sematec-SQLinjection10.png)

### Operating System Injection


