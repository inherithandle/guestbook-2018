<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Tell us what you think!</h2>
<hr>
<form method=post>
    Name: <input type=text name="name"><br>
    Email Address: <input type=text name="email"><br>
    Comments: <br><textarea name=Comments rows=5 cols=60>
</textarea><br><br>
    <input type=submit value="Submit">
</form>
<hr noshade>
<c:forEach items="${commentList}" var="comment">
    ${comment.insertDate}<br>
    <b>Name:</b> ${comment.username}<br>
    <b>Comment:</b> ${comment.text}
    <hr>
</c:forEach>
</body>
</html>
