# Serialization & Deserialization vulnerabilities

## Concept

Whenever we need to save a Java object on external resources we serialize the object and whenever we try to read that
object from binary format we deserialize it. To deserialize we use `ObjectInputStream` class. In order to prevent
deserializing untrusted objects we need to define a whitelist of trusted Objects.

![](../../pics/sematec-serialize1.png)
![](../../pics/sematec-serialize2.png)
![](../../pics/sematec-serialize3.png)
![](../../pics/sematec-serialize4.png)
