<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><%@include file="css/style.jsp"%>

<title>Placement Management Application</title>
</head>
<body>
	<center>
		<h1>Placement Management</h1>
		<h2>
			 <a href="placement?action=placementlist"><button type="button"
			class="btn btn-primary">Display
				All Company</button></a>

		</h2>
	</center><a href="AdminDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
	<div align="center">
		<c:if test="${placement != null}">
			<form action="placement?action=placementupdate" method="post">
		</c:if>
		<c:if test="${placement == null}">
			<form action="placement?action=placementinsert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			
				<h2>
					<c:if test="${placement != null}">
            			Edit Company
            		</c:if>
					<c:if test="${placement == null}">
            			Add New Company
            		</c:if>
				</h2>
			
			<c:if test="${placement != null}">
				<input type="hidden" name="id" value="<c:out value='${placement.id}' />" />
			</c:if>
			<tr>
				<th>Company Name:</th>
				<td><input type="text"  class="form-control" required name="name" size="45"
					value="<c:out value='${placement.name}' />" /></td>
			</tr>
			<tr>
				<th>Qualification:</th>
				<td><input type="text" class="form-control" required name="qualification" size="45"
					value="<c:out value='${placement.qualification}' />" /></td>
			</tr>
			<tr>
				<th>Designation:</th>
				<td><input type="text" class="form-control" required name="designation" size="45"
					value="<c:out value='${placement.designation}' />" /></td>
			</tr>
			<tr>
				<th>Academic Criteria:</th>
				<td><input type="text" class="form-control" required name="academicCriteria" size="45"
					value="<c:out value='${placement.academicCriteria}' />" /></td>
			</tr>
			<tr>
				<th>Location:</th>
				<td><input type="text" class="form-control" required name="location" size="45"
					value="<c:out value='${placement.location}' />" /></td>
			</tr>
			<tr>
				<th>CTC Offered:</th>
				<td><input type="text" class="form-control" required name="ctcOffered" size="45"
					value="<c:out value='${placement.ctcOffered}' />" /></td>
			</tr>
			<tr>
				<th>Registration Link:</th>
				<td><input type="text" class="form-control" required name="registrationLink" size="45"
					value="<c:out value='${placement.registrationLink}' />" /></td>
			</tr>
			<tr>
				<th>Last Date:</th>
				<td><input type="text" class="form-control" required name="lastDate" size="45"
					value="<c:out value='${placement.lastDate}' />" /></td>
			</tr>
			<tr>
				<th>Selection Process:</th>
				<td><input type="text" class="form-control" required name="selectionProcess" size="45"
					value="<c:out value='${placement.selectionProcess}' />" /></td>
			</tr>
			<tr>
				<th>Company Website:</th>
				<td><input type="text" class="form-control" required name="companyWebsite" size="45"
					value="<c:out value='${placement.companyWebsite}' />" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
