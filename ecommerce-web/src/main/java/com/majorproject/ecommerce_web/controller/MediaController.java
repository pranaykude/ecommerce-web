package com.majorproject.ecommerce_web.controller;

import com.majorproject.ecommerce_web.entity.WebsiteAsset.AssetType;
import com.majorproject.ecommerce_web.requestmodel.mediaAssetRequestModel;
import com.majorproject.ecommerce_web.restResponse.RestResponse;
import com.majorproject.ecommerce_web.service.mediaService;

import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/assets")
public class MediaController {

    @Autowired
    private mediaService service;

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse uploadMediaAsset(
            @Parameter(description = "Type of media", required = true)
            @RequestParam("type") AssetType type,
            @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl,
            @RequestParam(value = "videoUrl", required = false) MultipartFile videoUrl,
            @RequestParam(value = "linkUrl", required = false) String linkUrl,
            @RequestParam(value = "overlayText", required = false) String overlayText,
            @RequestParam(value = "isActive", required = false) Boolean isActive,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime
    ) {
        try {
            mediaAssetRequestModel requestModel = new mediaAssetRequestModel();
            requestModel.setType(type.name());
            requestModel.setImageUrl(imageUrl);
            requestModel.setVideoUrl(videoUrl);
            requestModel.setLinkUrl(linkUrl);
            requestModel.setOverlayText(overlayText);
            requestModel.setIsActive(isActive);

            if (startTime != null)
                requestModel.setStartTime(Timestamp.valueOf(startTime));
            if (endTime != null)
                requestModel.setEndTime(Timestamp.valueOf(endTime));

            String  response = service.uploadMediaAsset(requestModel);
            System.out.println("Incoming asset: " + response.toString());

            return RestResponse.build().withSuccess("Media uploaded successfully", response);

        } catch (Exception e) {
            return RestResponse.build().withError("Upload failed: " + e.getMessage());
        }
    }
}
