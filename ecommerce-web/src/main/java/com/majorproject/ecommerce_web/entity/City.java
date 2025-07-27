package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cities database table.
 * 
 */
@Entity
@Table(name="cities")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="city_id")
	private int cityId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="is_deleted")
	private int isDeleted;

	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;

	//bi-directional many-to-one association to UserAddress
	@OneToMany(mappedBy="city")
	private List<UserAddress> userAddresses;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<UserAddress> getUserAddresses() {
		return this.userAddresses;
	}

	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public UserAddress addUserAddress(UserAddress userAddress) {
		getUserAddresses().add(userAddress);
		userAddress.setCity(this);

		return userAddress;
	}

	public UserAddress removeUserAddress(UserAddress userAddress) {
		getUserAddresses().remove(userAddress);
		userAddress.setCity(null);

		return userAddress;
	}

}