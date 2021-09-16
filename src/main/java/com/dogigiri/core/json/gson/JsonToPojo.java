package com.dogigiri.core.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToPojo {
    public static void main(String[] args) {
        String json = "{\"name\":\"Mohammad\", \"age\":23}";
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        var jObject = gson.fromJson(json, Student.class);
        System.out.println(jObject);
        json = gson.toJson(jObject);
        System.out.println(json);
    }
}
