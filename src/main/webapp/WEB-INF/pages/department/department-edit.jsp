<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<div class="form-container">
	<form:form class="form-horizontal ui-widget-content" method="POST" commandName="department" action="${pageContext.servletContext.contextPath}/department/edit">
		<fieldset>
			<legend>Edit Department</legend>
			<t:input path="name" label="Department Name: " size="30"/>
			<t:input path="DEPB" label="Department Bonus: " size="5"/>
			<center><input type="submit" value="UPDATE DEPARTMENT" /></center>
			<form:hidden path="id"/>
			<form:hidden path="branch.id"/>
			<br/>
		</fieldset>
	</form:form>
	</br>
</div>	

<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});
</script>