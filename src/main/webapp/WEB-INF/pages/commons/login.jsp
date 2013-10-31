<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="form-container ers-center">
	<form:form class="form-horizontal ui-widget-content" action="${pageContext.servletContext.contextPath}/j_spring_security_check" method="post">
		<legend>Login</legend>
		<div class="control-group">
		  	<label class="control-label" for="textinput">Username</label>
		  	<div class="controls">
		    	<input id="j_username" name="j_username" type="text" size="30" placeholder="username" autocomplete="off"/> 
		  	</div>
		</div>

		<div class="control-group">
  			<label class="control-label" for="passwordinput">Password</label>
  			<div class="controls">
    			<input id="j_password" name="j_password" type="password" size="30" placeholder="Password"/>
  			</div>
  			
			<p class="help-block error">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
		</div>

		<div class="control-group">
		  	<label class="control-label" for="singlebutton"></label>
		  	<div class="controls">
		    	<input type="submit" value="Login"/> 
		  	</div>
		</div>
	</form:form>
</div>

<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});
</script>