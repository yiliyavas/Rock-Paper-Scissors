<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rock Paper Scissor</title>
</head>
<body>
<h1>Click on your choice</h1>

<!-- when click on certain action, same task would be performed that will 
also depend on computer randomness of choice
i.e. displayRock means user puts rock, then program runs and check computer's choice
and comparing the result user is determined
 -->
 
<form action = "displayRock"> <input type = "submit" value = "Rock"/> </form>
<form action = "displayPaper"> <input type = "submit" value = "Paper"/> </form>
<form action = "displayScissor"> <input type = "submit" value = "Scissor"/> </form>

</body>


<!--  displays final statement after user and computer made choice -->
<c:forEach var="m" items="${method}">
	<tr style="text-align:center">
		<td><c:out value="${m.statement}" /></td>
	</tr>
</c:forEach>

</html>