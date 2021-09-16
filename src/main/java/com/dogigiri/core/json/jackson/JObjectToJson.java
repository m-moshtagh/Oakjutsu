package com.dogigiri.core.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JObjectToJson {
    public void writeObjectToJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("red", "renault");
        // return result as string
        objectMapper.writeValueAsString(car);
        // return result as byte array
        objectMapper.writeValueAsBytes(car);
        // create a .json file
        objectMapper.writeValue(new File("target/car.json"), car);
    }

}
