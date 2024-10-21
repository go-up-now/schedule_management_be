package com.poly.schedule_manager_be.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.poly.schedule_manager_be.service.CloudinaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    @Override
    public Map<String, Object> uploadFile(MultipartFile file) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return uploadResult;
    }

    // Hàm để upload hình ảnh và trả về URL
    @Override
    public String uploadImage(File file, String publicId) throws IOException {
        Map uploadParams = ObjectUtils.asMap("public_id", publicId, "overwrite", true);
        Map result = cloudinary.uploader().upload(file, uploadParams);
        return result.get("url").toString(); // Trả về URL của hình ảnh
    }

    @Override
    public void deleteImage(String imageUrl) {
        try {
            String publicId = extractPublicId(imageUrl);
            // Xóa hình ảnh trên Cloudinary
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String extractPublicId(String imageUrl) {
        String[] parts = imageUrl.split("/");
        String publicIdWithExtension = parts[parts.length - 1];
        String[] idParts = publicIdWithExtension.split("\\.");
        return idParts[0];
    }
}
