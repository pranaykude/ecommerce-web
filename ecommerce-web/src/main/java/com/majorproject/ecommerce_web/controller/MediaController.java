package com.majorproject.ecommerce_web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.majorproject.ecommerce_web.requestmodel.mediaAssetRequestModel;
import com.majorproject.ecommerce_web.responsemodel.mediaAssetResponseModel;
import com.majorproject.ecommerce_web.restResponse.RestResponse;
import com.majorproject.ecommerce_web.service.mediaService;

import java.sql.Timestamp;
@RestController
@RequestMapping("/api/assets")
public class MediaController {

    @Autowired
    private mediaService service;

    @PostMapping(
        value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse uploadMediaAsset(
            @RequestPart("type") String type,
            @RequestPart(value = "imageUrl", required = false) MultipartFile imageUrl,
            @RequestPart(value = "videoUrl", required = false) MultipartFile videoUrl,
            @RequestPart(value = "linkUrl", required = false) String linkUrl,
            @RequestPart(value = "overlayText", required = false) String overlayText,
            @RequestPart(value = "isActive", required = false) Boolean isActive,
            @RequestPart(value = "startTime", required = false) String startTime,
            @RequestPart(value = "endTime", required = false) String endTime
    ) {
        try {
            mediaAssetRequestModel requestModel = new mediaAssetRequestModel();
            requestModel.setType(type);
            requestModel.setImageUrl(imageUrl);
            requestModel.setVideoUrl(videoUrl);
            requestModel.setLinkUrl(linkUrl);
            requestModel.setOverlayText(overlayText);
            requestModel.setIsActive(isActive);

            if (startTime != null)
                requestModel.setStartTime(Timestamp.valueOf(startTime));
            if (endTime != null)
                requestModel.setEndTime(Timestamp.valueOf(endTime));

            mediaAssetResponseModel response = service.uploadMediaAsset(requestModel);
            return RestResponse.build().withSuccess("Media uploaded successfully", response);

        } catch (Exception e) {
            return RestResponse.build().withError("Failed to upload media file: " + e.getMessage());
        }
    }
}
