package com.temp.dionysus.portal.customer.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.temp.dionysus.portal.customer.dao.CustomerPasswordConverter;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "customerId")
	private int customerId;

	@Column(name = "nickName")
	private String nickName;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "middleName")
	private String middleName;

	@Column(name = "password")
	@Convert(converter = CustomerPasswordConverter.class)
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "verified")
	private boolean verified;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Set<CustomerPhone> phoneList;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Set<CustomerAddress> addressList;

	@Column(name = "registerTime")
	private Timestamp registerTime;

	@Column(name = "lastLoginTime")
	private Timestamp lastLoginTime;

	//	@OneToOne
	//	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	//	private CustomerPhone defaultPhoneNum;
	//
	//	@OneToOne
	//	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	//	private CustomerAddress defaultAddress;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Set<CustomerPhone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(Set<CustomerPhone> phoneList) {
		this.phoneList = phoneList;
	}

	public Set<CustomerAddress> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<CustomerAddress> addressList) {
		this.addressList = addressList;
	}

	//
	//	public CustomerPhone getDefaultPhoneNum() {
	//		return defaultPhoneNum;
	//	}
	//
	//	public void setDefaultPhoneNum(CustomerPhone defaultPhoneNum) {
	//		this.defaultPhoneNum = defaultPhoneNum;
	//	}
	//
	//	public CustomerAddress getDefaultAddress() {
	//		return defaultAddress;
	//	}
	//
	//	public void setDefaultAddress(CustomerAddress defaultAddress) {
	//		this.defaultAddress = defaultAddress;
	//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		if (customerId != other.customerId) {
			return false;
		}
		return true;
	}

}
