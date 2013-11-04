<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<div class="form-container">
	<form:form class="form-horizontal ui-widget-content" method="POST" commandName="employee" action="${pageContext.servletContext.contextPath}/employee/edit">
		<fieldset>
			<legend>Edit Employee</legend>
			<t:input path="firstname" label="First Name: " size="30" placeholder="First Name"/>
			<t:input path="middlename" label="Middle Name: " size="30" placeholder="Middle Name"/>
			<t:input path="lastname" label="Last Name: " size="30" placeholder="Last Name"/>
			<t:input path="address" label="Home Address: " size="30" placeholder="Home Address"/>
			<t:input path="email" label="Email Address: " size="30" placeholder="Email Address"/>
			<t:input path="phoneNumber" label="Telephone Number: " size="30" placeholder="Telephone Number"/>
			<t:input path="grossSalary" label="Gross Salary: " size="30" placeholder="Gross Salary"/>
			<center><input type="submit" value="UPDATE EMPLOYEE" /></center>
			<form:hidden path="id"/>
			<form:hidden path="department.id"/>
			<br/>
		</fieldset>
	</form:form>
	<br/>
</div>	
	
<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});


</script>