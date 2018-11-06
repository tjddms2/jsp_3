<%@page import="com.se.file.FilDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.se.board.BoardDTO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../temp/bootstrap.jsp"/>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

	<div class="container-fluid">
		<div class="row">
			<h1>${board} View</h1>
		</div>

		<div class="row">
			<h1>TITLE : ${dto.title}</h1>
			<h1>WRITER : ${dto.writer}</h1>
			<h1>Contents : ${dto.contents}</h1>

		</div>
		
	</div>
	<div>
		<a href="./${requestScope.board}List.do">List</a>
		<a href="./${requestScope.board}Update.do?num=${dto.num}">Update</a>
		<a href="./${requestScope.board}Delete.do?num=${dto.num}">Delete</a>
		<c:if test="${board ne 'notice'}">
			<a href="./${board}Reply.do">Reply</a>
		</c:if>
		<!--<c:if test="${not empty board}"></c:if> : 비어있지 않습니다. -->
		<!--<c:if test="${empty board}"></c:if> : null 이거나 공백이다. -->
	</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>