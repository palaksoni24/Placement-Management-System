<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Placement Management</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <center>
       
        <h1>Placement Management</h1>
		<h2>
			<a href="placement?action=placementlist">
    <button type="button" class="btn" style="color: #333;">Display All Companies</button>
</a>


		</h2>
    </center>
    <div align="center">
        <c:if test="${!empty placementList}">
            <table border="1" cellpadding="5" cellspacing="0">
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
                <c:forEach var="placement" items="${placementList}">
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
        </c:if>
        <c:if test="${empty placementList}">
            <p>No companies available to display.</p>
        </c:if>
    </div>
</body>
</html>