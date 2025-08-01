package com.majorproject.ecommerce_web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.majorproject.ecommerce_web.config.BeanConfig;
import com.majorproject.ecommerce_web.requestmodel.CreateProductRequestModel;
import com.majorproject.ecommerce_web.responsemodel.createProductResponseModel;
import com.majorproject.ecommerce_web.restResponse.RestResponse;
import com.majorproject.ecommerce_web.service.productManagementService;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/admin/products")
@Slf4j
public class productMangementController {

    @Autowired
    private productManagementService productManagementService;
    
    @Autowired
   private ObjectMapper mapper;

    public productMangementController() {
        log.info("Product Management Controller initialized.");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE ,produces = "Applcation/Json")
    public RestResponse createProduct(
             @RequestParam("productJson")  String  productJson,
            @RequestPart("images")  MultipartFile[] images) throws JsonMappingException, JsonProcessingException {

        log.info("Received request to create product: {}", productJson);
        
        CreateProductRequestModel requestModel = mapper.readValue(productJson, CreateProductRequestModel.class);
        log.info("createProductRequestModel successfully parsed.");
        try {
            createProductResponseModel response = productManagementService.createProduct(requestModel, images);
            log.info("Product created successfully with name: {}", requestModel.getProductName());
            return RestResponse.build().withSuccess("Product created successfully.", response);
        } catch (Exception e) {
            log.error("Product creation failed: {}", e.getMessage(), e);
            return RestResponse.build().withError("Product creation failed: " + e.getMessage());
        }
    }
}
