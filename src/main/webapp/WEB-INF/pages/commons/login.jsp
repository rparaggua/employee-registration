<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="ers-center-box">
	<form class="form-horizontal" action="${pageContext.servletContext.contextPath}/j_spring_security_check" method="post">
		<fieldset>

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
	  			
	  			<c:if test="${not empty error}">
	  				<p class="help-block error"><c:out value="${error}"/></p>
				</c:if>
			</div>
	
			<div class="control-group">
			  	<label class="control-label" for="singlebutton"></label>
			  	<div class="controls">
			    	<button type="submit" id="login-btn" name="login-btn" class="btn btn-primary">Login</button>
			  	</div>
			</div>

		</fieldset>
	</form>
</div>