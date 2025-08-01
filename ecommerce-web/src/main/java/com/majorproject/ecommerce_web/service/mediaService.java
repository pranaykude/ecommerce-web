package com.majorproject.ecommerce_web.service;

import com.majorproject.ecommerce_web.converter.entity.mediaAssetModelToEntity;
import com.majorproject.ecommerce_web.entity.WebsiteAsset;
import com.majorproject.ecommerce_web.repo.WebsiteAssetrepo;
import com.majorproject.ecommerce_web.requestmodel.mediaAssetRequestModel;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Slf4j
@Service
public class mediaService {

    @Autowired
    private WebsiteAssetrepo assetrepo;

    @Autowired
    private mediaAssetModelToEntity assetModelToEntity;

    @Value("${file.upload-dir}") // Application property key
    private String uploadDir;

    public String uploadMediaAsset(mediaAssetRequestModel model) throws IOException {
        log.info("Uploading media asset of type: {}", model.getType());

        // Time validation
        if (model.getStartTime() != null && model.getEndTime() != null &&
                model.getEndTime().before(model.getStartTime())) {
            log.warn("Invalid time range. Start: {}, End: {}", model.getStartTime(), model.getEndTime());
            throw new IllegalArgumentException("End time must be after start time.");
        }

        String imagePath = null;
        String videoPath = null;

        // Save image
        if (model.getImageUrl() != null && !model.getImageUrl().isEmpty()) {
            imagePath = saveFile(model.getImageUrl(), "images");
            log.info("Image saved at: {}", imagePath);
        }

        // Save video
        if (model.getVideoUrl() != null && !model.getVideoUrl().isEmpty()) {
            videoPath = saveFile(model.getVideoUrl(), "videos");
            log.info("Video saved at: {}", videoPath);
        }

        // Convert model to entity (Make sure assetId is NOT set manually in toEntity())
        WebsiteAsset asset = assetModelToEntity.toEntity(model, imagePath, videoPath);

        log.info("Saving Asset: type={}, image={}, video={}, link={}, overlay={}, start={}, end={}, active={}",
                asset.getType(), asset.getImageUrl(), asset.getVideoUrl(),
                asset.getLinkUrl(), asset.getOverlayText(),
                asset.getStartTime(), asset.getEndTime(), asset.isActive());

        WebsiteAsset saved = assetrepo.save(asset); // Save to DB

        log.info("WebsiteAsset persisted: ID={}, type={}, link={}", saved.getAssetId(), saved.getType(), saved.getLinkUrl());
        return "Media asset uploaded successfully";
    }

    private String saveFile(MultipartFile file, String folder) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir, folder, fileName);

        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        // Return relative path (for DB/API)
        return "/assets/" + folder + "/" + fileName;
    }
}
