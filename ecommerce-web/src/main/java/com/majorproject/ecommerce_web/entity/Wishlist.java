package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the wishlists database table.
 * 
 */
@Entity
@Table(name="wishlists")
@NamedQuery(name="Wishlist.findAll", query="SELECT w FROM Wishlist w")
public class Wishlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wishlist_id")
	private int wishlistId;

	@Column(name="is_deleted")
	private int isDeleted;

	//bi-directional many-to-one association to WishlistItem
	@OneToMany(mappedBy="wishlist")
	private List<WishlistItem> wishlistItems;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Wishlist() {
	}

	public int getWishlistId() {
		return this.wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<WishlistItem> getWishlistItems() {
		return this.wishlistItems;
	}

	public void setWishlistItems(List<WishlistItem> wishlistItems) {
		this.wishlistItems = wishlistItems;
	}

	public WishlistItem addWishlistItem(WishlistItem wishlistItem) {
		getWishlistItems().add(wishlistItem);
		wishlistItem.setWishlist(this);

		return wishlistItem;
	}

	public WishlistItem removeWishlistItem(WishlistItem wishlistItem) {
		getWishlistItems().remove(wishlistItem);
		wishlistItem.setWishlist(null);

		return wishlistItem;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}