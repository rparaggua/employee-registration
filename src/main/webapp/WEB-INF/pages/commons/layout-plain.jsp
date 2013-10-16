<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	</head>


<body>
	<tiles:insertAttribute name="body" />		
</body>
</html>