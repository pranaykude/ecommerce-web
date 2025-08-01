package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the website_assets database table.
 * 
 */
@Entity
@Table(name="website_assets")
@NamedQuery(name="WebsiteAsset.findAll", query="SELECT w FROM WebsiteAsset w")
public class WebsiteAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="asset_id")
	private int assetId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="end_time")
	private Timestamp endTime;

	@Column(name="image_url")
	private String imageUrl;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="is_deleted")
	private int isDeleted;

	@Column(name="link_url")
	private String linkUrl;

	@Column(name="overlay_text")
	private String overlayText;

	@Column(name="start_time")
	private Timestamp startTime;

	private String type;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="video_url")
	private String videoUrl;

	public WebsiteAsset() {
	}

	public int getAssetId() {
		return this.assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getOverlayText() {
		return this.overlayText;
	}

	public void setOverlayText(String overlayText) {
		this.overlayText = overlayText;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

}