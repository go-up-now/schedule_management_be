package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.service.CloudinaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Map;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CloudinaryServiceImpl implements CloudinaryService {
//    private final Cloudinary cloudinary;
//
//    public CloudinaryService() {
//        cloudinary = new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", "huunghia",
//                "api_key", "113631948261186",
//                "api_secret", "etPt63Kn1_f6bg1lvqrayAYXb9Q"));
//    }

    @Override
    public String uploadImage(File file) throws IOException {
//        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
//        return uploadResult.get("url").toString();  // Trả về URL của hình ảnh
        return "";
    }
}
