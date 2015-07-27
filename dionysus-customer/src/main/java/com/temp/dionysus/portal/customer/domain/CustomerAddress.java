package com.temp.dionysus.portal.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddress {
	@Id
	@Column(name = "addressId")
	@GeneratedValue
	private int addressId;

	@Column(name = "customerId")
	private int customerId;

	@Column(name = "line1")
	private String line1;

	@Column(name = "line2")
	private String line2;

	@Column(name = "postalCode")
	private String postalCode;

	@Column(name = "province")
	private String province;

	@Column(name = "country")
	private String country;

	@Column(name = "buzzCode")
	private String buzzCode;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBuzzCode() {
		return buzzCode;
	}

	public void setBuzzCode(String buzzCode) {
		this.buzzCode = buzzCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
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
		CustomerAddress other = (CustomerAddress) obj;
		if (addressId != other.addressId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId
				+ ", customerId="
				+ customerId
				+ ", line1="
				+ line1
				+ ", line2="
				+ line2
				+ ", postalCode="
				+ postalCode
				+ ", province="
				+ province
				+ ", country="
				+ country
				+ ", buzzCode="
				+ buzzCode
				+ "]";
	}

}
