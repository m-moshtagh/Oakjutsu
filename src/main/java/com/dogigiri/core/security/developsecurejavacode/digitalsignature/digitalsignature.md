# Digital Signature

## Concept

We use digital signature to achieve undeniability. The request we send should have a signature in header and, we send
it, the server should verify it.


## Create signature of request

In order to do this we need to adopt canonical request properties to our request.

### Canonical request characteristic

![](../../pics/sematec-digitalsignature1.png)

### Create Digital signature

* first we adopt above characteristic
* we hex the hashed result of canonical request
* we sign the hex result
* we hex the signature and this is the digital signature

![](../../pics/sematec-digitalsignature2.png)
![](../../pics/sematec-digitalsignature3.png)
![](../../pics/sematec-digitalsignature4.png)
![](../../pics/sematec-digitalsignature5.png)
![](../../pics/sematec-digitalsignature6.png)
![](../../pics/sematec-digitalsignature7.png)
![](../../pics/sematec-digitalsignature8.png)
