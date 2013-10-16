<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Edit Department</h3>
<div class="form-container">
<form:form method="POST" commandName="department" action="${pageContext.servletContext.contextPath}/department/edit">
	<table class="form-content">
		<tr class="spaceabove">
			<td class="field-label" width="32%">Department Name :</td>
			<td width="68%"><form:input size="30" path="name" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" >Department Bonus :</td>
			<td><form:input size="5" path="DEPB"/></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="DEPB" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td/>
			<td><input type="submit" value="UPDATE DEPARTMENT" /></td>
		</tr>
	</table>
	<form:hidden path="id"/>
	<form:hidden path="branch.id"/>
	<form:hidden path="branch.name"/>
	<form:hidden path="branch.address"/>
	<form:hidden path="branch.email"/>
	<form:hidden path="branch.phoneNumber"/>
</form:form>	
</div>	
	
<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});


</script>