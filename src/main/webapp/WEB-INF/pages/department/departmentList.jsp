<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:url value="/" var="rootUrl"/>

<div class="ui-widget-content">
	<h3 class="title">Department List</h3>
	
	<table id='departmentTable'>
 		<thead>
  			<tr>
   				<th></th>
   				<th>Id</th>
   				<th>Name</th>
   				<th>Bonus</th>
 	 		</tr>
 		</thead>
 		<tbody>
 			<c:if test="${fn:length(departmentList) != 0}">
 				<c:forEach var="department" items="${departmentList}">
 					<tr>
 						<td>
 							<input type="radio" name="departmentRadio" value="${department.id}" />
 						</td>
 						<td>
 							<c:out value="${department.id}"/>
 						</td>
 						<td>
 							<a href="${pageContext.servletContext.contextPath}/employee/${department.id}">
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
 			</c:if>
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
	$('#departmentTable').dataTable({
	    "bJQueryUI": true,
	    "sPaginationType": "full_numbers"
	});
	
	$("#addLink").click(function() { 
		var id = '<c:out value="${branchId}"/>';
		document.location.href = "add/"+id;
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
			document.location.href = "edit/"+tId;
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
			document.location.href = "delete/"+tId;
	}});
</script>
