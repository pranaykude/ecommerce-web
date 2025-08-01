package com.majorproject.ecommerce_web.requestmodel;

import java.util.List;
import lombok.Data;

@Data
public class CreateProductRequestModel {

	
	private String productName ;
	private String description ;
	private Integer brandId;
	private Integer categoryId;
	private Integer subcategoryId;
	private List<productVariantRequestModel> variants;
}
