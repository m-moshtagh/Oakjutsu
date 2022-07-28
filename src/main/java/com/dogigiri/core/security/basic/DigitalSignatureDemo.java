package com.dogigiri.core.security.basic;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class DigitalSignatureDemo {
    public static void main(String[] args) throws Exception{
        // Create key pairs
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();

        String message = "Tobey Maguire is the best Spider man ever!";
        String falseMessage = "String message = \"Tobey Maguire is the best Spider man ever!\"";

        // Sign file or message
        Signature signingSignature = Signature.getInstance("SHA256WithRSA");
        signingSignature.initSign(keyPair.getPrivate());
        signingSignature.update(message.getBytes(StandardCharsets.UTF_8));
        byte[] signature = signingSignature.sign();

        // verify the signature
        Signature verificationSignature = Signature.getInstance("SHA256WithRSA");
        verificationSignature.initVerify(keyPair.getPublic());
        verificationSignature.update(message.getBytes(StandardCharsets.UTF_8));
        // pass a false signature
        boolean result = verificationSignature
                .verify("634c186ac9fbe2ce23fdcd7791ee91bc71471ab7953cc39335696183cb23145a535c7cbb3748d6897bcb80b0d8d88c9c4392e959f5f2c88f1f912b51b543e0dab77a67197e2b134faf4693e56aee9ecf502fdfa3ba5e055b68722f6a864b1dacdb42d164dd328b97a5b3daba7a89463cf773af06565656565656565566565656".getBytes());
        System.out.println(result);
    }
}
