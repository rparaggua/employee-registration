package com.onb.employeeRegistration.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.onb.employeeRegistration.util.PatternUtility;

@Entity
@Table(name = "Employee", uniqueConstraints={@UniqueConstraint(columnNames={"firstname", "middlename", "lastname"})})
public class Employee implements Serializable {

	private static final long serialVersionUID = 416430873498605447L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "EmployeeSequence", sequenceName = "Employee_Sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EmployeeSequence")
	private Long id;

	@Size(max = 30,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.NAME_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidName}")
	@Column(name = "firstname", length = 30)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String firstname;

	@Size(max = 30,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.NAME_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidName}")
	@Column(name = "middlename", length = 30)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String middlename;

	@Size(max = 30,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.NAME_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidName}")
	@Column(name = "lastname", length = 30)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String lastname;

	@Size(max = 150,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.ADDRESS_PATTERN,
			message="{com.onb.employeeregistration.validator.message.invalidAddress}")
	@Column(name = "address", nullable = true, length = 150)
	private String address;
	
	@Size(max = 50,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.EMAIL_ADDRESS_PATTERN,
			message="{com.onb.employeeregistration.validator.message.invalidEmail}")
	@Column(name = "email", nullable = true, unique = true, length = 50)
	private String email;
	
	@Size(max = 25,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.PHONE_NUMBER_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidPhoneNumber}")
	@Column(name = "phoneNumber", nullable = true, unique = false, length = 25)
	private String phoneNumber;
	
	@Digits(integer = 6,
			fraction = 2,
			message = "{com.onb.employeeregistration.validator.message.invalidPercentage}")
	@NumberFormat(style=Style.NUMBER)
	private BigDecimal GrossSalary;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@Transient
	private BigDecimal departmentalBonus;
	
	@Transient
	private BigDecimal taxContribution;
	
	@Transient
	private BigDecimal pagibigContribution;
	
	@Transient
	private BigDecimal SSSContribution;

	@Transient
	private BigDecimal NetSalary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = WordUtils.capitalizeFully(firstname);
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = WordUtils.capitalizeFully(middlename);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = WordUtils.capitalizeFully(lastname);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	}

	public BigDecimal getGrossSalary() {
		return GrossSalary;
	}

	public void setGrossSalary(BigDecimal grossSalary) {
		GrossSalary = grossSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public BigDecimal getDepartmentalBonus() {
		return departmentalBonus;
	}

	public void setDepartmentalBonus(BigDecimal departmentalBonus) {
		this.departmentalBonus = departmentalBonus;
	}

	public BigDecimal getTaxContribution() {
		return taxContribution;
	}

	public void setTaxContribution(BigDecimal taxContribution) {
		this.taxContribution = taxContribution;
	}

	public BigDecimal getPagibigContribution() {
		return pagibigContribution;
	}

	public void setPagibigContribution(BigDecimal pagibigContribution) {
		this.pagibigContribution = pagibigContribution;
	}

	public BigDecimal getSSSContribution() {
		return SSSContribution;
	}

	public void setSSSContribution(BigDecimal sSSContribution) {
		SSSContribution = sSSContribution;
	}

	public BigDecimal getNetSalary() {
		return NetSalary;
	}

	public void setNetSalary(BigDecimal netSalary) {
		NetSalary = netSalary;
	}
	
	
	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(firstname);
		hashCodeBuilder.append(middlename);
		hashCodeBuilder.append(lastname);
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
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		equalsBuilder.append(firstname, other.firstname);
		equalsBuilder.append(middlename, other.middlename);
		equalsBuilder.append(lastname, other.lastname);
		return equalsBuilder.isEquals();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
		toStringBuilder.append("firstname", firstname);
		toStringBuilder.append("middlename", middlename);
		toStringBuilder.append("lastname", lastname);
		return toStringBuilder.toString();
	}
}
