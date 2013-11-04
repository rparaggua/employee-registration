<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasAnyRole('VIEW_BRANCH','BRANCH_HEAD')">
	<div class="form-container">
		<div class="form-horizontal ui-widget-content center">
			<h1><c:out value="${branch.name}"/></h1>
			<c:out value="${branch.email}"/><br/>
			<c:out value="${branch.address}"/><br/>
			<c:out value="${branch.phoneNumber}"/><br/><br/><br/><br/>
			
			<sec:authorize access="hasRole('VIEW_DEPARTMENT_LISTINGS')">
				<table id='departmentTable' >
		 		<thead>
		  			<tr>
		   				<th></th>
		   				<th>Id</th>
		   				<th>Department Name</th>
		   				<th>Bonus</th>
		 	 		</tr>
		 		</thead>
		 		<tbody>
					<c:forEach var="department" items="${departmentList}">
						<tr>
							<td>
								<input type="radio" name="departmentRadio" value="${department.id}" />
							</td>
							<td>
								<c:out value="${department.id}"/>
							</td>
							<td>
								<a 
									<sec:authorize access="hasRole('VIEW_DEPARTMENT')">
										href="${pageContext.servletContext.contextPath}/department/view/${department.id}"
									</sec:authorize>>
									<c:out value="${department.name}"/>
								</a>
							</td>
							<td>
								<c:choose>
							    <c:when test="${empty department.DEPB}">
							        <c:out value="0"/>
							    </c:when>
							    <c:otherwise>
							        <c:out value="${department.DEPB}"/>
							    </c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
		 		</tbody>
			</table>
		</sec:authorize>
		
		<div class="control left">
			<sec:authorize access="hasRole('ADD_DEPARTMENT')">
				<span><a href="#" id="addLink">Add</a></span>
			</sec:authorize>
			
			<sec:authorize access="hasRole('EDIT_DEPARTMENT')">
				<span><a href="#" id="editLink">Edit</a></span>
			</sec:authorize>
			
			<sec:authorize access="hasRole('DELETE_DEPARTMENT')">
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
	$('#departmentTable').dataTable({
	    "bJQueryUI": true,
	    "sPaginationType": "full_numbers"
	});

	$("#addLink").click(function() { 
		var tId = '<c:out value="${branch.id}"/>';
		window.location = "${pageContext.servletContext.contextPath}/department/add/"+tId;
	});

	// Assign a function to editLink
	$("#editLink").click(function() { 
		var tId = $('input:radio[name=departmentRadio]:checked').val();
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
			window.location = "${pageContext.servletContext.contextPath}/department/edit/"+tId;
		}});

	// Assign a function to deleteLink
	$("#deleteLink").click(function() { 
		// show dialog box
		var tId = $('input:radio[name=departmentRadio]:checked').val();
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
			window.location = "${pageContext.servletContext.contextPath}/department/delete/"+tId;
	}});
</script>