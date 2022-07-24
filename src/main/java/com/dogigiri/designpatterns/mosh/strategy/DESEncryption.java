package com.dogigiri.designpatterns.mosh.strategy;

import org.slf4j.LoggerFactory;

public class DESEncryption implements Encryption {
    @Override
    public void encrypt(String message) {
        LoggerFactory.getLogger(DESEncryption.class).info("Encrypt {} via DES", message);
    }
}
