package com.dogigiri.core.serialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String fileName = "/home/hkm/Desktop/obj.txt";
        Patient patient = new Patient().setPatientId(1).setAge(10).setName("amir");
        try (OutputStream outputStream = new FileOutputStream(fileName); ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(patient);
        } catch (Exception e) {
            logger.debug("output stream problem");
        }

        try (InputStream inputStream = new FileInputStream(fileName); ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Patient patientFetched = (Patient) objectInputStream.readObject();
            logger.trace(patientFetched.toString());
        } catch (Exception e) {
            logger.debug("Input stream problem");
        }
    }
}
