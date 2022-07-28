# Cryptographic Failures

![](../../../pics/sematec-jce1.png)
![](../../../pics/sematec-jce2.png)
![](../../../pics/sematec-jce3.png)
![](../../../pics/sematec-jce4.png)
![](../../../pics/sematec-jce5.png)
![](../../../pics/sematec-jce6.png)
![](../../../pics/sematec-jce7.png)
![](../../../pics/sematec-jce8.png)
![](../../../pics/sematec-jce9.png)

## Hashing algorithms

![](../../../pics/sematec-jce10.png)
![](../../../pics/sematec-jce11.png)
![](../../../pics/sematec-jce12.png)
![](../../../pics/sematec-jce13.png)
![](../../../pics/sematec-jce14.png)
![](../../../pics/sematec-jce15.png)
![](../../../pics/sematec-jce16.png)

> In Rest API or Messaging sometimes we use HMAC which is the hash of the message so the receiver can check the
> integrity of the message or request.

![](../../../pics/sematec-jce17.png)

> block cipher modes define how the block is going to turn into cipher and secret data.

![](../../../pics/sematec-jce18.png)

> we usually use CBC mode so, we start with an Initial value that results the first block in secret data and this will
> xor with plain file of next block.

![](../../../pics/sematec-jce19.png)
![](../../../pics/sematec-jce20.png)
![](../../../pics/sematec-jce21.png)

> In padding a block may have empty bytes, in padding we fill those empty bytes of blocks. in 8 bit if 5 are filled and
> 3 are empty. the empty will fill with 3. (totalByte - filledByte = emptyByteValue)

![](../../../pics/sematec-jce22.png)

## RSA Algorithm

![](../../../pics/sematec-cipher1.png)
![](../../../pics/sematec-cipher2.png)
![](../../../pics/sematec-cipher3.png)
![](../../../pics/sematec-cipher4.png)
![](../../../pics/sematec-rsa1.png)
![](../../../pics/sematec-rsa2.png)

## PKCS standards

These standards define how the key should be generated for various purposes. We have classes in java that can generate
public or private key base on the standard we want.

![](../../../pics/sematec-pkcs.png)

## SecureRandom vs Random

In order to generate IV or initialize keyGenerator we use SecureRandom class.

* `java.util.Random` class uses LOG algorithm which is not cryptographically strong(it is predictable)
  however,`java.security.SecureRandom` uses SHA1PRNG algorithm
* Random class has 48 bits but SecureRandom can have up to 128 bits.
* Random uses system clock as seed but, SecureRandom takes random data from OS. usually timing of I/O events mostly
  from/dev/random
* 2^48 attempts need to break random but, 2^128 for SecureRandom
* SecureRandom consumes more memory than Random.

Links:

* [Baeldung](https://www.baeldung.com/java-secure-random)
* [Techie delight](https://www.techiedelight.com/difference-java-util-random-java-security-securerandom/)
