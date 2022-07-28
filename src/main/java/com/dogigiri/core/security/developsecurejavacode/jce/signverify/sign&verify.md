# Sign and Verify

We use private key to sign something and then verify it via public key.

## Sign message

* We need to declare Signature specification with `Signature.getInstance('Algorithm')`
* We give private key with `initSign(privateKey)`
* call `update(message)`. We should give the message in bytes
* we can `sign()` and at last turn the signed bytes in Base64 encoding

## Verify signature

* We need to declare Signature specification with `Signature.getInstance('Algorithm')`
* We give public key with `initVerify(publicKey)`
* call `update(message)`. We should give the message in bytes
* we can `decode()` the sign with decoder
* at last, we verify the decoded signature bytes.
