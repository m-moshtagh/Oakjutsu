package com.dogigiri.core.security.developsecurejavacode.jce.encryption.aes;

import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class AESEncryption {
    private AESEncryption() {

    }

    public static void encrypt(File file, SecretKey key, byte[] iv) throws GeneralSecurityException {
        byte[] fileData = readFileData(file);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
        byte[] encryptedData = cipher.doFinal(fileData);

        writeEncryptedFile(encryptedData);
    }

    public static void decryptFile(File encryptedFile, SecretKey key, byte[] iv) throws GeneralSecurityException {
        byte[] encryptedData = readFileData(encryptedFile);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        writeDecryptedFile(decryptedData);
    }

    private static byte[] readFileData(File file) {
        byte[] fileData = new byte[(int) file.length()];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            int count;
            while ((count = inputStream.read(fileData)) > 0) {
                LoggerFactory.getLogger(AESEncryption.class).info("{} bytes were read", count);
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
        try (FileOutputStream outputStream = new FileOutputStream("/home/dogigiri/decrypt.jpg")) {
            outputStream.write(encryptedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        return generator.generateKey();
    }
}