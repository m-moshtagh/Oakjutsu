package com.dogigiri.designpatterns.mosh.strategy;

import org.junit.jupiter.api.Test;

class ChatClientTest {

    @Test
    void encryptionTest() {
        ChatClient chatClient = new ChatClient();
        chatClient.send("hello", new DESEncryption());
    }

}