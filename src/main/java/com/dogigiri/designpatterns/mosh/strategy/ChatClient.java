package com.dogigiri.designpatterns.mosh.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatClient.class);

    public void send(String message, Encryption encryptionAlgorithm) {
        encryptionAlgorithm.encrypt(message);
        LOGGER.info("Sending the encrypted message...");
    }
}
