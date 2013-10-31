package com.onb.employeeRegistration.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.onb.employeeRegistration.util.PatternUtility;

@Entity
@Table(name = "ERSAccount")
public class ERSAccount implements Serializable {

	private static final long serialVersionUID = 2426805095722801265L;
	    
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ERSAccountSequence", sequenceName = "ERSAccount_Sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ERSAccountSequence")
	private Long id;
	
	@Size(max = 30,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.USERNAME_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidUsername}")
	@Column(name = "username", length = 30, unique = true)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String username;
	
	@Size(min = 7,
			max = 15,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.PASSWORD_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidPassword}")
	@Column(name = "password", length = 255)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String password;
	
	@Column(name = "dateCreated")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	@Column(name = "activated")
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private Boolean activated;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToMany
	@JoinTable(name = "USER_ROLE",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(username);
		hashCodeBuilder.append(password);
		hashCodeBuilder.append(dateCreated);
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
		if (!(obj instanceof ERSAccount)) {
			return false;
		}
		ERSAccount other = (ERSAccount) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		equalsBuilder.append(username, other.username);
		equalsBuilder.append(password, other.password);
		equalsBuilder.append(dateCreated, other.dateCreated);
		return equalsBuilder.isEquals();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
		toStringBuilder.append("username", username);
		toStringBuilder.append("password", password);
		toStringBuilder.append("dateCreated", dateCreated);
		return toStringBuilder.toString();
	}
}
