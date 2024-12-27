<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@include file="css/style.jsp"%>

	<title>Placement Management Application</title>
</head>
<body>
	<center>
		<h1>Placement Management</h1>
		
	</center><a href="UserDashboard.html"><button type="button"
			class="btn btn-primary">Dashboard</button></a>
    <div align="center" class="table">
        <table border="1" cellpadding="5" class="table-bodered">
        <h2>List of Placements</h2>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Qualification</th>
                <th scope="col">Designation</th>
                <th scope="col">Academic Criteria</th>
                <th scope="col">Location</th>
                <th scope="col">CTC Offered</th>
                <th scope="col">Registration Link</th>
                <th scope="col">Last Date</th>
                <th scope="col">Selection Process</th>
                <th scope="col">Company Website</th>
                <th scope="col">Operations</th>
                
            </tr>
            <c:forEach var="placement" items="${listPlacement}">
                <tr>
                    <td><c:out value="${placement.id}" /></td>
                    <td><c:out value="${placement.name}" /></td>
                    <td><c:out value="${placement.qualification}" /></td>
                    <td><c:out value="${placement.designation}" /></td>
                    <td><c:out value="${placement.academicCriteria}" /></td>
                    <td><c:out value="${placement.location}" /></td>
                    <td><c:out value="${placement.ctcOffered}" /></td>
                    <td><c:out value="${placement.registrationLink}" /></td>
                    <td><c:out value="${placement.lastDate}" /></td>
                    <td><c:out value="${placement.selectionProcess}" /></td>
                    <td><c:out value="${placement.companyWebsite}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <br>
     
</body>
</html>
