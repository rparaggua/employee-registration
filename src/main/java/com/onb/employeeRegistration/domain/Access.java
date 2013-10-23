package com.onb.employeeRegistration.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Access")
public class Access implements Serializable{

	private static final long serialVersionUID = -2560334618456962026L;
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "AccessSequence", sequenceName = "Access_Sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "AccessSequence")
	private Long id;
	
	@Size(min = 1,
			max = 100,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = "{com.onb.employeeregistration.pattern.access_pattern}",
			message = "{com.onb.employeeregistration.validator.message.invalidAccessPattern}")
	@Column(name = "name", nullable = false, unique = true, length = 100)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String name;
	
	@ManyToMany(mappedBy = "access")
	private List<Role> roles;
	
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(name);
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
		if (!(obj instanceof Access)) {
			return false;
		}
		Access other = (Access) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		equalsBuilder.append(name, other.name);
		return equalsBuilder.isEquals();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
		toStringBuilder.append("name", name);
		return toStringBuilder.toString();
	}

}
