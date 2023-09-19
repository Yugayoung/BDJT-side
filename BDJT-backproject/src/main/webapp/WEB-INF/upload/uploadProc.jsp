<%@ page contentType="text/html; charset=UTF-8"
		 import="com.oreilly.servlet.*, com.oreilly.servlet.multipart.*"
		 import="java.util.*"
%>

<%
	String directory = "C:/projects/workspace/myWeb/src/main/webapp/upload";
	int sizeLimit = 1024 * 1024 * 5;		// 5MB 제한
	MultipartRequest multi = new MultipartRequest(request, directory, sizeLimit,
								"UTF-8", new DefaultFileRenamePolicy());

	String params = "";
	String paramName = "";
	String savedName = "";
	
	@SuppressWarnings("unchecked")
	Enumeration<String> paramNames = multi.getParameterNames();
	
	while(paramNames.hasMoreElements()) {
		paramName = (String)paramNames.nextElement();
		params +=  "<h4>" + paramName + ": " + multi.getParameter(paramName) + "</h4>";
	}
	
	@SuppressWarnings("unchecked")
	Enumeration<String> fileNames = multi.getFileNames();
	
	if(fileNames.hasMoreElements()) {
		paramName = fileNames.nextElement();
		savedName = multi.getFilesystemName(paramName);
		params +=  "<h4>원본 파일 이름: " + multi.getOriginalFileName(paramName) + "</h4>";
		params +=  "<h4>저장 파일 이름: " + savedName + "</h4>";
	}
	
	request.setAttribute("params", params);
	request.setAttribute("savedFileURI", "/myWeb/upload/" + savedName);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<h2>파일 업로드 결과</h2>
	<hr />
	
	<h3>파라미터 정보</h3>
	${params}
	
	<hr />
	
	<a href="${savedFileURI}">저장된 파일 이미지</a>

</body>
</html>












