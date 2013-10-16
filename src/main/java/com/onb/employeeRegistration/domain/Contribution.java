package com.onb.employeeRegistration.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.onb.employeeRegistration.util.PatternUtility;

@Entity
@Table(name = "Contribution")
public class Contribution implements Serializable{

	private static final long serialVersionUID = -2529201913533818463L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "ContributionSequence", sequenceName = "Contribution_Sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ContributionSequence")
	private Long id;
	
	@Size(max = 30,
			message = "{com.onb.employeeregistration.validator.message.invalidSize}")
	@Pattern(regexp = PatternUtility.NAME_PATTERN,
			message = "{com.onb.employeeregistration.validator.message.invalidName}")
	@Column(name = "name", length = 30, unique = true )
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private String name;
	
	@Digits(integer = 1,
			fraction = 2,
			message = "{com.onb.employeeregistration.validator.message.invalidPercentage}")
	@NumberFormat(style=Style.NUMBER)
	@Column(name = "percentage", nullable = false)
	@NotBlank(message = "{com.onb.employeeregistration.validator.message.required}")
	private BigDecimal percentage;

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

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(name);
		hashCodeBuilder.append(percentage);
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
		if (!(obj instanceof Contribution)) {
			return false;
		}
		Contribution other = (Contribution) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		equalsBuilder.append(name, other.name);
		equalsBuilder.append(percentage, other.percentage);
		return equalsBuilder.isEquals();
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
		toStringBuilder.append("name", name);
		toStringBuilder.append("percentage", percentage);
		return toStringBuilder.toString();
	}
}
