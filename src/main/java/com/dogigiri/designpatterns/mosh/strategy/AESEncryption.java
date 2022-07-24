package com.dogigiri.designpatterns.mosh.strategy;

import org.slf4j.LoggerFactory;

public class AESEncryption implements Encryption {

    @Override
    public void encrypt(String message) {
        LoggerFactory.getLogger(AESEncryption.class).info("Encrypt {} via AES", message);
    }
}
