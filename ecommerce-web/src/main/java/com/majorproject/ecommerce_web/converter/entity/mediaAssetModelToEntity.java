package com.majorproject.ecommerce_web.converter.entity;

import org.springframework.stereotype.Component;

import com.majorproject.ecommerce_web.entity.WebsiteAsset;
import com.majorproject.ecommerce_web.requestmodel.mediaAssetRequestModel;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class mediaAssetModelToEntity {

	
	public WebsiteAsset toEntity(mediaAssetRequestModel model, String imagePath, String videoPath) {
		log.info("assetId before save: {}", model.getAssetId());
	    WebsiteAsset asset = new WebsiteAsset();
	    asset.setType(WebsiteAsset.AssetType.valueOf(model.getType()));
	    asset.setImageUrl(imagePath);
	    asset.setVideoUrl(videoPath); // <-- Fix
	    asset.setOverlayText(model.getOverlayText());
	    asset.setLinkUrl(model.getLinkUrl());
	    asset.setStartTime(model.getStartTime());
	    asset.setEndTime(model.getEndTime());
	    asset.setActive(model.getIsActive() != null ? model.getIsActive() : true);
	    return asset;
	}

	
}
