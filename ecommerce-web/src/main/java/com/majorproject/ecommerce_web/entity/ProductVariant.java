package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
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
	@Column(name="variant_id")
	private int variantId;

	private String color;

	@Column(name="discount_percentage")
	private BigDecimal discountPercentage;

	@Column(name="is_deleted")
	private int isDeleted;

	private BigDecimal price;

	private String size;

	@Column(name="sku_code")
	private String skuCode;

	private int stock;

	//bi-directional many-to-one association to CartItem
	@OneToMany(mappedBy="productVariant")
	private List<CartItem> cartItems;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="productVariant")
	private List<ProductImage> productImages;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to WishlistItem
	@OneToMany(mappedBy="productVariant")
	private List<WishlistItem> wishlistItems;

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

	public BigDecimal getDiscountPercentage() {
		return this.discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
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

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSkuCode() {
		return this.skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<CartItem> getCartItems() {
		return this.cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public CartItem addCartItem(CartItem cartItem) {
		getCartItems().add(cartItem);
		cartItem.setProductVariant(this);

		return cartItem;
	}

	public CartItem removeCartItem(CartItem cartItem) {
		getCartItems().remove(cartItem);
		cartItem.setProductVariant(null);

		return cartItem;
	}

	public List<ProductImage> getProductImages() {
		return this.productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public ProductImage addProductImage(ProductImage productImage) {
		getProductImages().add(productImage);
		productImage.setProductVariant(this);

		return productImage;
	}

	public ProductImage removeProductImage(ProductImage productImage) {
		getProductImages().remove(productImage);
		productImage.setProductVariant(null);

		return productImage;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<WishlistItem> getWishlistItems() {
		return this.wishlistItems;
	}

	public void setWishlistItems(List<WishlistItem> wishlistItems) {
		this.wishlistItems = wishlistItems;
	}

	public WishlistItem addWishlistItem(WishlistItem wishlistItem) {
		getWishlistItems().add(wishlistItem);
		wishlistItem.setProductVariant(this);

		return wishlistItem;
	}

	public WishlistItem removeWishlistItem(WishlistItem wishlistItem) {
		getWishlistItems().remove(wishlistItem);
		wishlistItem.setProductVariant(null);

		return wishlistItem;
	}

}