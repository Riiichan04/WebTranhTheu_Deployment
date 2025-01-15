package com.example.webtranhtheu_ltweb_nlu_nhom26.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.Properties;

public class CloudinaryConfig {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(CloudinaryConfig.class.getClassLoader().getResourceAsStream("cloud.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Cloudinary getCloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", properties.getProperty("cloud_name"),
                "api_key", properties.getProperty("api_key"),
                "api_secret", properties.getProperty("api_secret")));
        return cloudinary;
    }

    public static String getUrl(Part filePart) throws IOException {
        if (filePart != null) {
            // Lấy tên tệp từ phần yêu cầu
            String fileName = filePart.getSubmittedFileName();

            // Lưu tệp vào một tệp tạm thời
            File tempFile = File.createTempFile("upload_", fileName);
            try (InputStream fileContent = filePart.getInputStream()) {
                // Copy InputStream vào tệp tạm thời
                Files.copy(fileContent, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Tải tệp lên Cloudinary từ tệp tạm
                Map<String, Object> uploadResult = CloudinaryConfig.getCloudinary().uploader().upload(tempFile, ObjectUtils.emptyMap());

                // Lấy URL của tệp đã tải lên
                String fileUrl = (String) uploadResult.get("url");

                return fileUrl;
            } catch (Exception e) {
                return "https://res.cloudinary.com/dh90ponfw/image/upload/v1736864014/defaultavatar.jpg";
            } finally {
                // Xóa tệp tạm sau khi sử dụng
                tempFile.delete();
            }
        } else {
            return "https://res.cloudinary.com/dh90ponfw/image/upload/v1736864014/defaultavatar.jpg";
        }
    }
}
