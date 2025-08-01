package com.majorproject.ecommerce_web.converter.entity;

import com.majorproject.ecommerce_web.entity.*;
import com.majorproject.ecommerce_web.requestmodel.CreateProductRequestModel;
import com.majorproject.ecommerce_web.requestmodel.productVariantRequestModel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class productManagementModelToEntity {

    public Product convertToProductEntity(CreateProductRequestModel model, Brand brand, Category category, Subcategory subCategory) {
        Product product = new Product();
        product.setName(model.getProductName());
        product.setDescription(model.getDescription());
        product.setBrand(brand);
        product.setCategory(category);
        product.setSubcategory(subCategory);
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return product;
    }

    public List<ProductImage> convertToProductImages(Product product, List<String> imageUrls) {
        List<ProductImage> images = new ArrayList<>();
        for (String url : imageUrls) {
            ProductImage image = new ProductImage();
            image.setProduct(product);
            image.setImageUrl(url);
            image.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            image.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            images.add(image);
        }
        return images;
    }

    public List<ProductVariant> convertToProductVariants(Product product, List<productVariantRequestModel> variants){
        List<ProductVariant> variantEntities = new ArrayList<>();
        for (productVariantRequestModel variant :variants) {
            ProductVariant entity = new ProductVariant();
            entity.setProduct(product);
            entity.setColor(variant.getColor());
            entity.setSize(variant.getSize());
            entity.setPrice(variant.getPrice());
            entity.setDiscount(variant.getDiscount());
            entity.setQuantity(variant.getQuantity());
            entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            entity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            variantEntities.add(entity);
        }
        return variantEntities;
    }

}
