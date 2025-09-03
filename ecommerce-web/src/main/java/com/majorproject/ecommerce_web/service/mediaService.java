package com.majorproject.ecommerce_web.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.majorproject.ecommerce_web.converter.entity.mediaAssetModelToEntity;
import com.majorproject.ecommerce_web.converter.model.mediaAssetEntityToModel;
import com.majorproject.ecommerce_web.entity.WebsiteAsset;
import com.majorproject.ecommerce_web.repo.WebsiteAssetrepo;
import com.majorproject.ecommerce_web.requestmodel.mediaAssetRequestModel;
import com.majorproject.ecommerce_web.responsemodel.mediaAssetResponseModel;

@Service
public class mediaService {

	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@Autowired
	private mediaAssetModelToEntity assetModelToEntity;
	
	@Autowired
	private WebsiteAssetrepo assetrepo;
	
	@Autowired
	private mediaAssetEntityToModel assetEntityToModel;
	
	
	public mediaAssetResponseModel uploadMediaAsset(mediaAssetRequestModel model) throws IOException {
	    String imagePath = null;
	    String videoPath = null;

	    // Save Image
	    if (model.getImageUrl() != null && !model.getImageUrl().isEmpty()) {
	        String imageName = UUID.randomUUID() + "_" + model.getImageUrl().getOriginalFilename();
	        Path imageFullPath = Paths.get(uploadDir, "images", imageName);
	        Files.createDirectories(imageFullPath.getParent());
	        Files.copy(model.getImageUrl().getInputStream(), imageFullPath, StandardCopyOption.REPLACE_EXISTING);
	        imagePath = "/assets/images/" + imageName;
	    }

	    // Save Video
	    if (model.getVideoUrl() != null && !model.getVideoUrl().isEmpty()) {
	        String videoName = UUID.randomUUID() + "_" + model.getVideoUrl().getOriginalFilename();
	        Path videoFullPath = Paths.get(uploadDir, "videos", videoName);
	        Files.createDirectories(videoFullPath.getParent());
	        Files.copy(model.getVideoUrl().getInputStream(), videoFullPath, StandardCopyOption.REPLACE_EXISTING);
	        videoPath = "/assets/videos/" + videoName;
	    }

	    WebsiteAsset saved = assetrepo.save(
	        assetModelToEntity.toEntity(model, imagePath, videoPath)
	    );

	    return assetEntityToModel.mediaresponse(saved);
	}
}
