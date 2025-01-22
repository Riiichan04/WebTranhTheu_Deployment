package com.example.webtranhtheu_ltweb_nlu_nhom26.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailSender {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(EmailSender.class.getClassLoader().getResourceAsStream("email.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendConfirmationEmail(String toEmail, int token) {
        // Cấu hình server SMTP
        String host = "smtp.gmail.com";
        final String username = properties.getProperty("NAME_EMAIL");
        final String password = properties.getProperty("PASS_EMAIL");

        // Cấu hình thuộc tính hệ thống
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // Tạo phiên làm việc (session)
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo thông báo email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            String subject = "Xác thực tài khoản!";
            message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));

            String emailContent = "<html>" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<style>" +
                    "   body { font-family: 'Arial', sans-serif; font-size: 16px; color: #333333; }" +
                    "   h2 { color: #2C3E50; }" +
                    "   p { font-size: 14px; }" +
                    "   strong { color: #E74C3C; }" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<h2>Chào bạn!</h2>" +
                    "<p>Mã xác thực tài khoản web bán tranh thêu Nét Việt của bạn là: <strong>" + token + "</strong></p>" +
                    "</body>" +
                    "</html>";

            // Tạo email với nội dung mã hóa UTF-8
            message.setContent(emailContent, "text/html; charset=UTF-8");

            // Gửi email
            Transport.send(message);

            System.out.println("Email đã được gửi thành công!");

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
