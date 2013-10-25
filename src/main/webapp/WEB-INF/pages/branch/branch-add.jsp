<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<div class="form-container">

	<form:form class="form-horizontal" method="POST" commandName="branch" action="${pageContext.servletContext.contextPath}/branch/add">
		<fieldset>
			<!-- Form Name -->
			<legend>Add Branch</legend>
			<Table class="form-content">
				<t:input path="name" label="Branch Name: " size="30"/>
				<t:input path="address" label="Branch Address: " size="30"/>
				<t:input path="email" label="Email Address: " size="30"/>
				<t:input path="phoneNumber" label="Phone Number: " size="30"/>
			</Table>
		</fieldset>
	</form:form>

<%-- <form:form method="POST" commandName="branch" action="${pageContext.servletContext.contextPath}/branch/add"> --%>
<!-- 	<table class="form-content"> -->
<!-- 		<tr class="spaceabove"> -->
<!-- 			<td class="field-label" width="32%">Branch Name :</td> -->
<%-- 			<td width="68%"><form:input size="30" path="name" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td/> -->
<%-- 			<td><form:errors path="name" cssClass="error" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr class="spaceabove"> -->
<!-- 			<td class="field-label" >Address :</td> -->
<%-- 			<td><form:input size="30" path="address" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td/> -->
<%-- 			<td><form:errors path="address" cssClass="error" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr class="spaceabove"> -->
<!-- 			<td class="field-label" >Email :</td> -->
<%-- 			<td><form:input size="30" path="email" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td/> -->
<%-- 			<td><form:errors path="email" cssClass="error" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr class="spaceabove"> -->
<!-- 			<td class="field-label" >Phone Number :</td> -->
<%-- 			<td><form:input size="30" path="phoneNumber" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td/> -->
<%-- 			<td><form:errors path="phoneNumber" cssClass="error" /></td> --%>
<!-- 		</tr> -->
<!-- 		<tr class="spaceabove"> -->
<!-- 			<td/> -->
<!-- 			<td><input type="submit" value="ADD BRANCH" /></td> -->
<!-- 		</tr> -->
			
<!-- 	</table> -->
<%-- </form:form>	 --%>
</div>	
	
<script type="text/javascript">
$(function() {
	// Convert links to buttons
	$('input:submit').button();
	
});


</script>