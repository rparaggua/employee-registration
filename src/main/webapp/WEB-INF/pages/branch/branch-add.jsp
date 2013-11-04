<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<div class="form-container">
	<form:form class="form-horizontal ui-widget-content" method="POST" commandName="branch" action="${pageContext.servletContext.contextPath}/branch/add">
		<fieldset>
			<legend>Add Branch</legend>
			<t:input path="name" label="Branch Name: " size="30" placeholder="Branch Name"/>
			<t:input path="address" label="Branch Address: " size="30" placeholder="Branch Address"/>
			<t:input path="email" label="Email Address: " size="30" placeholder="Email Address"/>
			<t:input path="phoneNumber" label="Phone Number: " size="30" placeholder="Phone Number"/>
			<center><input type="submit" value="ADD BRANCH" /></center>
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