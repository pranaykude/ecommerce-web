package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order_items database table.
 * 
 */
@Entity
@Table(name="order_items")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_item_id")
	private int orderItemId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="is_deleted")
	private int isDeleted;

	@Column(name="order_id")
	private int orderId;

	private BigDecimal price;

	private int quantity;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="variant_id")
	private int variantId;

	//bi-directional many-to-one association to ReturnRequest
	@OneToMany(mappedBy="orderItem")
	private List<ReturnRequest> returnRequests;

	public OrderItem() {
	}

	public int getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getVariantId() {
		return this.variantId;
	}

	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	public List<ReturnRequest> getReturnRequests() {
		return this.returnRequests;
	}

	public void setReturnRequests(List<ReturnRequest> returnRequests) {
		this.returnRequests = returnRequests;
	}

	public ReturnRequest addReturnRequest(ReturnRequest returnRequest) {
		getReturnRequests().add(returnRequest);
		returnRequest.setOrderItem(this);

		return returnRequest;
	}

	public ReturnRequest removeReturnRequest(ReturnRequest returnRequest) {
		getReturnRequests().remove(returnRequest);
		returnRequest.setOrderItem(null);

		return returnRequest;
	}

}