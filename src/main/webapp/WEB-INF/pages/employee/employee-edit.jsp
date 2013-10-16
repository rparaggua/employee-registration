<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Edit Employee</h3>
<div class="form-container">
<form:form method="POST" commandName="employee" action="${pageContext.servletContext.contextPath}/employee/edit">
	<table class="form-content">
		<tr class="spaceabove">
			<td class="field-label" width="32%">First Name :</td>
			<td width="68%"><form:input size="30" path="firstname" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="firstname" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" width="32%">Middle Name :</td>
			<td width="68%"><form:input size="30" path="middlename" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="middlename" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" width="32%">Last Name :</td>
			<td width="68%"><form:input size="30" path="lastname" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="lastname" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" width="32%">Home Address :</td>
			<td width="68%"><form:input size="30" path="address" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="address" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" width="32%">Email :</td>
			<td width="68%"><form:input size="30" path="email" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" width="32%">Phone Number :</td>
			<td width="68%"><form:input size="30" path="phoneNumber" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="phoneNumber" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" width="32%">Gross Salary :</td>
			<td width="68%"><form:input size="30" path="grossSalary" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="grossSalary" cssClass="error" /></td>
		</tr>
		
		<tr class="spaceabove">
			<td/>
			<td><input type="submit" value="UPDATE EMPLOYEE" /></td>
		</tr>
	</table>
	<form:hidden path="id"/>
	<form:hidden path="department.id"/>
	<form:hidden path="department.name"/>
	<form:hidden path="department.DEPB"/>
</form:form>	
</div>	
	
<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});


</script>