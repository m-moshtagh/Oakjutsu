# Serialization & Deserialization vulnerabilities

## Concept

Whenever we need to save a Java object on external resources we serialize the object and whenever we try to read that
object from binary format we deserialize it. To deserialize we use `ObjectInputStream` class. In order to prevent
deserializing untrusted objects we need to define a whitelist of trusted Objects.

![](../../pics/sematec-serialize1.png)
![](../../pics/sematec-serialize2.png)
![](../../pics/sematec-serialize3.png)
![](../../pics/sematec-serialize4.png)

### XXE

When we want to access external entity from XML file a security risk will rise. In this case JSON is better to use.

![](../../pics/sematec-xxe1.png)
![](../../pics/sematec-xxe2.png)
![](../../pics/sematec-xxe3.png)

### Deserialize Objects

When we're trying to deserialize an untrusted object we have to use whitelist method to verify the object we read.

![](../../pics/sematec-deserialize1.png)
![](../../pics/sematec-deserialize2.png)
