package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the product_images database table.
 * 
 */
@Entity
@Table(name="product_images")
@NamedQuery(name="ProductImage.findAll", query="SELECT p FROM ProductImage p")
public class ProductImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="image_id")
	private int imageId;

	@Lob
	@Column(name="image_url")
	private String imageUrl;

	@Column(name="img_type")
	private String imgType;

	@Column(name="is_deleted")
	private int isDeleted;

	@Column(name="is_primary")
	private int isPrimary;

	//bi-directional many-to-one association to ProductVariant
	@ManyToOne
	@JoinColumn(name="variant_id")
	private ProductVariant productVariant;

	public ProductImage() {
	}

	public int getImageId() {
		return this.imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImgType() {
		return this.imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getIsPrimary() {
		return this.isPrimary;
	}

	public void setIsPrimary(int isPrimary) {
		this.isPrimary = isPrimary;
	}

	public ProductVariant getProductVariant() {
		return this.productVariant;
	}

	public void setProductVariant(ProductVariant productVariant) {
		this.productVariant = productVariant;
	}

}