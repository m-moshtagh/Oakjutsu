package com.dogigiri.core.json.jackson;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JObjectToJsonTest {
    @Test
    public void test() throws IOException {
        JObjectToJson json = new JObjectToJson();
        json.writeObjectToJson();
    }

}