package com.majorproject.ecommerce_web.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	private String address;

	@Column(name="alternate_mobile_number")
	private String alternateMobileNumber;

	@Column(name="created_at")
	private Timestamp createdAt;

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

	@Column(name="mobile_number")
	private String mobileNumber;

	private String password;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to AdminLog
	@OneToMany(mappedBy="user")
	private List<AdminLog> adminLogs;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="user")
	private List<Cart> carts;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="user")
	private List<Notification> notifications;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	//bi-directional many-to-one association to ProductReview
	@OneToMany(mappedBy="user")
	private List<ProductReview> productReviews;

	//bi-directional many-to-one association to ProductView
	@OneToMany(mappedBy="user")
	private List<ProductView> productViews;

	//bi-directional many-to-one association to ReturnRequest
	@OneToMany(mappedBy="user")
	private List<ReturnRequest> returnRequests;

	//bi-directional many-to-one association to UserAddress
	@OneToMany(mappedBy="user")
	private List<UserAddress> userAddresses;

	//bi-directional many-to-one association to UserCouponUsage
	@OneToMany(mappedBy="user")
	private List<UserCouponUsage> userCouponUsages;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlternateMobileNumber() {
		return this.alternateMobileNumber;
	}

	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
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

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<AdminLog> getAdminLogs() {
		return this.adminLogs;
	}

	public void setAdminLogs(List<AdminLog> adminLogs) {
		this.adminLogs = adminLogs;
	}

	public AdminLog addAdminLog(AdminLog adminLog) {
		getAdminLogs().add(adminLog);
		adminLog.setUser(this);

		return adminLog;
	}

	public AdminLog removeAdminLog(AdminLog adminLog) {
		getAdminLogs().remove(adminLog);
		adminLog.setUser(null);

		return adminLog;
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

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setUser(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setUser(null);

		return notification;
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

	public List<ProductReview> getProductReviews() {
		return this.productReviews;
	}

	public void setProductReviews(List<ProductReview> productReviews) {
		this.productReviews = productReviews;
	}

	public ProductReview addProductReview(ProductReview productReview) {
		getProductReviews().add(productReview);
		productReview.setUser(this);

		return productReview;
	}

	public ProductReview removeProductReview(ProductReview productReview) {
		getProductReviews().remove(productReview);
		productReview.setUser(null);

		return productReview;
	}

	public List<ProductView> getProductViews() {
		return this.productViews;
	}

	public void setProductViews(List<ProductView> productViews) {
		this.productViews = productViews;
	}

	public ProductView addProductView(ProductView productView) {
		getProductViews().add(productView);
		productView.setUser(this);

		return productView;
	}

	public ProductView removeProductView(ProductView productView) {
		getProductViews().remove(productView);
		productView.setUser(null);

		return productView;
	}

	public List<ReturnRequest> getReturnRequests() {
		return this.returnRequests;
	}

	public void setReturnRequests(List<ReturnRequest> returnRequests) {
		this.returnRequests = returnRequests;
	}

	public ReturnRequest addReturnRequest(ReturnRequest returnRequest) {
		getReturnRequests().add(returnRequest);
		returnRequest.setUser(this);

		return returnRequest;
	}

	public ReturnRequest removeReturnRequest(ReturnRequest returnRequest) {
		getReturnRequests().remove(returnRequest);
		returnRequest.setUser(null);

		return returnRequest;
	}

	public List<UserAddress> getUserAddresses() {
		return this.userAddresses;
	}

	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public UserAddress addUserAddress(UserAddress userAddress) {
		getUserAddresses().add(userAddress);
		userAddress.setUser(this);

		return userAddress;
	}

	public UserAddress removeUserAddress(UserAddress userAddress) {
		getUserAddresses().remove(userAddress);
		userAddress.setUser(null);

		return userAddress;
	}

	public List<UserCouponUsage> getUserCouponUsages() {
		return this.userCouponUsages;
	}

	public void setUserCouponUsages(List<UserCouponUsage> userCouponUsages) {
		this.userCouponUsages = userCouponUsages;
	}

	public UserCouponUsage addUserCouponUsage(UserCouponUsage userCouponUsage) {
		getUserCouponUsages().add(userCouponUsage);
		userCouponUsage.setUser(this);

		return userCouponUsage;
	}

	public UserCouponUsage removeUserCouponUsage(UserCouponUsage userCouponUsage) {
		getUserCouponUsages().remove(userCouponUsage);
		userCouponUsage.setUser(null);

		return userCouponUsage;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
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