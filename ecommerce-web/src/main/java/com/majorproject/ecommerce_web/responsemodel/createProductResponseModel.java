package com.majorproject.ecommerce_web.responsemodel;


import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class createProductResponseModel {

	
	private Integer productId;
    private String productName;
    private String description;
    private String brand;
    private String category;
    private String subcategory;
    private List<String> imageUrls;
    private List<ProductVariantResponseModel> variants;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
}
