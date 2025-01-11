package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Verify;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.VerifyDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import com.example.webtranhtheu_ltweb_nlu_nhom26.mail.EmailSender;
import java.sql.Timestamp;
import java.util.Random;

public class VerifyService {
    final private VerifyDAO verifyDAO;

    public VerifyService() {
        verifyDAO = JDBIConnector.getInstance().onDemand(VerifyDAO.class);
    }

    public Integer checkCode(int code) {
        return verifyDAO.getVerifyCode(code);
    }

    // Hàm tạo mã xác nhận ngẫu nhiên
    public static int generateVerificationCode() {
        Random random = new Random();
        return random.nextInt(10000000, 100000000);
    }

    // Gửi email xác nhận chứa mã verifycode
    public void sendVerificationEmail(String toEmail, int accountId) {

        // dateExpire là 1 giờ sau khi tạo mã
        Timestamp dateExpire = new Timestamp(System.currentTimeMillis() + 60 * 60 * 1000);  // 1 giờ sau
        boolean created = false;
        int generatedVerificationCode = 0;
        while(!created) {
            //Lưu verifyCode vào bảng verify_accounts
            generatedVerificationCode = generateVerificationCode();
            created = verifyDAO.insertVerifyAccount(new Verify(accountId, generatedVerificationCode, dateExpire));
        }

        // Gửi email logic
        EmailSender.sendConfirmationEmail(toEmail, generatedVerificationCode);
    }
}
