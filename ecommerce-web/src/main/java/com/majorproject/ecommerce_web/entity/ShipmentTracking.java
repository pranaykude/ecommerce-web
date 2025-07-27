package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the shipment_tracking database table.
 * 
 */
@Entity
@Table(name="shipment_tracking")
@NamedQuery(name="ShipmentTracking.findAll", query="SELECT s FROM ShipmentTracking s")
public class ShipmentTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tracking_id")
	private int trackingId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="is_deleted")
	private byte isDeleted;

	@Column(name="order_id")
	private int orderId;

	@Lob
	private String remarks;

	private String status;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private int updatedBy;

	public ShipmentTracking() {
	}

	public int getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

}