package com.rubixtek.rubixbooks.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	private String address1;
	private String address2;
	private String city;
	private String district;
	private String state;
	@Column(unique = true)
	private String country;
	private String zipcode;
	private String email;
	private String phone;
	@Column(unique = true)
	private String taxIdentifier;
	
	
	
	public Supplier() {
		super();
	}

	public Supplier(Long id, String name, String address1, String address2, String city, String district, String state,
			String country, String zipcode, String email, String taxIdentifier, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.email = email;
		this.taxIdentifier = taxIdentifier;
		this.phone = phone;
	}

	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxIdentifier() {
		return taxIdentifier;
	}

	public void setTaxIdentifier(String taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, name, taxIdentifier);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return Objects.equals(country, other.country) && Objects.equals(name, other.name)
				&& Objects.equals(taxIdentifier, other.taxIdentifier);
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", district=" + district + ", state=" + state + ", country=" + country + ", zipcode=" + zipcode
				+ ", taxIndentifier=" + taxIdentifier + ", phone=" + phone + "]";
	}

}
