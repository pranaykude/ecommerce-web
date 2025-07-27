package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the product_views database table.
 * 
 */
@Entity
@Table(name="product_views")
@NamedQuery(name="ProductView.findAll", query="SELECT p FROM ProductView p")
public class ProductView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="view_id")
	private int viewId;

	@Column(name="is_deleted")
	private int isDeleted;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="viewed_at")
	private Timestamp viewedAt;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public ProductView() {
	}

	public int getViewId() {
		return this.viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getViewedAt() {
		return this.viewedAt;
	}

	public void setViewedAt(Timestamp viewedAt) {
		this.viewedAt = viewedAt;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}