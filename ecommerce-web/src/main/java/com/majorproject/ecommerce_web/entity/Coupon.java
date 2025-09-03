package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the coupons database table.
 * 
 */
@Entity
@Table(name="coupons")
@NamedQuery(name="Coupon.findAll", query="SELECT c FROM Coupon c")
public class Coupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coupon_id")
	private int couponId;

	private String code;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="discount_percentage")
	private BigDecimal discountPercentage;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="is_deleted")
	private int isDeleted;

	@Column(name="max_discount_amount")
	private BigDecimal maxDiscountAmount;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="usage_limit")
	private int usageLimit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_from")
	private Date validFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_to")
	private Date validTo;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="coupon")
	private List<Order> orders;

	//bi-directional many-to-one association to UserCouponUsage
	@OneToMany(mappedBy="coupon")
	private List<UserCouponUsage> userCouponUsages;

	public Coupon() {
	}

	public int getCouponId() {
		return this.couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getDiscountPercentage() {
		return this.discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public BigDecimal getMaxDiscountAmount() {
		return this.maxDiscountAmount;
	}

	public void setMaxDiscountAmount(BigDecimal maxDiscountAmount) {
		this.maxDiscountAmount = maxDiscountAmount;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUsageLimit() {
		return this.usageLimit;
	}

	public void setUsageLimit(int usageLimit) {
		this.usageLimit = usageLimit;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCoupon(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCoupon(null);

		return order;
	}

	public List<UserCouponUsage> getUserCouponUsages() {
		return this.userCouponUsages;
	}

	public void setUserCouponUsages(List<UserCouponUsage> userCouponUsages) {
		this.userCouponUsages = userCouponUsages;
	}

	public UserCouponUsage addUserCouponUsage(UserCouponUsage userCouponUsage) {
		getUserCouponUsages().add(userCouponUsage);
		userCouponUsage.setCoupon(this);

		return userCouponUsage;
	}

	public UserCouponUsage removeUserCouponUsage(UserCouponUsage userCouponUsage) {
		getUserCouponUsages().remove(userCouponUsage);
		userCouponUsage.setCoupon(null);

		return userCouponUsage;
	}

}