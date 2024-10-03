package com.poly.schedule_manager_be.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class GlobleConfig implements WebMvcConfigurer{
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:3000") // Cho phép từ domain front-end của bạn
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Các phương thức được phép
//                        .allowedHeaders("*") // Cho phép tất cả các headers
//                        .allowCredentials(true); // Nếu bạn sử dụng cookie hoặc token
//            }
//        };
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Áp dụng CORS cho tất cả các endpoint
//                .allowedOrigins("http://localhost:3000") // Thay đổi thành địa chỉ frontend của bạn
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Các phương thức HTTP được cho phép
//                .allowedHeaders("*") // Các headers được phép
//                .allowCredentials(true); // Cho phép gửi cookies
//    }
}
