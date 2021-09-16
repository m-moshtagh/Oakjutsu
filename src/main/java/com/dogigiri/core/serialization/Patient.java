package com.dogigiri.core.serialization;

import java.io.Serializable;

/*
 *  When we need to transfer an object from a producer app to a consumer app we need to convert
 *  the object to Bytes and then again the Bytes to object. The process of converting object to
 *  bytes is called serialization and the Bytes to object is deserialization.
 *  transient keyword makes a field not visible during serialization.
 *  SerialVersionUID is for validating the object that is passed for serialization.
 */

public class Patient implements Serializable {
    private int patientId;
    private String name;
    private int age;
    private transient int code;
    private static final long SerialVersionUID = 1L;

    public int getPatientId() {
        return patientId;
    }

    public Patient setPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Patient setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
