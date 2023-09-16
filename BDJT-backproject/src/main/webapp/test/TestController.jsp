<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, test.*"%>

<%
	TestDAO userDAO = (TestDAO)session.getAttribute("userDAO");

	if(userDAO == null) {
		userDAO = new TestDAO();
		session.setAttribute("userDAO", userDAO);
	}
	
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		
		TestDO userDO = new TestDO();
		userDO.setUsername(request.getParameter("username"));
		userDO.setEmail(request.getParameter("email"));
		
		userDAO.insertUserInfo(userDO);
	}
	
	request.setAttribute("userList", userDAO.getAllUserInfo());
	pageContext.forward("/WEB-INF/views/chap09/jdbcTest_v3.jsp");
%>