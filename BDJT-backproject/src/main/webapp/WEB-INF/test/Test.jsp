<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>test.jsp</title>
</head>
<body>
	<h2>회원 등록 및 조회</h2>
	<hr>
	
	<form method="POST">
	<fieldset>
		<legend>회원 등록</legend>
		
		<label for="id">이름 : </label>
		<input type="text" name="id" id="id" required>
		
		<label for="github">깃허브 주소 : </label>
		<input type="github" name="github" id="github" required>
		
		<input type="submit" value="등록">
	</fieldset>
	</form>
	
	<hr>
	
	<h3>전체 목록</h3>
	<ol>
		<c:forEach items="${userList}" var="testDO">
			<li>이름 : ${testDO.id} | 이메일 : ${testDO.github}</li>
		</c:forEach>
	</ol>
</body>
</html>