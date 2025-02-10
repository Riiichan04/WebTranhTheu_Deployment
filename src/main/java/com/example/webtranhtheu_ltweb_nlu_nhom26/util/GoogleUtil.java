package com.example.webtranhtheu_ltweb_nlu_nhom26.util;

import java.io.IOException;
import java.util.Properties;

public class GoogleUtil {
    public static String getGoogleClientId() {
        return System.getenv("google.loginId");
    }

    //Các method khác cần Google Client ID viết ở đây

    //Class private để chỉ tạo được properties khi cần
//    private static class GoogleProperties {
//        private static Properties properties = new Properties();
//
//        //Load properties
//        static {
//            try {
//                properties.load(GoogleProperties.class.getClassLoader().getResourceAsStream("gg.properties"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        public static Properties getProperties() {
//            return properties;
//        }
//    }
}
