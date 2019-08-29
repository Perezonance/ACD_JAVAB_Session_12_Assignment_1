<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action=" BookUpdate" method="post">
		Book Title:<br />
		<input type="text" name="bTitle"><br/>
		Author:<br />
		<input type="text" name="bAuthor"><br />
		Publisher:<br />
		<input type="text" name="bPub"><br />
		Publication_Year:<br />
		<input type="text" name="bYear"><br />
		Price:<br />
		<input type="text" name="bPrice"><br />
		Book_id:<br />
		<input type="text" name="bID"><br />
		
		<input type="radio" name="type" value="add"> add
		<input type="radio" name="type" value="update"> update
		<input type="radio" name="type" value="delete"> delete<br />
		<input type="submit" value="submit"><br />
	</form>
</body>
</html>