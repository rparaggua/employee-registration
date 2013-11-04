<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasAnyRole('VIEW_DEPARTMENT', 'DEPARTMENT_HEAD')">
	<div class="form-container">
		<div class="form-horizontal ui-widget-content center">
			<h1><c:out value="${department.name}"/></h1>
			Department Bonus: <c:out value="${department.DEPB}"/><br/><br/><br/><br/>
			
			<sec:authorize access="hasRole('VIEW_EMPLOYEE_LISTINGS')">
				<table id='employeeTable'>
		 		<thead>
		  			<tr>
		   				<th></th>
		   				<th>Id</th>
		   				<th>Name</th>
		   				<th>Gross Salary</th>
		   				<th>Net Salary</th>
		 	 		</tr>
		 		</thead>
		 		<tbody>
					<c:forEach var="employee" items="${employeeList}">
						<tr>
							<td>
								<input type="radio" name="employeeRadio" value="${employee.id}" />
							</td>
							<td>
								<c:out value="${employee.id}"/>
							</td>
							<td>
								<a 
									<sec:authorize access="hasRole('VIEW_EMPLOYEE')">
										href="${pageContext.servletContext.contextPath}/employee/view/${employee.id}"
									</sec:authorize>>
								<c:out value="${employee.firstname} ${employee.middlename} ${employee.lastname}"/>
								</a>
							</td>
							<td>
								<c:choose>
							    <c:when test="${empty employee.grossSalary}">
							        <c:out value="0.00"/>
							    </c:when>
							    <c:otherwise>
							    	<fmt:formatNumber pattern="#,##0.00" value="${employee.grossSalary}"/>
							    </c:otherwise>
							</c:choose>
							</td>
							<td>
								<c:choose>
							    <c:when test="${empty employee.netSalary}">
							        <c:out value="0.00"/>
							    </c:when>
							    <c:otherwise>
							        <fmt:formatNumber pattern="#,##0.00" value="${employee.netSalary}"/>
							    </c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
		 		</tbody>
			</table>
		</sec:authorize>
		
		<div class="control left">
			<sec:authorize access="hasRole('ADD_EMPLOYEE')">
				<span><a href="#" id="addLink">Add</a></span>
			</sec:authorize>
			
			<sec:authorize access="hasRole('EDIT_EMPLOYEE')">
				<span><a href="#" id="editLink">Edit</a></span>
			</sec:authorize>
			
			<sec:authorize access="hasRole('DELETE_EMPLOYEE')">
				<span><a href="#" id="deleteLink">Delete</a></span>
			</sec:authorize>
		</div>
		</div>
		<br/>
	</div>	
</sec:authorize>
<jsp:include page="/WEB-INF/pages/commons/genericDialog.jsp"/>

<script type="text/javascript"> 

	// Convert links to buttons
	$('#addLink, #editLink, #deleteLink').button();
	
	// Convert to table DataTables
	$('#employeeTable').dataTable({
	    "bJQueryUI": true,
	    "sPaginationType": "full_numbers"
	});

	$("#addLink").click(function() { 
		var tId = '<c:out value="${department.id}"/>';
		window.location = "${pageContext.servletContext.contextPath}/employee/add/"+tId;
	});

	// Assign a function to editLink
	$("#editLink").click(function() { 
		var tId = $('input:radio[name=employeeRadio]:checked').val();
		if (tId == null) {
			$("#genericDialog").text("No Record Selected!");
			$("#genericDialog").dialog( 
					{	title: 'Error',
						modal: true,
						buttons: {"Ok": function()  {
							$(this).dialog("close");} 
						}
					});
		} else {
			window.location = "${pageContext.servletContext.contextPath}/employee/edit/"+tId;
		}});

	// Assign a function to deleteLink
	$("#deleteLink").click(function() { 
		// show dialog box
		var tId = $('input:radio[name=employeeRadio]:checked').val();
		if (tId == null) {
			$("#genericDialog").text("No Record Selected!");
			$("#genericDialog").dialog( 
					{	title: 'Error',
						modal: true,
						buttons: {"Ok": function()  {
							$(this).dialog("close");} 
						}
					});
		} else {
			window.location = "${pageContext.servletContext.contextPath}/employee/delete/"+tId;
	}});
</script>