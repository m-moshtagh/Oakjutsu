package com.dogigiri.core.json.jackson;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonToJObjectTest {
    @Test
    public void test() throws IOException {
        JsonToJObject object = new JsonToJObject();
        Object o = object.toJavaObject();
        System.out.println(o);
    }

}