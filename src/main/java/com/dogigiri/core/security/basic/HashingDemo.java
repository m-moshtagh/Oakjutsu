package com.dogigiri.core.security.basic;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingDemo {
    public String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] digestedPassword = messageDigest.digest(bytes);
        return String.valueOf(Hex.encodeHex(digestedPassword));
    }
}
