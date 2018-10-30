<%@page import="com.se.file.FilDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.se.board.BoardDTO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    BoardDTO boardDTO = (BoardDTO)request.getAttribute("dto");
   /*  List<FilDTO> ar = (List<FilDTO>)request.getAttribute("files"); */
    String board =(String)request.getAttribute("board");
    	
    %>
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
		<h1><%=board %> View</h1>
	</div>
	
	<div class="row">
		<h1>TITLE : <%= boardDTO.getTitle() %></h1>
		<h1>WRITER : <%=boardDTO.getWriter() %></h1>
		<h1>Contents: <%=boardDTO.getContents() %></h1>
		
		</div>
	</div>
	<div>
		<a href="./<%=board %>list.do">List</a>
		<a href="./<%=board %>UpdateForm.do">Update</a>
		<a href="./<%=board %>Delete.do">Delete</a>
	</div>
<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>