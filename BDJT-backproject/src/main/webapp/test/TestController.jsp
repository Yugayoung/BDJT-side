<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, test.*"%>

<%
	TestDAO testDAO = (TestDAO)session.getAttribute("testDAO");

	if(testDAO == null) {
		testDAO = new TestDAO();
		session.setAttribute("testDAO", testDAO);
	}
	
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		
		TestDO testDO = new TestDO();
		testDO.setId(request.getParameter("id"));
		testDO.setGithub(request.getParameter("github"));
		
		testDAO.insertUserInfo(testDO);
	}
	
	request.setAttribute("userList", testDAO.users());
	pageContext.forward("/WEB-INF/test/Test.jsp");
%>