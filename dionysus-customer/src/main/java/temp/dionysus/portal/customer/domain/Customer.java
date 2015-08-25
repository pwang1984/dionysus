package temp.dionysus.portal.customer.domain;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Set;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import temp.dionysus.portal.customer.dao.CustomerPasswordConverter;

@Entity
@Table(name = "CUSTOMER", indexes = {
		@Index(name = "index_customer_email", columnList = "email")
})
@Named
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "customerId", nullable = false)
	private int customerId;

	@Column(name = "nickName")
	private String nickName;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "middleName")
	private String middleName;

	@Column(name = "password", nullable = false)
	@Convert(converter = CustomerPasswordConverter.class)
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "verified", nullable = false, columnDefinition = "bit NOT NULL DEFAULT 0")
	private boolean verified;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_PHONE")
	private Set<Phone> phones;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_ADDRESS")
	private Set<Address> addresses;

	@Column(name = "registerTime")
	private Timestamp registerTime;

	@Column(name = "lastLoginTime")
	private Timestamp lastLoginTime;

	@PrePersist
	private void onPersist() {
		registerTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

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

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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
		Customer other = (Customer) obj;
		if (customerId != other.customerId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId
				+ ", nickName="
				+ nickName
				+ ", firstName="
				+ firstName
				+ ", lastName="
				+ lastName
				+ ", middleName="
				+ middleName
				+ ", password="
				+ password
				+ ", email="
				+ email
				+ ", verified="
				+ verified
				+ ", phoneList="
				+ phones
				+ ", addressList="
				+ addresses
				+ ", registerTime="
				+ registerTime
				+ ", lastLoginTime="
				+ lastLoginTime
				+ "]";
	}

}
