package com.dogigiri.core.security.basic;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class AESDemoECB {
    public static void main(String[] args) throws Exception {
        System.out.println("key");
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(192);
        SecretKey secretKey = generator.generateKey();
        System.out.println(Hex.encodeHex(secretKey.getEncoded()));

        byte[] input = "Hello".repeat(10).getBytes(StandardCharsets.UTF_8);

        System.out.println("encrypting input");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(input);
        System.out.println(Hex.encodeHex(encrypted));

        System.out.println("Decrypting using key");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] finalDecrypted = cipher.doFinal(encrypted);
        StringBuilder decryptedResult = new StringBuilder();
        for (byte b : finalDecrypted) {
            decryptedResult.append((char) b);
        }
        System.out.println(decryptedResult);
    }
}
