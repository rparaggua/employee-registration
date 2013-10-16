package com.onb.employeeRegistration.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
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
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.onb.employeeRegistration.util.PatternUtility;

@Entity
@Table(name = "Department", uniqueConstraints={@UniqueConstraint(columnNames={"name", "branch_id"})})
public class Department implements Serializable{

	private static final long serialVersionUID = 457601649770184032L;
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "DepartmentSequence", sequenceName = "Department_Sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "DepartmentSequence")
	private long id;
	
	@Size(max = 30,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.DEPARTMENT_NAME_PATTER,
			message = "{com.onb.employeeregistration.validator.message.invalidName}")
	@Column(name = "name", length = 30)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String name;
	
	@Digits(integer = 1,
			fraction = 2,
			message = "{com.onb.employeeregistration.validator.message.invalidPercentage}")
	@NumberFormat(style=Style.NUMBER)
	private BigDecimal DEPB;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	@Cascade({CascadeType.ALL})
	private Branch branch;
	
	@OneToMany(mappedBy = "department", orphanRemoval = true)
	@Cascade({CascadeType.ALL})
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public BigDecimal getDEPB() {
		return DEPB;
	}

	public void setDEPB(BigDecimal dEPB) {
		DEPB = dEPB;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(name);
		hashCodeBuilder.append(branch);
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Department))
			return false;
		Department other = (Department) obj;
		EqualsBuilder equalsBuiler = new EqualsBuilder();
		equalsBuiler.append(name, other.name);
		equalsBuiler.append(branch, other.branch);
		return equalsBuiler.isEquals();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
		toStringBuilder.append("name", name);
		toStringBuilder.append("branch", branch);
		return toStringBuilder.toString();
	}

}
