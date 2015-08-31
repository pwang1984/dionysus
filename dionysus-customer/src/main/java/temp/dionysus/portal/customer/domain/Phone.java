package temp.dionysus.portal.customer.domain;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
@Named
public class Phone {
	@Id
	@GeneratedValue
	@Column(name = "phoneId", nullable = false)
	private int phoneId;

	@Column(name = "countryCode", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 1")
	private int countryCode;

	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
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
		result = prime * result + countryCode;
		result = prime * result + phoneId;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Phone other = (Phone) obj;
		if (countryCode != other.countryCode) {
			return false;
		}
		if (phoneId != other.phoneId) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", countryCode=" + countryCode + ", phoneNumber=" + phoneNumber + "]";
	}

}
