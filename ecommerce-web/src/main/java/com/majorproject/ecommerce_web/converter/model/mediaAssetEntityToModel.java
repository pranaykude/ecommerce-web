package com.majorproject.ecommerce_web.converter.model;

import org.springframework.stereotype.Component;

import com.majorproject.ecommerce_web.entity.WebsiteAsset;
import com.majorproject.ecommerce_web.responsemodel.mediaAssetResponseModel;

@Component
public class mediaAssetEntityToModel {

	
	public mediaAssetResponseModel mediaresponse (WebsiteAsset asset) {
	
		mediaAssetResponseModel response = new mediaAssetResponseModel();
	    response.setType(asset.getType().name());
	    response.setImageUrl(asset.getImageUrl());
	    response.setVideoUrl(asset.getVideoUrl());
	    response.setLinkUrl(asset.getLinkUrl());
	    response.setOverlayText(asset.getOverlayText());
	    response.setIsActive(asset.isActive());
	    response.setStartTime(asset.getStartTime());
	    response.setEndTime(asset.getEndTime());
	    return response;
	}
	
	
}
