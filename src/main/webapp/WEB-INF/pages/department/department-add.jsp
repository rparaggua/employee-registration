<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<div class="form-container">
	<form:form class="form-horizontal ui-widget-content" method="POST" commandName="department" action="${pageContext.servletContext.contextPath}/department/add">
		<fieldset>
			<legend>Add Department</legend>
			<t:input path="name" label="Department Name: " size="30" placeholder="Department Name"/>
			<t:input path="DEPB" label="Department Bonus: " size="5" placeholder="Department Bonus"/>
			<center><input type="submit" value="ADD DEPARTMENT" /></center>
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