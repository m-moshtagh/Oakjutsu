package com.dogigiri.core.security.developsecurejavacode.encryption.rsa;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.security.KeyPair;

class RSAEncryptionTest {

    @Test
    void encryptData() {
        KeyPair keyPair = RSAEncryption.generateKeyPair();
        File file = new File("src/test/java/resources/log.txt");

        assert keyPair != null;
        RSAEncryption.encryptFile(file, keyPair.getPublic());

        File file1 = new File("/home/dogigiri/encode.txt");
        RSAEncryption.decryptFile(file1, keyPair.getPrivate());
    }
}