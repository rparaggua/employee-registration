<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:url value="/" var="rootUrl"/>

<div class="ui-widget-content">
	<h3 class="title">Branch List</h3>
	
	<table id='branchTable'>
 		<thead>
  			<tr>
   				<th></th>
   				<th>Id</th>
   				<th>Name</th>
   				<th>Address</th>
   				<th>Email</th>
   				<th>Phone Number</th>
 	 		</tr>
 		</thead>
 		<tbody>
 			<c:if test="${fn:length(branchList) != 0}">
 				<c:forEach var="branch" items="${branchList}">
 					<tr>
 						<td>
 							<input type="radio" name="branchRadio" value="${branch.id}" />
 						</td>
 						<td>
 							<c:out value="${branch.id}"/>
 						</td>
 						<td>
 							<a href="department/${branch.id}">
 							<c:out value="${branch.name}"/>
 							</a>
 						</td>
 						<td>
 							<c:out value="${branch.address}"/>
 						</td>
 						<td>
 							<c:out value="${branch.email}"/>
 						</td>
 						<td>
 							<c:out value="${branch.phoneNumber}"/>
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
	$('#branchTable').dataTable({
	    "bJQueryUI": true,
	    "sPaginationType": "full_numbers"
	});
	
	$("#addLink").click(function() { 
		document.location.href = "branch/add";
	});
	
	// Assign a function to editLink
	$("#editLink").click(function() { 
		var tId = $('input:radio[name=branchRadio]:checked').val();
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
			document.location.href = "branch/edit/"+tId;
		}});

	// Assign a function to deleteLink
	$("#deleteLink").click(function() { 
		// show dialog box
		var tId = $('input:radio[name=branchRadio]:checked').val();
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
			document.location.href = "branch/delete/"+tId;
	}});
</script>
