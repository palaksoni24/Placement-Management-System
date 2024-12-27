<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Management</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <center>
        <h1>Student Management</h1>
        <h2>
            <a href="student?action=studentnew">
                <button type="button" class="btn" style="color: #333;">Add New Student</button>
            </a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${!empty listStudent}">
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">College</th>
                    <th scope="col">Course</th>
                    <th scope="col">Name</th>
                    <th scope="col">Roll</th>
                    <th scope="col">Year</th>
                    <th scope="col">Branch</th>
                    <th scope="col">Operations</th>
                </tr>
                <c:forEach var="student" items="${listStudent}">
                    <tr>
                        <td><c:out value="${student.id}" /></td>
                        <td><c:out value="${student.college}" /></td>
                        <td><c:out value="${student.course}" /></td>
                        <td><c:out value="${student.name}" /></td>
                        <td><c:out value="${student.roll}" /></td>
                        <td><c:out value="${student.year}" /></td>
                        <td><c:out value="${student.branch}" /></td>
                        <td>
                            <a href="student?action=studentedit&id=${student.id}">Edit</a> | 
                            <a href="student?action=studentdelete&id=${student.id}" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty listStudent}">
            <p>No students available to display.</p>
        </c:if>
    </div>
</body>
</html>
