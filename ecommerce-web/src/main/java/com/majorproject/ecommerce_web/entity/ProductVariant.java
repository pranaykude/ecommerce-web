package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product_variants database table.
 * 
 */
@Entity
@Table(name="product_variants")
@NamedQuery(name="ProductVariant.findAll", query="SELECT p FROM ProductVariant p")
public class ProductVariant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="variant_id")
	private int variantId;

	private String color;

	@Column(name="created_at")
	private Timestamp createdAt;

	private BigDecimal discount;

	@Column(name="is_deleted")
	private int isDeleted;

	private BigDecimal price;

	private int quantity;

	private String size;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to ProductReview
	@OneToMany(mappedBy="productVariant")
	private List<ProductReview> productReviews;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProductVariant() {
	}

	public int getVariantId() {
		return this.variantId;
	}

	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<ProductReview> getProductReviews() {
		return this.productReviews;
	}

	public void setProductReviews(List<ProductReview> productReviews) {
		this.productReviews = productReviews;
	}

	public ProductReview addProductReview(ProductReview productReview) {
		getProductReviews().add(productReview);
		productReview.setProductVariant(this);

		return productReview;
	}

	public ProductReview removeProductReview(ProductReview productReview) {
		getProductReviews().remove(productReview);
		productReview.setProductVariant(null);

		return productReview;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}