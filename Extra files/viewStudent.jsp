<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Student Details</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <center>
        <h1>View Student Details</h1>
        <h2>
            <a href="student?action=studentlist">
                <button type="button" class="btn" style="color: #333;">Back to Student List</button>
            </a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${not empty student}">
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <th scope="col">ID</th>
                    <td><c:out value="${student.id}" /></td>
                </tr>
                <tr>
                    <th scope="col">College</th>
                    <td><c:out value="${student.college}" /></td>
                </tr>
                <tr>
                    <th scope="col">Course</th>
                    <td><c:out value="${student.course}" /></td>
                </tr>
                <tr>
                    <th scope="col">Name</th>
                    <td><c:out value="${student.name}" /></td>
                </tr>
                <tr>
                    <th scope="col">Roll</th>
                    <td><c:out value="${student.roll}" /></td>
                </tr>
                <tr>
                    <th scope="col">Year</th>
                    <td><c:out value="${student.year}" /></td>
                </tr>
                <tr>
                    <th scope="col">Branch</th>
                    <td><c:out value="${student.branch}" /></td>
                </tr>
            </table>
        </c:if>
        <c:if test="${empty student}">
            <p>Student not found.</p>
        </c:if>
    </div>
</body>
</html>
