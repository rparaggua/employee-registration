<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url value="/" var="rootUrl"/>

<div class="ui-widget-content">
	<h3 class="title">Employee List</h3>
	
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
<%--  			<c:if test="${fn:length(employeeList) != 0}"> --%>
 				<c:forEach var="employee" items="${employeeList}">
 					<tr>
 						<td>
 							<input type="radio" name="employeeRadio" value="${employee.id}" />
 						</td>
 						<td>
 							<c:out value="${employee.id}"/>
 						</td>
 						<td>
 							<a href="${pageContext.servletContext.contextPath}/employee/edit/${employee.id}">
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
<%--  			</c:if> --%>
 		</tbody>
	</table>
	
	<div class="control">
		<span><a href="#" id="addLink">Add</a></span>
		<span><a href="#" id="editLink">Edit</a></span>
		<span><a href="#" id="deleteLink">Delete</a></span>
	</div>
</div>

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
		var id = '<c:out value="${departmentId}"/>';
		document.location.href = "add/"+id;
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
			document.location.href = "edit/"+tId;
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
			document.location.href = "delete/"+tId;
	}});
</script>
