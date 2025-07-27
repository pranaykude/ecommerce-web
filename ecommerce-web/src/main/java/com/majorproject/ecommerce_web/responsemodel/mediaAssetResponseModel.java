package com.majorproject.ecommerce_web.responsemodel;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class mediaAssetResponseModel {


	private String type;
	private String  imageUrl;
	private String videoUrl;
	private String linkUrl;
	private String overlayText;
	private Boolean isActive;
	private Timestamp startTime;
	private Timestamp endTime;
	
}

