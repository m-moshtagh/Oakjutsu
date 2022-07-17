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

![](../pics/sematec-OSInjection1.png)
![](../pics/sematec-OSInjection2.png)

> It's always recommended to encode binary data when we want to transfer them.

![](../pics/sematec-EncodeInjection.png)

> We can also prevent this using OWASP ESAPI which provides encoders and commands for creating OS commands.

![](../pics/sematec-ESAPI.png)

### XPath injection in XML

Xpath is used to search elements in XML files. invalid values can be injected in this. We can prevent this using Xpath
Variable Resolver.

![](../pics/sematec-XpathInjection1.png)
![](../pics/sematec-XpathInjection2.png)

### Log Injection

Happens when we have untrusted value in our logging system. For example attacker tries to enter a log to our system.
injecting Carriage Return or LF and then adding untrusted message.

to prevent this we can simply limit input value and ban CRLF characters.

![](../pics/sematec-LogInjection1.png)
![](../pics/sematec-LogInjection2.png)
![](../pics/sematec-LogInjection3.png)

## Identification & Authorization Failures

![](../pics/sematec-brokenIA1.png)
![](../pics/sematec-brokenIA2.png)

> The first thing to do is to always make sure we don't include sensitive data like userId through our requests with
> cookie or session ID.

![](../pics/sematec-brokenIA3.png)

> After a successful login we need to rotate the session-ID and get a new Session-ID.
> In case of stateless(token based) we need to consider token side-jacking. We usually use jwt token, We should encrypt
> it using JWE/JWS. libraries to use:

* nimbus-jose
* jose4j

![](../pics/sematec-brokenIA4.png)

> For password, we always need to consider to choose a unique one.

In order to persist password in a resource we need to apply hashing algorithms to provide the necessary privacy and
security.

![](../pics/sematec-hashing1.png)

> Also, We need to 2-factor authentication. It doesn't matter if we use one time password or hardware security password.

![](../pics/sematec-brokenIA5.png)

### IMA

![](../pics/sematec-brokenIA6.png)

For Authentication Authorization, we can have authentication in every module we write. But also we can connect to
Identity and Access management platform. It is recommended to use this method. Tools we can use:

* KeyCloak/WSO2
* Identity server

These IAM connects to a data source or Database and, we connect to this IAM.
These IAMs also support different mechanisms like LDAP OAUTH2.

In OAUTH2 we get two tokens:

* Access Token
* Refresh Token

We don't need new login if we have valid access token. Or the app can use refresh token to get new access token.

## Security Misconfiguration

### XXE

When we want to access external entity from XML file a security risk will rise. In this case JSON is better to use.

![](../pics/sematec-xxe1.png)
![](../pics/sematec-xxe2.png)
![](../pics/sematec-xxe3.png)

### Deserialize Objects

When we're trying to deserialize an untrusted object we have to use whitelist method to verify the object we read.

![](../pics/sematec-deserialize1.png)
![](../pics/sematec-deserialize2.png)

## Cryptographic Failures

![](../pics/sematec-jce1.png)
![](../pics/sematec-jce2.png)
![](../pics/sematec-jce3.png)
![](../pics/sematec-jce4.png)
![](../pics/sematec-jce5.png)
![](../pics/sematec-jce6.png)
![](../pics/sematec-jce7.png)
![](../pics/sematec-jce8.png)
![](../pics/sematec-jce9.png)
![](../pics/sematec-jce10.png)
![](../pics/sematec-jce11.png)
![](../pics/sematec-jce12.png)
![](../pics/sematec-jce13.png)
![](../pics/sematec-jce14.png)
![](../pics/sematec-jce15.png)
![](../pics/sematec-jce16.png)

> In Rest API or Messaging sometimes we use HMAC which is the hash of the message so the receiver can check the
> integrity of the message or request.

![](../pics/sematec-jce17.png)

> block cipher modes define how the block is going to turn into cipher and secret data.

![](../pics/sematec-jce18.png)

> we usually use CBC mode so, we start with an Initial value that results the first block in secret data and this will
> xor with plain file of next block.

![](../pics/sematec-jce19.png)
![](../pics/sematec-jce20.png)
![](../pics/sematec-jce21.png)

> In padding a block may have empty bytes, in padding we fill those empty bytes of blocks. in 8 bit if 5 are filled and
> 3 are empty. the empty will fill with 3. (totalByte - filledByte = emptyByteValue)

![](../pics/sematec-jce22.png)

### RSA Algorithm

![](../pics/sematec-cipher1.png)
![](../pics/sematec-cipher2.png)
![](../pics/sematec-cipher3.png)
![](../pics/sematec-cipher4.png)
![](../pics/sematec-rsa1.png)
![](../pics/sematec-rsa2.png)
