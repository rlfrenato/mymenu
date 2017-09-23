package com.mymenu.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.mymenu.common.BusinessObject;

@Entity
public class Company extends BusinessObject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	private String site;

	private String facebook;

	private String instagram;

	private String country;

	private String address;

	private String city;

	private String state;
	
	@NotNull
	private String legalRepresentativeName;
	
	@NotNull
	private  String legalRepresentativeEmail;
	
	@NotNull
	private  String legalRepresentativePhone;

	@NotNull
	private String legalName;

	@NotNull
	private String legalIdentification;

	@NotNull
	private CompanyType type;

	@NotNull
	private CompanyStatus status;
	
	@OneToMany
	private List<Employee> employees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalRepresentativeName() {
		return legalRepresentativeName;
	}

	public void setLegalRepresentativeName(String legalRepresentativeName) {
		this.legalRepresentativeName = legalRepresentativeName;
	}

	public String getLegalRepresentativeEmail() {
		return legalRepresentativeEmail;
	}

	public void setLegalRepresentativeEmail(String legalRepresentativeEmail) {
		this.legalRepresentativeEmail = legalRepresentativeEmail;
	}

	public String getLegalRepresentativePhone() {
		return legalRepresentativePhone;
	}

	public void setLegalRepresentativePhone(String legalRepresentativePhone) {
		this.legalRepresentativePhone = legalRepresentativePhone;
	}

	public String getLegalIdentification() {
		return legalIdentification;
	}

	public void setLegalIdentification(String legalIdentification) {
		this.legalIdentification = legalIdentification;
	}

	public CompanyType getType() {
		return type;
	}

	public void setType(CompanyType type) {
		this.type = type;
	}

	public CompanyStatus getStatus() {
		return status;
	}

	public void setStatus(CompanyStatus status) {
		this.status = status;
	}

	public List<Employee> getEmployees() {
		if (employees == null) {
			return new ArrayList<Employee>();
		}
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public enum CompanyType {
		RESTAURANT, FAST_FOOD;
	}

	public enum CompanyStatus {
		ACTIVE, INACTIVE, BLOCKED;
	}

}
