<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		 
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>jdbcTest_v3.jsp</title>
</head>
<body>
	<h2>회원 등록 및 조회</h2>
	<hr>
	
	<form method="POST">
	<fieldset>
		<legend>회원 등록</legend>
		
		<label for="username">이름 : </label>
		<input type="text" name="username" id="username" required>
		
		<label for="email">이메일 : </label>
		<input type="email" name="email" id="email" required>
		
		<input type="submit" value="등록">
	</fieldset>
	</form>
	
	<hr>
	
	<h3>전체 회원 목록</h3>
	<ol>
		<c:forEach items="${userList}" var="userDO">
			<li>이름 : ${userDO.username} | 이메일 : ${userDO.email}</li>
		</c:forEach>
	</ol>
</body>
</html>