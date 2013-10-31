<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<div class="form-container">
	<form:form  class="form-horizontal ui-widget-content" method="POST" commandName="branch" action="${pageContext.servletContext.contextPath}/branch/edit">
		<fieldset>
			<legend>Edit Branch</legend>
			<t:input path="name" label="Branch Name: " size="30"/>
			<t:input path="address" label="Branch Address: " size="30"/>
			<t:input path="email" label="Email Address: " size="30"/>
			<t:input path="phoneNumber" label="Phone Number: " size="30"/>
			<center><input type="submit" value="UPDATE BRANCH" /></center>
			<form:hidden path="id" />
			<br/>
		</fieldset>
	</form:form>	
</div>	
	
<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});


</script>