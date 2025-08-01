package com.majorproject.ecommerce_web.responsemodel;

import lombok.Data;

@Data
public class ProductVariantResponseModel {
    private Integer variantId;
    private String color;
    private String size;
    private Double price;
    private Double discount;
    private Integer quantity;
}
