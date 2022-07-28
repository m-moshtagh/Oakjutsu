package com.dogigiri.core.security.basic;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class AESDemoCBC {
    public static void main(String[] args) throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(192);
        SecretKey secretKey = generator.generateKey();
        System.out.println(Hex.encodeHex(secretKey.getEncoded()));

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] random = new byte[16];
        secureRandom.nextBytes(random);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(random);

        byte[] input = "hello".repeat(10).getBytes(StandardCharsets.UTF_8);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encryptedInput = cipher.doFinal(input);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] finalResult = cipher.doFinal(encryptedInput);
    }
}
