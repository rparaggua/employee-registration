package com.onb.employeeRegistration.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Role")
public class Role implements Serializable{

	private static final long serialVersionUID = -9100067126001534137L;
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "RoleSequence", sequenceName = "Role_Sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RoleSequence")
	private Long id;
	
	@Size(min = 1,
			max = 100,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = "{com.onb.employeeregistration.pattern.role_pattern}",
			message = "{com.onb.employeeregistration.validator.message.invalidRolePattern}")
	@Column(name = "name", nullable = false, unique = true, length = 100)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String name;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "ROLE_ACCESS",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "access_id"))
	private List<Access> access;
	
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

	public List<Access> getAccess() {
		return access;
	}

	public void setAccess(List<Access> access) {
		this.access = access;
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
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
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
