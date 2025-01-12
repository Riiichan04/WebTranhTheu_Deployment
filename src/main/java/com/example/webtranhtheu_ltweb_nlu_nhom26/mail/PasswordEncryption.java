package com.example.webtranhtheu_ltweb_nlu_nhom26.mail;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {
    // Mã hóa mật khẩu
    public static String hashPassword(String password) {
        // Tạo salt và mã hóa mật khẩu
        String salt = BCrypt.gensalt(12); //cost factor
        return BCrypt.hashpw(password, salt);
    }

    //kiểm tra pass có hợp lệ không
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
