<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<div class="form-container">
	<form:form class="form-horizontal ui-widget-content" method="POST" commandName="changePasswordForm" action="${pageContext.servletContext.contextPath}/ersaccount/changepassword">
		<fieldset>
			<legend>Change Password</legend>
			<t:password path="newPassword" label="New Password: " size="20" autocomplete="off" placeholder="New Password"/>
			<t:password path="confirmPassword" label="Confirm Password: " size="20" autocomplete="off" placeholder="Confirm Password"/><br/>
			<t:password path="oldPassword" label="Old Password: " size="20" autocomplete="off" placeholder="Old Password"/>
			<center><input type="submit" value="CHANGE PASSWORD" /></center>
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