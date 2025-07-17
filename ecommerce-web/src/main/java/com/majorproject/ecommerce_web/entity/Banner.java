package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the banners database table.
 * 
 */
@Entity
@Table(name="banners")
@NamedQuery(name="Banner.findAll", query="SELECT b FROM Banner b")
public class Banner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="banner_id")
	private int bannerId;

	@Lob
	@Column(name="image_url")
	private String imageUrl;

	@Column(name="is_deleted")
	private int isDeleted;

	@Lob
	@Column(name="link_url")
	private String linkUrl;

	private String position;

	private String title;

	public Banner() {
	}

	public int getBannerId() {
		return this.bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}