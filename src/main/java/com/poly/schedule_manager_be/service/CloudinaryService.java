package com.poly.schedule_manager_be.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    Map<String, Object> uploadFile(MultipartFile file) throws IOException;
    String uploadImage(File file, String publicId) throws IOException;
    void deleteImage(String imageUrl);
    String extractPublicId(String imageUrl);
}
