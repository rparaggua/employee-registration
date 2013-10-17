package com.onb.employeeRegistration.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;

import com.onb.employeeRegistration.util.PatternUtility;

@Entity
@Table(name = "Branch")
public class Branch implements Serializable{
	
	private static final long serialVersionUID = 6292045495171537652L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "BranchSequence", sequenceName = "Branch_Sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "BranchSequence")
	private long id;
	
	@Size(max = 30,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.BRANCH_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidName}")
	@Column(name = "name", length = 30, unique = true)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String name;
	
	@Size(max = 150,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.ADDRESS_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidAddress}")
	@Column(name = "address", nullable = true, length = 150)
	private String address;
	
	@Size(max = 50,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.EMAIL_ADDRESS_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidEmail}")
	@Column(name = "email", nullable = true, unique = true, length = 50)
	private String email;
	
	@Size(max = 25,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.PHONE_NUMBER_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidPhoneNumber}")
	@Column(name = "phoneNumber", nullable = true, unique = true, length = 25)
	private String phoneNumber;
	
	@OneToMany(mappedBy = "branch", orphanRemoval=true)
	@Cascade({CascadeType.ALL})
	private List<Department> departments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = WordUtils.capitalizeFully(name);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		
		if(this.address.length()==0){
			this.address = null;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
		
		if(this.email.length() == 0){
			this.email = null;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		
		if(this.phoneNumber.length() == 0){
			this.phoneNumber = null;
		}
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(name);
		hashCodeBuilder.append(address);
		hashCodeBuilder.append(email);
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Branch)) {
			return false;
		}
		Branch other = (Branch) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		equalsBuilder.append(name, other.name);
		equalsBuilder.append(address, other.address);
		equalsBuilder.append(email, other.email);
		return equalsBuilder.isEquals();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
		toStringBuilder.append("name", name);
		toStringBuilder.append("address", address);
		toStringBuilder.append("email", email);
		return toStringBuilder.toString();
	}

	
}
