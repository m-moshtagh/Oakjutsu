package com.dogigiri.core.security.developsecurejavacode.signverify;

import org.junit.jupiter.api.Test;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class SignatureDemoTest {

    @Test
    void signVerifyTest() throws GeneralSecurityException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();
        SignatureDemo signatureDemo = new SignatureDemo();
        byte[] sign = signatureDemo.sign("hello world", keyPair.getPrivate());
        assertThat(signatureDemo.verify("hello world", sign, keyPair.getPublic())).isTrue();
    }
}