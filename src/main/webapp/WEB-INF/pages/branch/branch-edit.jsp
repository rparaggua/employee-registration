<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Edit Branch</h3>
<div class="form-container">
<form:form  method="POST" commandName="branch" action="${pageContext.servletContext.contextPath}/branch/edit">
	<table class="form-content">
		<tr class="spaceabove">
			<td class="field-label" width="32%">Branch Name :</td>
			<td width="68%"><form:input size="30" path="name" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" >Address :</td>
			<td><form:input size="30" path="address" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="address" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" >Email :</td>
			<td><form:input size="30" path="email" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td class="field-label" >Phone Number :</td>
			<td><form:input size="30" path="phoneNumber" /></td>
		</tr>
		<tr>
			<td/>
			<td><form:errors path="phoneNumber" cssClass="error" /></td>
		</tr>
		<tr class="spaceabove">
			<td />
			<td><input type="submit" value="UPDATE BRANCH" /></td>
		</tr>
			
	</table>
	<form:hidden path="id" />
</form:form>	
</div>	
	
<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});


</script>