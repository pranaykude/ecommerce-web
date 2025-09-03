package com.majorproject.ecommerce_web.requestmodel;


import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class mediaAssetRequestModel {

	private String type;
	private MultipartFile imageUrl;
	private MultipartFile  videoUrl;
	private String linkUrl;
	private String overlayText;
	private Boolean isActive;
	private Timestamp startTime;
	private Timestamp endTime;
	
	
	
	
	
	
}
