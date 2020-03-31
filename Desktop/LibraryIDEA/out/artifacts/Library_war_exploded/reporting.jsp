<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reporting</title>
</head>
<body>
<h1>Reporting</h1>
<form action="/Library_war_exploded/numOfBookExamplesByBookName" method="get">
    Show how many examples of particular book are stored in the library:
    <br>
    <label for="bookName">Please enter book name:</label><br>
    <input type="text" id="bookName" name="bookName"><br>
    <br>
    <input type="submit" value="Submit">
</form>

<p><c:out value="${numOfBookExamplesByBookName}" default=""/></p>

<br>

<form action="/Library_war_exploded/bookExamplesByBookNameWhichAreAvailable" method="get">
    <label for="bookName">Please enter book name:</label><br>
    <input type="text" id="bookNameA" name="bookName"><br>
    <br>
    <input type="submit" value="Show how many examples of particular book are currently available:">
</form>

<p><c:forEach var="bookExampleByBookNameWhichAreAvailable" items="${bookExamplesByBookNameWhichAreAvailable}">
    <c:out value="${bookExampleByBookNameWhichAreAvailable}" default=""/>
</c:forEach></p>

<br>

<form action="/Library_war_exploded/bookExamplesByBookNameWhichWereTaken" method="get">
    <label for="bookName">Please enter book name:</label><br>
    <input type="text" id="bookNameT" name="bookName"><br>
    <br>
    <input type="submit" value="Show how many examples of particular book are currently taken by users">
</form>

<p><c:forEach var="bookExampleByBookNameWhichWereTaken" items="${bookExamplesByBookNameWhichWereTaken}">
    <c:out value="${bookExampleByBookNameWhichWereTaken}" default=""/>
</c:forEach></p>
</body>
</html>
