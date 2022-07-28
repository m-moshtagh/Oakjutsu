package com.dogigiri.core.security.developsecurejavacode.encryption.aes;

import com.dogigiri.core.security.developsecurejavacode.jce.encryption.aes.AESEncryption;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.io.File;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

class AESEncryptionTest {
    @Test
    void encrypt() throws GeneralSecurityException {
        File file = new File("src/test/java/resources/image/java.jpg");

        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        SecretKey secretKey = AESEncryption.generateKey();
        AESEncryption.encrypt(file, secretKey, iv);

        File encryptedFile = new File("/home/dogigiri/encode.txt");
        AESEncryption.decryptFile(encryptedFile, secretKey, iv);
    }
}