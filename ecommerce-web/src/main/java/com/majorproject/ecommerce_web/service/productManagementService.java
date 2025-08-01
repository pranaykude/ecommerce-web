package com.majorproject.ecommerce_web.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.majorproject.ecommerce_web.converter.entity.productManagementModelToEntity;
import com.majorproject.ecommerce_web.converter.model.productManagementEntityToModel;
import com.majorproject.ecommerce_web.entity.*;
import com.majorproject.ecommerce_web.repo.*;
import com.majorproject.ecommerce_web.requestmodel.CreateProductRequestModel;
import com.majorproject.ecommerce_web.responsemodel.createProductResponseModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class productManagementService {

    @Autowired
    private productManagementModelToEntity modelToEntity;

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private SubCategoryRepo subCategoryRepo;

    @Autowired
    private ProductImageRepo imageRepo;

    @Autowired
    private ProductVariantRepo variantRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private  productManagementEntityToModel entityToModel;

    public createProductResponseModel createProduct(CreateProductRequestModel model, MultipartFile[] imageFiles) {
        log.info("[CreateProduct] Initiated product creation.");
        log.info("[DEBUG] Received subcategory ID from model: {}", model.getSubcategoryId());


        // Log the incoming request (you can log just IDs to avoid huge logs)
        log.debug("[CreateProduct] Request received: productName={}, brandId={}, categoryId={}, subcategoryId={}",
                model.getProductName(),model.getBrandId(),model.getCategoryId(),model.getSubcategoryId());

        // Validate foreign keys
        Brand brand = brandRepo.findById(model.getBrandId())
                .orElseThrow(() -> {
                    log.warn("[CreateProduct] Invalid brand ID: {}", model.getBrandId());
                    return new IllegalArgumentException("Invalid brand ID");
                });

        Category category = categoryRepo.findById(model.getCategoryId())
                .orElseThrow(() -> {
                    log.warn("[CreateProduct] Invalid category ID: {}", model.getCategoryId());
                    return new IllegalArgumentException("Invalid category ID");
                });

        Subcategory subcategory = subCategoryRepo.findActiveById(model.getSubcategoryId())
                .orElseThrow(() -> {
                    log.warn("[CreateProduct] Invalid subcategory ID: {}", model.getSubcategoryId());
                    return new IllegalArgumentException("Invalid subcategory ID");
                });


        if (model.getVariants() == null || model.getVariants().isEmpty()) {
            log.error("[CreateProduct] No product variants provided.");
            throw new IllegalArgumentException("At least one product variant is required.");
        }

        // Convert to entity and save product
        Product product = modelToEntity.convertToProductEntity(model, brand, category, subcategory);
        product = productRepo.save(product);
        log.info("[CreateProduct] Product saved. ID: {}", product.getProductId());

       
        // Save variants
        List<ProductVariant> variants = modelToEntity.convertToProductVariants(product, model.getVariants());
        variantRepo.saveAll(variants);
        log.info("[CreateProduct] {} product variants saved to DB.", variants.size());

        
        // Save images from MultipartFile[]
        List<String> imageUrls = saveImagesToDisk(imageFiles);
        List<ProductImage> images = modelToEntity.convertToProductImages(product, imageUrls);
        imageRepo.saveAll(images);
        
        
        // Prepare response
        createProductResponseModel response = entityToModel.convertToProductResponse(product, images, variants);
        log.info("[CreateProduct] Product creation completed successfully.");

        return response;
    }

    private List<String> saveImagesToDisk(MultipartFile[] files) {
        String basePath = "upload/images/"; // ⛏️ Move to config later
        File directory = new File(basePath);
        if (!directory.exists() && directory.mkdirs()) {
            log.info("[FileUpload] Created directory: {}", basePath);
        }

        List<String> imageUrls = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                log.warn("[FileUpload] Skipping empty file.");
                continue;
            }

            try {
                String originalFilename = sanitizeFilename(file.getOriginalFilename());
                String uniqueName = UUID.randomUUID() + "_" + originalFilename;
                String fullPath = basePath + uniqueName;

                File destFile = new File(fullPath);
                file.transferTo(destFile);
                log.info("[FileUpload] Stored file: {}", fullPath);

                imageUrls.add("/upload/images/" + uniqueName); // Assuming this will be served as static content
            } catch (IOException e) {
                log.error("[FileUpload] Failed to upload image: {}", e.getMessage(), e);
                throw new RuntimeException("Failed to store image file: " + file.getOriginalFilename());
            }
        }

        return imageUrls;
    }

    private String sanitizeFilename(String filename) {
        if (filename == null) return "unnamed";
        return filename.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
    }
}
    
    
    
    
    
    

