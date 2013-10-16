<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
		<!-- CSS Imports -->
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/helper.css"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/jquery/dark-hive/jquery-ui-1.8.6.custom.css"/>
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/datatables/custom.css"/>
		
		<!-- JS Imports -->
	 	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.8.3.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui-1.8.12.custom.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.servletContext.contextPath}/resources/js/util.js"></script>		
		<script src="${pageContext.servletContext.contextPath}/resources/js/date.js"></script>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
      		<div class="container">
        		<h1>ERS</h1>
        		<p>Employee Registration System</p>
     		</div>
    	</div>
    	
    	<div class="container">
	    	<div class="row">
	    		<div class="col-md-3">
			    	<div class="nav ers-sidebar hidden-print affix-top">
			    		<tiles:insertAttribute name="left-menu" />
			    	</div>
			    </div>
			    
			    <div class="col-md-9">
			    	<div class="ers-docs-section">
			    		<div class="ers-docs-body">
							<tiles:insertAttribute name="body" />
						</div>
					</div>
				</div>
		    </div>
		</div>
	</body>
</html>
