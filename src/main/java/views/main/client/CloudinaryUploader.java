/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.main.client;

/**
 *
 * @author GIANG
 */
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryUploader {
    private Cloudinary cloudinary;

    public CloudinaryUploader() {
        // Cấu hình Cloudinary
        String CLOUDINARY_URL = "cloudinary://462886354475568:7IyZ1fMXe--ZoDhLd9hr4zlkGOQ@djfpcyyfe";
        cloudinary = new Cloudinary(CLOUDINARY_URL);
        cloudinary.config.secure = true;
    }

    public String uploadFile(File file) {
        try {
            // Thiết lập tham số upload
            Map<String, Object> uploadParams = new HashMap<>();
            uploadParams.put("resource_type", "auto");

            // Upload file lên Cloudinary
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file, uploadParams);

            // Lấy URL công khai của file đã upload
            return (String) uploadResult.get("secure_url");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

