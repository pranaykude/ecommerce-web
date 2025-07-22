package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="alternate_mobile_number")
	private String alternateMobileNumber;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	@Column(name="full_name")
	private String fullName;

	private String gender;

	@Column(name="hint_name")
	private String hintName;

	@Column(name="is_deleted")
	private int isDeleted;

	private String location;

	@Column(name="mobile_number")
	private String mobileNumber;

	private String password;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="user")
	private List<Address> addresses;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="user")
	private List<Cart> carts;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	//bi-directional many-to-one association to Otp
	@OneToMany(mappedBy="user")
	private List<Otp> otps;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="user_roles"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;

	//bi-directional many-to-one association to Wishlist
	@OneToMany(mappedBy="user")
	private List<Wishlist> wishlists;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAlternateMobileNumber() {
		return this.alternateMobileNumber;
	}

	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHintName() {
		return this.hintName;
	}

	public void setHintName(String hintName) {
		this.hintName = hintName;
	}

	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUser(null);

		return address;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setUser(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setUser(null);

		return cart;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

	public List<Otp> getOtps() {
		return this.otps;
	}

	public void setOtps(List<Otp> otps) {
		this.otps = otps;
	}

	public Otp addOtp(Otp otp) {
		getOtps().add(otp);
		otp.setUser(this);

		return otp;
	}

	public Otp removeOtp(Otp otp) {
		getOtps().remove(otp);
		otp.setUser(null);

		return otp;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Wishlist> getWishlists() {
		return this.wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public Wishlist addWishlist(Wishlist wishlist) {
		getWishlists().add(wishlist);
		wishlist.setUser(this);

		return wishlist;
	}

	public Wishlist removeWishlist(Wishlist wishlist) {
		getWishlists().remove(wishlist);
		wishlist.setUser(null);

		return wishlist;
	}

}