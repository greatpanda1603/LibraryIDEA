<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
<form action="/Library_war_exploded/averageUsersAge" method="get">
    Show average age of all users:
    <br>
    <br>
    <input type="submit" value="Submit">
</form>

<p><c:out value="${averageUsersAge}" default=""/></p>

<br>

<form action="/Library_war_exploded/averageAgeOfUsersByAuthor" method="get">
    <fieldset>
        <legend>Show users' average age by author:</legend>
        <label for="firstName">Please enter author's first name:</label><br>
        <input type="text" id="firstName" name="firstName"><br>
        <label for="lastName">Please enter author's last name:</label><br>
        <input type="text" id="lastName" name="lastName"><br>
        <br>
        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:out value="${averageAgeOfUsersByAuthor}" default=""/></p>

<br>

<form action="/Library_war_exploded/averageAgeOfUsersByBook" method="get">
    Show users' average age by book:
    <br>
    <label for="bookName">Please enter name of the book:</label><br>
    <input type="text" id="bookName" name="bookName"><br>
    <input type="submit" value="Submit">
</form>

<p><c:out value="${averageAgeOfUsersByBook}" default=""/></p>

<br>

<form action="/Library_war_exploded/usersReadingHistory" method="get">
    <legend>Show stats on user whose name is:</legend>
    <br>
    <input type="text" id="userName" name="userName"><br>
    <br>
    <input type="submit" name="button" value="Show user's reading history">
    <br>
</form>

<p><c:forEach var="bookReadInThePast" items="${booksReadInThePast}">
    <c:out value="${bookReadInThePast}" default=""/>
</c:forEach></p>

<br>

<form action="/Library_war_exploded/booksUserIsCurrentlyReading" method="get">
    <legend>Show stats on user whose name is:</legend>
    <br>
    <input type="text" id="userNameC" name="userName"><br>
    <br>
    <input type="submit" name="button" value="Show which books user is currently reading">
    <br>
</form>

<p><c:forEach var="bookReadCurrently" items="${booksReadCurrently}">
    <c:out value="${bookReadCurrently}" default=""/>
</c:forEach></p>

<br>

<form action="/Library_war_exploded/numOfDaysUserIsUsingLibrary" method="get">
    <legend>Show stats on user whose name is:</legend>
    <br>
    <input type="text" id="userNameN" name="userName"><br>
    <br>
    <input type="submit" name="button" value="Show how long is user using the library">
    <br>
</form>

<p><c:out value="${numOfDaysUserIsUsingLibrary}" default=""/></p>

<br>

<form action="/Library_war_exploded/debtors" method="get">
    Show list of debtors:
    <br>
    <br>
    <input type="submit" value="Submit">
</form>

<p><c:forEach var="debtor" items="${debtors}">
    <c:out value="${debtor}" default=""/>
</c:forEach></p>

<br>

</body>
</html>
