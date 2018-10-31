<%@page import="com.se.file.FilDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.se.board.BoardDTO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   	 BoardDTO boardDTO = (BoardDTO)request.getAttribute("dto");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../temp/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../temp/header.jsp"></jsp:include>
	<div class="container-fluid">
	<div class="row">
		<h1>TITLE : ${boardDTO.title} </h1>
		<h1>WRITER :${boardDTO.writer}</h1>
		<h1>Contents:${boardDTO.contents}</h1>
		
		</div>
	</div>
	<div>
		<a href="./qnalist.do">List</a>
		<a href="./qnaUpdateForm.do">Update</a>
		<a href="./qnaDelete.do">Delete</a>
	</div>
<jsp:include page="../../temp/footer.jsp"></jsp:include>
</body>
</html>