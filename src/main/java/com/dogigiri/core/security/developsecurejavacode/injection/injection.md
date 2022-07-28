# Injection

when someone tries to send an unexpected invalid data to our application and tries to damage it.

### SQL Injection

> We need to validate the parameter we want to use in our query using parse methods or regular expressions.

![](../../pics/sematec-SQLinjection1.png)

> We should always use preparedStatements instead of statements in order to parameterize our queries.

![](../../pics/sematec-SQLinjection2.png)
![](../../pics/sematec-SQLinjection3.png)  
![](../../pics/sematec-SQLinjection4.png)

> When using JPA specification frameworks we need to use parameterized queries which are defined using `=: varName` This
> will automatically handle injection. HOWEVER, we still need to validate argument we are going to use for query using
> regex or parse.

![](../../pics/sematec-SQLinjection5.png)
![](../../pics/sematec-SQLinjection6.png)

> A recommended way to create queries is to use Criteria API which makes our code declarative and also lets us limit
> structure of our query.

![](../../pics/sematec-SQLinjection7.png)

> Alongside validation, It's always recommended to limit our data inputs, which is called *_Data Sanitization_*.
> There are two ways to achieve this:

* A whitelist of data that can be used as input
* A blacklist of data that can't be used as input

![](../../pics/sematec-SQLinjection8.png)
![](../../pics/sematec-SQLinjection9.png)
![](../../pics/sematec-SQLinjection10.png)

### Operating System Injection

![](../../pics/sematec-OSInjection1.png)
![](../../pics/sematec-OSInjection2.png)

> It's always recommended to encode binary data when we want to transfer them.

![](../../pics/sematec-EncodeInjection.png)

> We can also prevent this using OWASP ESAPI which provides encoders and commands for creating OS commands.

![](../../pics/sematec-ESAPI.png)

### XPath injection in XML

Xpath is used to search elements in XML files. invalid values can be injected in this. We can prevent this using Xpath
Variable Resolver.

![](../../pics/sematec-XpathInjection1.png)
![](../../pics/sematec-XpathInjection2.png)

### Log Injection

Happens when we have untrusted value in our logging system. For example attacker tries to enter a log to our system.
injecting Carriage Return or LF and then adding untrusted message.

to prevent this we can simply limit input value and ban CRLF characters.

![](../../pics/sematec-LogInjection1.png)
![](../../pics/sematec-LogInjection2.png)
![](../../pics/sematec-LogInjection3.png)