<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Search Results" scope="session" />

<%@include file="head.jsp"%>

<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>

    <%-- ${users} --%>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Age<th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userid}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.dateOfBirth}</td>
                <td>${user.calculateUserAge()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
