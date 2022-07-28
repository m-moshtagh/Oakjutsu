package com.dogigiri.core.security.developsecurejavacode.jce.signverify;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class SignatureDemo {
    public byte[] sign(String text, PrivateKey privateKey) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(text.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encode(signature.sign());
    }

    public boolean verify(String text, byte[] sign, PublicKey publicKey) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] decidedSign = Base64.getDecoder().decode(sign);
        return signature.verify(decidedSign);
    }
}
