package com.dogigiri.core.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToJObject {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Object toJavaObject() throws IOException {
        String json = "{ \"color\" : \"red\", \"type\" : \"renault\"} ";
        objectMapper.readValue(json, Car.class);
        // we can also pass a URL or file path
        return objectMapper.readValue(new File("target/car.json"), Car.class);
    }
}
