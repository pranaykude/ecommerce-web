package com.majorproject.ecommerce_web.converter.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.majorproject.ecommerce_web.entity.Product;
import com.majorproject.ecommerce_web.entity.ProductImage;
import com.majorproject.ecommerce_web.entity.ProductVariant;
import com.majorproject.ecommerce_web.responsemodel.ProductVariantResponseModel;
import com.majorproject.ecommerce_web.responsemodel.createProductResponseModel;

@Component
public class productManagementEntityToModel {

	   public createProductResponseModel convertToProductResponse(Product product, List<ProductImage> images, List<ProductVariant> variants) {
	        createProductResponseModel response = new createProductResponseModel();

	        response.setProductId(product.getProductId());
	        response.setProductName(product.getName());
	        response.setDescription(product.getDescription());
	        response.setBrand(product.getBrand().getName());
	        response.setCategory(product.getCategory().getName());
	        response.setSubcategory(product.getSubcategory().getName());
	        response.setCreatedAt(product.getCreatedAt());
	        response.setUpdatedAt(product.getUpdatedAt());

	        // Convert images to URLs
	        List<String> imageUrls = images.stream()
	                .map(ProductImage::getImageUrl)
	                .collect(Collectors.toList());
	        response.setImageUrls(imageUrls);

	        // Convert variants
	        List<ProductVariantResponseModel> variantModels = variants.stream()
	                .map(variant -> {
	                    ProductVariantResponseModel vm = new ProductVariantResponseModel();
	                    vm.setVariantId(variant.getVariantId());
	                    vm.setColor(variant.getColor());
	                    vm.setSize(variant.getSize());
	                    vm.setPrice(variant.getPrice());
	                    vm.setDiscount(variant.getDiscount());
	                    vm.setQuantity(variant.getQuantity());
	                    return vm;
	                }).collect(Collectors.toList());
	        response.setVariants(variantModels);

	        return response;
	    }
	
	
	
}
