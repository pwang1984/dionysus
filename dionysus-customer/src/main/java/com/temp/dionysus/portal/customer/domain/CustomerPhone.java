package com.temp.dionysus.portal.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_PHONE")
public class CustomerPhone {
	@Id
	@GeneratedValue
	@Column(name = "phoneId")
	private int phoneId;

	@Column(name = "customerId")
	private int customerId;

	@Column(name = "countryCode")
	private int countryCode;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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
		CustomerPhone other = (CustomerPhone) obj;
		if (customerId != other.customerId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CustomerPhone [phoneId=" + phoneId + ", customerId=" + customerId + ", countryCode=" + countryCode + ", phoneNumber=" + phoneNumber + "]";
	}

}
