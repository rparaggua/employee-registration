<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-container">
	<div class="ui-widget-content">
		<fieldset>
			<legend>
				<c:set var="middlename" value="${employee.middlename}"/>
				<c:out value="${employee.firstname} ${fn:substring(middlename, 0, 1)}. ${employee.lastname}"/><br/>
				<small>
					<c:out value="${employee.address}"/><br/>
					<c:out value="${employee.phoneNumber}"/><br/>
					<c:out value="${employee.email}"/><br/>
				</small>
			</legend>
			
			<table class="tg-table-plain" width="100%">
				<tr>
			    	<td class="tg-left tg-bf tg-it">GROSS SALARY:</td>
			    	<td><fmt:formatNumber pattern="#,##0.00" value="${employee.grossSalary}"/></td>
			    	<td/>
			  	</tr>
			  	
			  	<tr>
			    	<td class="tg-left tg-bf tg-it">DEDUCTIONS:</td>
			  	</tr>
			  
			  	<tr>
			    	<td class="tg-right tg-bf">Tax Contribution</td>
			    	<td><fmt:formatNumber pattern="#,##0.00" value="${employee.taxContribution}"/></td>
			  	</tr>
			  	
			  	<tr>
			    	<td class="tg-right tg-bf">Pag-ibig Contribution</td>
			    	<td><fmt:formatNumber pattern="#,##0.00" value="${employee.pagibigContribution}"/></td>
			  	</tr>
			  	
			  	<tr>
			    	<td class="tg-right tg-bf">SSS Contribution</td>
			    	<td><fmt:formatNumber pattern="#,##0.00" value="${employee.SSSContribution}"/></td>
			  	</tr>
			  	
			  	<tr>
			    	<td class="tg-left tg-bf tg-it">DEPARTMENTAL BONUS:</td>
			    	<td><fmt:formatNumber pattern="#,##0.00" value="${employee.departmentalBonus}"/></td>
			  	</tr>
			  	
			  	<tr>
			  		<td colspan="3"><hr></td>
			  	</tr>
			  	
			  	<tr>
			    	<td class="tg-left tg-bf tg-it">NET SALARY:</td>
			    	<td><fmt:formatNumber pattern="#,##0.00" value="${employee.netSalary}"/></td>
			  	</tr>
			</table>
			<br/>
		</fieldset>
	</div>	
</div>	