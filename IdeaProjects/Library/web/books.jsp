<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h1>Books</h1>
<form action="/Library_war_exploded/independenceBooks" method="GET">
    Show quantity of books, published after Ukraine proclaimed its independence:
    <br/>
    <input type="submit" value="Submit">
</form>

<p><c:out value="${numOfBooks}" default="" /></p>

</body>
</html>
