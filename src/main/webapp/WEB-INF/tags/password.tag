<%@tag description="Custom tag to allow for bootstrap errors" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="placeholder" required="false" type="java.lang.String"%>
<%@attribute name="size" required="false" type="java.lang.Integer"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>
<%@attribute name="autocomplete" required="false" type="java.lang.String"%>


<c:if test="${empty label}">
    <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>
<spring:bind path="${path}">
    <div class="control-group">
    	<label class="control-label" for="${path}">${label}<c:if test="${required}"><span class="required">*</span></c:if></label>
        <div class="controls">
        	<form:password path="${path}" cssClass="${empty cssClass ? 'input-xlarge' : cssClass}" placeholder="${empty placeholder ? '' : placeholder}" size="${empty size ? '15' : size}" autocomplete="${empty autocomplete ? 'on' : autocomplete}"/>
			<c:if test="${status.error}">
                <span class="error">${status.errorMessage}</span>
            </c:if>
        </div>
    </div>
</spring:bind>