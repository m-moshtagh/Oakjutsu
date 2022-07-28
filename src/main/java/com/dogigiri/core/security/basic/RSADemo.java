package com.dogigiri.core.security.basic;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class RSADemo {
    public static void main(String[] args) throws Exception{
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair keyPair = generator.generateKeyPair();
        byte[] encoded = keyPair.getPrivate().getEncoded();
        System.out.println(Hex.encodeHex(encoded));

        // The message or File:
        String file = "Tobey Maguire Is the all time best Spider man";
        byte[] message = file.getBytes();
        Cipher cipher = Cipher.getInstance("RSA");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
        byte[] encryptedFile = cipher.doFinal(message);
        System.out.println(Hex.encodeHex(encryptedFile));

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
        byte[] decryptedFile = cipher.doFinal(encryptedFile);
        StringBuilder result = new StringBuilder();
        for(byte b : decryptedFile){
            result.append((char) b);
        }
        System.out.println(result);
    }
}
