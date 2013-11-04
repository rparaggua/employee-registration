<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="nav ers-sidenav ers-sidebar list-group">
	<sec:authorize access="hasRole('ADMINISTRATOR')">
    	<a class="list-group-item" href="${pageContext.servletContext.contextPath}${sessionScope.targetUrl}">Branch List</a>
    	<a class="list-group-item" href="${pageContext.servletContext.contextPath}/ersaccount/activateaccount">Activate Account</a>
    	<a class="list-group-item" href="${pageContext.servletContext.contextPath}/ersaccount/deactivateaccount">Deactivate Account</a>
    </sec:authorize>
    
    <sec:authorize access="hasRole('BRANCH_HEAD')">
    	<a class="list-group-item" href="${pageContext.servletContext.contextPath}${sessionScope.targetUrl}">Branch View</a>
    </sec:authorize>
    
    <sec:authorize access="hasRole('DEPARTMENT_HEAD')">
    	<a class="list-group-item" href="${pageContext.servletContext.contextPath}${sessionScope.targetUrl}">Department View</a>
    </sec:authorize>
    <a class="list-group-item" href="${pageContext.servletContext.contextPath}/ersaccount/changepassword">Change Password</a>
    <a class="list-group-item" href="${pageContext.servletContext.contextPath}/logout">Logout</a>
</div>

</script>