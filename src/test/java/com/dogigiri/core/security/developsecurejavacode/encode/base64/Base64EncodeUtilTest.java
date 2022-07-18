package com.dogigiri.core.security.developsecurejavacode.encode.base64;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class Base64EncodeUtilTest {
    @Test
    void encodeFile() {
        File imageFile = new File("/home/dogigiri/Dogigiri-Code/Courses/Sematec/Secure Java Development/Session 2/" +
                "Exercises/jce/src/main/resources/assets/images/java.jpg");
        String encodedData = Base64EncodeUtil.encodeFile(imageFile);
        LoggerFactory.getLogger(com.dogigiri.core.security.developsecurejavacode.encode.base64.Base64EncodeUtilTest.class).info(encodedData);
        assertThat(encodedData).isNotNull().isBase64();
    }

    @Test
    void decodeData() {
        File imageFile = new File("/home/dogigiri/Dogigiri-Code/Courses/Sematec/Secure Java Development/Session 2/" +
                "Exercises/jce/src/main/resources/assets/images/java.jpg");
        String encodedData = Base64EncodeUtil.encodeFile(imageFile);
        Base64EncodeUtil.createFileFromBase64Data(encodedData, "/home/dogigiri/java.jpg");
    }
}