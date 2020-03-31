<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Books</title>
</head>
<body>
<h1>Books</h1>
<form action="/Library_war_exploded/independenceBooks" method="get">
    Show quantity of books, published after Ukraine proclaimed its independence:
    <br>
    <br>
    <input type="submit" value="Submit">
</form>

<p><c:out value="${numOfBooks}" default=""/></p>

<br>
<form action="/Library_war_exploded/booksByAuthor" method="get">
    <fieldset>
        <legend>Find a book / books by author:</legend>
        <label for="firstName">Please enter author's first name:</label><br>
        <input type="text" id="firstName" name="firstName"><br>
        <label for="lastName">Please enter author's last name:</label><br>
        <input type="text" id="lastName" name="lastName"><br>
        <br>
        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:forEach var="bookByAuthor" items="${booksByAuthor}">
    <c:out value="${bookByAuthor}" default=""/>
</c:forEach></p>

<br>
<form action="/Library_war_exploded/booksByCoauthor" method="get">
    <fieldset>
        <legend>Find a book / books by coauthor:</legend>
        <label for="firstName">Please enter coauthor's first name:</label><br>
        <input type="text" id="coauthorFirstName" name="firstName"><br>
        <label for="lastName">Please enter coauthor's last name:</label><br>
        <input type="text" id="coauthorLastName" name="lastName"><br>
        <br>
        <input type="submit" value="Submit">
    </fieldset>
</form>

<p><c:forEach var="bookByCoauthor" items="${booksByCoauthor}">
    <c:out value="${bookByCoauthor}" default=""/>
</c:forEach></p>

</body>
</html>
