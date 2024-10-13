package com.poly.schedule_manager_be.service;

import java.io.File;
import java.io.IOException;

public interface CloudinaryService {
    String uploadImage(File file) throws IOException;
}
