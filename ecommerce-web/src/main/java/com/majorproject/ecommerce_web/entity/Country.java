package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the countries database table.
 * 
 */
@Entity
@Table(name="countries")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_id")
	private int countryId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="is_deleted")
	private int isDeleted;

	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to State
	@OneToMany(mappedBy="country")
	private List<State> states;

	//bi-directional many-to-one association to UserAddress
	@OneToMany(mappedBy="country")
	private List<UserAddress> userAddresses;

	public Country() {
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
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

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setCountry(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setCountry(null);

		return state;
	}

	public List<UserAddress> getUserAddresses() {
		return this.userAddresses;
	}

	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public UserAddress addUserAddress(UserAddress userAddress) {
		getUserAddresses().add(userAddress);
		userAddress.setCountry(this);

		return userAddress;
	}

	public UserAddress removeUserAddress(UserAddress userAddress) {
		getUserAddresses().remove(userAddress);
		userAddress.setCountry(null);

		return userAddress;
	}

}