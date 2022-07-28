package com.dogigiri.core.security.developsecurejavacode.jce.encode.base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Base64;

public class Base64EncodeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(Base64EncodeUtil.class);

    private Base64EncodeUtil() {

    }

    public static String encodeFile(File file) {
        String imageEncodedData = "";
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] encodedImageData = new byte[(int) file.length()];
            int count;
            while ((count = inputStream.read(encodedImageData)) > 0) {
                count++;
                LOGGER.info("{} bytes read from source", count);
            }
            assert count != 0;
            imageEncodedData = Base64.getEncoder().encodeToString(encodedImageData);
        } catch (FileNotFoundException notFoundException) {
            LOGGER.error("File not found! make sure to pass correct path");
        } catch (IOException ioException) {
            LOGGER.error("Something went wrong trying to read file");
        }
        return imageEncodedData;
    }

    public static void createFileFromBase64Data(String base64Data, String pathFile) {
        try (FileOutputStream outputStream = new FileOutputStream(pathFile)) {
            outputStream.write(Base64.getDecoder().decode(base64Data));
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found");
        } catch (IOException e) {
            LOGGER.error("Something went wrong during writing file");
        }
    }
}
