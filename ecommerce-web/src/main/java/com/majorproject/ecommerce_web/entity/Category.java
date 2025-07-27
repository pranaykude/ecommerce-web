package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="is_deleted")
	private int isDeleted;

	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Subcategory
	@OneToMany(mappedBy="category")
	private List<Subcategory> subcategories;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Subcategory> getSubcategories() {
		return this.subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public Subcategory addSubcategory(Subcategory subcategory) {
		getSubcategories().add(subcategory);
		subcategory.setCategory(this);

		return subcategory;
	}

	public Subcategory removeSubcategory(Subcategory subcategory) {
		getSubcategories().remove(subcategory);
		subcategory.setCategory(null);

		return subcategory;
	}

}