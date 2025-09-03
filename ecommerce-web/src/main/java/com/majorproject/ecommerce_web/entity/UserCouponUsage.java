package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_coupon_usage database table.
 * 
 */
@Entity
@Table(name="user_coupon_usage")
@NamedQuery(name="UserCouponUsage.findAll", query="SELECT u FROM UserCouponUsage u")
public class UserCouponUsage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usage_id")
	private int usageId;

	@Column(name="is_deleted")
	private int isDeleted;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="used_at")
	private Timestamp usedAt;

	//bi-directional many-to-one association to Coupon
	@ManyToOne
	@JoinColumn(name="coupon_id")
	private Coupon coupon;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserCouponUsage() {
	}

	public int getUsageId() {
		return this.usageId;
	}

	public void setUsageId(int usageId) {
		this.usageId = usageId;
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

	public Timestamp getUsedAt() {
		return this.usedAt;
	}

	public void setUsedAt(Timestamp usedAt) {
		this.usedAt = usedAt;
	}

	public Coupon getCoupon() {
		return this.coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}