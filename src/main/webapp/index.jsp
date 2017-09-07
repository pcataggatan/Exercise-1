<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home Page" scope="session" />
<%@include file="head.jsp"%>

<html>
<body>
<h2>User Display Exercise - Week 1</h2>

<%-- <a href = "searchUser">Go to the User Search</a> --%>

<div>
    <form action="/searchUser" method="GET">
        Search: <input type="text" name="searchTerm" autofocus><br/><br/>
        <input type="radio" name="searchType" value="allUsers" checked> All Users<br/>
        <input type="radio" name="searchType" value="byLastName"> By Last Name<br/>
        <br/>
        <input type="submit" name="" value="Submit">
    </form>

</div>

</body>
</html>