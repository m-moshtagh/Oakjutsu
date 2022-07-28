package com.dogigiri.core.security.developsecurejavacode.jce.encryption.rsa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class RSAEncryption {
    private static final Logger LOGGER = LoggerFactory.getLogger(RSAEncryption.class);

    private RSAEncryption() {

    }

    public static KeyPair generateKeyPair() {
        try {
            var generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048, new SecureRandom());
            return generator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("The selected algorithm doesn't exists");
        }
        return null;
    }

    public static void encryptFile(File file, PublicKey publicKey) {
        var fileData = readFileData(file);
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedData = cipher.doFinal(fileData);
            writeEncryptedFile(encryptedData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            LOGGER.error("Encryption problem");
        }
    }

    public static void decryptFile(File file, PrivateKey privateKey) {
        var fileData = readFileData(file);
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(fileData);
            writeDecryptedFile(decryptedData);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            LOGGER.error("Decryption problem");
        }
    }

    private static byte[] readFileData(File file) {
        byte[] fileData = new byte[(int) file.length()];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            int count;
            while ((count = inputStream.read(fileData)) > 0) {
                LoggerFactory.getLogger(RSAEncryption.class).info("{} bytes were read", count);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return fileData;
    }

    private static void writeEncryptedFile(byte[] encryptedData) {
        try (FileOutputStream outputStream = new FileOutputStream("/home/dogigiri/encode.txt")) {
            outputStream.write(encryptedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDecryptedFile(byte[] encryptedData) {
        try (FileOutputStream outputStream = new FileOutputStream("/home/dogigiri/decrypt.txt")) {
            outputStream.write(encryptedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
