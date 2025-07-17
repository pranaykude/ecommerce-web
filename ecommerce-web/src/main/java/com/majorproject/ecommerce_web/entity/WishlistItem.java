package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the wishlist_items database table.
 * 
 */
@Entity
@Table(name="wishlist_items")
@NamedQuery(name="WishlistItem.findAll", query="SELECT w FROM WishlistItem w")
public class WishlistItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wishlist_item_id")
	private int wishlistItemId;

	@Column(name="is_deleted")
	private int isDeleted;

	//bi-directional many-to-one association to ProductVariant
	@ManyToOne
	@JoinColumn(name="variant_id")
	private ProductVariant productVariant;

	//bi-directional many-to-one association to Wishlist
	@ManyToOne
	@JoinColumn(name="wishlist_id")
	private Wishlist wishlist;

	public WishlistItem() {
	}

	public int getWishlistItemId() {
		return this.wishlistItemId;
	}

	public void setWishlistItemId(int wishlistItemId) {
		this.wishlistItemId = wishlistItemId;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public ProductVariant getProductVariant() {
		return this.productVariant;
	}

	public void setProductVariant(ProductVariant productVariant) {
		this.productVariant = productVariant;
	}

	public Wishlist getWishlist() {
		return this.wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

}