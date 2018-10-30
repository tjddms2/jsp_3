<%@page import="com.se.file.FilDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.se.board.BoardDTO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../temp/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../../temp/header.jsp"></jsp:include>

	<div class="container-fluid">
	<div class="row">
		<h1>${requestScope.board} View</h1>
	</div>
	
	<div class="row">
		<h1>TITLE : ${dto.title}</h1>
		<h1>WRITER : ${dto.writer} </h1>
		<h1>Contents:${dto.contents}</h1>
		
		</div>
	</div>
	<div>
		<a href="./${requestScope.board}list.do">List</a>
		<a href="./${requestScope.board}Update.do?num=${dto.num}">Update</a>
		<a href="./${requestScope.board}Delete.do?num=${dto.num}">Delete</a>
	</div>
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>