package com.majorproject.ecommerce_web.requestmodel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class productVariantRequestModel {

    @NotBlank(message = "Color is required")
    private String color;

    @NotBlank(message = "Size is required")
    private String size;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    @NotNull(message = "Discount is required")
    @Min(value = 0, message = "Discount cannot be negative")
    private Double discount;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
}
