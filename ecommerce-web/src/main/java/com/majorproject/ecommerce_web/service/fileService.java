package com.majorproject.ecommerce_web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class fileService {

    @Value("${File.upload-dir:./upload}")
    private String baseStoragePath;

    @Value("${app.max-file-size}")
    private long FileMaxSize;

    private final String[] IMAGE_TYPES = { "image/jpeg", "image/png", "image/webp" };
    private final String[] VIDEO_TYPES = { "video/mp4", "video/mpeg" };
    private final String[] ALLOWED_TYPES = { "application/pdf", "text/plain" };

    @PostConstruct
    public void init() {
        log.info("Initializing base storage directory: {}", baseStoragePath);
        File baseDir = new File(baseStoragePath);
        if (!baseDir.exists()) {
            boolean created = baseDir.mkdirs();
            log.info("Storage directory created: {}", created);
        } else {
            log.info("Storage directory already exists.");
        }
    }

    public String saveFile(MultipartFile file, String subFolder) throws IOException {
        validateFile(file);

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String uniqueName = UUID.randomUUID() + "." + extension;
        String storagePath = baseStoragePath + File.separator + subFolder;

        File directory = new File(storagePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String finalPath = storagePath + File.separator + uniqueName;
        file.transferTo(new File(finalPath)); // Missing line in your original code

        log.info("File uploaded successfully: {}", finalPath);
        return finalPath;
    }

    private void validateFile(MultipartFile file) throws IOException {
        log.info("Validating the file and its size...");
        if (file.isEmpty()) {
            throw new IOException("File is empty.");
        }
        if (file.getSize() > FileMaxSize) {
            throw new IOException("File size exceeds the allowed limit of " + FileMaxSize);
        }
        String contentType = file.getContentType();
        if (!isAllowedType(contentType)) {
            throw new IOException("File type " + contentType + " is not supported.");
        }
    }

    private boolean isAllowedType(String type) {
        return isInArray(IMAGE_TYPES, type) ||
               isInArray(VIDEO_TYPES, type) ||
               isInArray(ALLOWED_TYPES, type);
    }

    private boolean isInArray(String[] array, String value) {
        for (String v : array) {
            if (v.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
