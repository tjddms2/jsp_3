<%@page import="com.se.board.BoardDTO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    
    int num = Integer.parseInt(request.getParameter("num"));
    NoticeDAO noticeDAO = new NoticeDAO();
    BoardDTO boardDTO=noticeDAO.selectOne(num);
    
    
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../temp/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../temp/header.jsp"></jsp:include>
	<div class="container-fluid">
	<div class="row">
		<h1>TITLE : <%= boardDTO.getTitle() %></h1>
		<h1>WRITER : <%=boardDTO.getWriter() %></h1>
		<h1>Contents: <%=boardDTO.getContents() %></h1>
		</div>
		</div>
	<div>
		<a href="./noticelist.jsp">List</a>
		<a href="./noticeUpdateForm.jsp">Update</a>
		<a href="./noticeDelete.jsp">Delete</a>
	</div>
<jsp:include page="../temp/footer.jsp"></jsp:include>
</body>
</html>