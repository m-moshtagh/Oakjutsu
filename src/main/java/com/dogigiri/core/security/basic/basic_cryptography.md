# Security:

Java has two concepts in JDK in order to use cryptography:
*: Java Cryptography Architecture(JCA) / Java Cryptographic Extension
Now we just use them as one. For using them we just send a request to JCA/JCE API and, we use their functions. It's just
a pluggable architecture.
We have SunJCE inside JDK but, we can use third parties like BouncyCastle or Other CSP.

## How to plug them in:

- We have Security class in java with addProvider() method which we can give it our preferred security provider. which
  has
  to extend java.Security.Provider class.
- We can also register it in java.Security file.
  *: for Java 8 we update jre/lib/security/java.security but, for java 9 +: conf/security/java.security

## Hashing:

We'll pass an input and, then it will digest it to an encrypted content which we can't reverse it.

Hashing Algorithms:

- MD5 (128 bits)
- SHA-1 (160 bits)
- SHA-256 (256 bits)
- SHA-512 (512 bits)

To use it in java, we have a class named MessageDigest which has a function getInstance which we specify algorithm. Then
we pass message and digest it.
For Authorization & Authentication we store the hashed password in our DB and, then we get the password in plain text
from
user and put it through hashing process and compare if they are equal or not.

> We use salt in order to avoid rainbow table hashes.

## Symmetric Encryption:

In this approach we use a shared key between multiple parties and, they can use this key to encrypt and decrypt
messages.

Algorithms:

- DES (Data Encryption Standard)
  Block size: 64 bits
  Key size  : 56 bits
  this was developed by IBM and is hacked now.

- AES (Advanced Encryption Standard)
  Block size: 128 bits
  key size  : 128, 192, 256 bits

Symmetric encryption in Java:
There's a KeyGenerator class in java with generateKey method. Then there's a class Cypher which we provide the algorithm
and init our key. the outcome is a cypher text.

ECB takes a block of 8 bytes everytime and puts it in function so, if our chunk is same the pattern of encryption is
repeated which is not good in some cases especially encrypting media.
So we use CBC this will use the same but encrypts the second chunk with the output of the first chunk. this is a way
to handle the patterns.

The implementation is a little different:
We start with KeyGenerator and at the same time we use a class SecureRandom which we use it to initialize an algorithm
this
will result in IvParameterSpec which is a random sequence of bytes. We get the cypher again and feed the both to it and
then anything is the same.

In case we want to encrypt something and share we set a password and generate a key with that password, and we can do
our job with that.

One way to exchange things is that both sides agree on some values and, own a private key and generate a public key
using that private one and, at last share those public keys.

## Asymmetric Encryption:

In this way, we work with two keys, a public and a private one. Foo will encrypt using Bar's public key and pass the
object. then, Bar can decrypt using its own private key.

Algorithms:

- Diffie-Hellman key agreement protocol
- RSA -> key size 1024, 2048, 3072
- ECC (Elliptic Curve Cryptography) -> key size 128

Asymmetric Encryption in Java:
We use a class called KeyPairGenerator and pass algorithm to getInstance() function. It gives us a KeyPair. Then we can
getInstance() of a Cypher and, init it via KeyPair.getPrivate(). Finally, encrypt our message.
For Decrypting it, we should, init our Cypher with public key.

In case of Encrypting Large files because RSA is slow but, we can use it for:

- Agreeing on Symmetric keys
- Encrypting / Decrypting Symmetric keys
- Encrypting hashes, or message Digests (Digital Signature)

## Digital Signatures using Asymmetric Encryption:

We have a piece of message that we have digested it then, we sign the hash with private key, then we send the message,
encrypted message and public key to the receiving end. They can take the digest and decrypt it using public key then,
send it to calculate the hash of the original message

Digital Signature in Java:
We use KeyPairGenerator to generate the key. Then we use Signature class. This class does both hashing and encryption.
and
we just init it with our private key. Then we can verify the message using public key.
this is applicable in crypto blockchains, where we encrypt transaction and pass it to a node in blockchain, and it
can
verify it by our public key.

## Certificates:

We achieved Confidentiality via encryption and also Integrity using Digital Signatures. and now we only need to see if
the
Foo public key is authenticated or not.
This is provided by Certificate Authorities.

In order to do this we have to create a CSR (Certificate Request).

In Java, we have KeySore interface where we can store our certificate. Also, we have keyTool.exe in JDK which we can
generate our Certificates with it.

Source code for the Michel Schudel Examples:
https://github.com/MichelSchudel/crypto-demo