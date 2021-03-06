
<%@page import="com.se.page.Pager"%>
<%@page import="com.se.board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.se.page.MakePager"%>
<%@page import="com.se.page.RowNumber"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@page import="com.se.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    request.setCharacterEncoding("UTF-8"); 					//한글깨짐현상 없애줌 /들어오고
    response.setCharacterEncoding("UTF-8");									//나감
     
    //1.
    int curPage=1;											//Exception 깨질까봐
    try{
    	curPage =  Integer.parseInt(request.getParameter("curPage"));
    }catch(Exception e){
    	
    }
    //2.
    String kind= request.getParameter("kind");
    if(kind == null || kind.equals("")){
    	kind="title";
    }
    //3.
    String search = request.getParameter("seatch");
    if(search ==null){
    	search= "";
    }
    
    BoardDAO boardDAO = new NoticeDAO();
    MakePager mk= new MakePager(curPage, search, kind);
    List<BoardDTO> ar=boardDAO.selectList(mk.makeRow());
    int totalCount = boardDAO.getCount(kind, search);
    		
    //page
    Pager pager= mk.makePage(totalCount);
        
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../temp/bootstrap.jsp" %>
</head>
<body>
<jsp:include page="../temp/header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
		<h1>Notice </h1>
	</div>
		<div class="row">
			<div>
				<form action="./noticeWriteProcess.jsp" method="post">
					<div class="form-group">
						<label for="title">TITLE:</label> <input type="text"
							class="form-control" id="title" placeholder="Enter title"
							name="title">
					</div>
					+
					<div class="form-group">
						<label for="writer">WRITER:</label> <input type="text"
							class="form-control" id="writer" placeholder="Enter writer"
							name="writer">
					</div>
					<div class="form-group">
						<label for="contents">CONTENTS:</label>
						<textarea rows="10" cols="" class="form-control" name="contents"></textarea>
					</div>
					<button type="submit" class="btn btn-default">WRITER</button>
				</form>
			</div>

			<table class="table table-hover">
				<tr>
					<td>NUM</td>
					<td>TITLE</td>
					<td>WRITER</td>
					<td>REG_DATE</td>
					<td>HIT</td>
				</tr>
				<% for(BoardDTO boardDTO: ar) {%>
				<tr>
					<td><%=boardDTO.getNum()%></td>
					<td><a href="./noticeSelectOne.jsp?num=<%=boardDTO.getNum()%>"><%=boardDTO.getTitle()%></a></td>
					<td><%=boardDTO.getWriter()%></td>
					<td><%=boardDTO.getReg_date()%></td>
					<td><%=boardDTO.getHit()%></td>
				</tr>
				<%} %>
			</table>
			<div class="container-fluid">
				<div class="row">

					<ul class="pagination">
						<li><a href="./noticeList.jsp?curPage=<%= 1%>"><span
								class="glyphicon glyphicon-backward"></span></a></li>

						<%if(pager.getCurBlock()>1){ %>
						<li><a
							href="./noticeList.jsp?curPage=<%= pager.getStartNum()-1%>"><span
								class="glyphicon glyphicon-chevron-left"></span></a></li>
						<%} %>

						<%for(int i=pager.getStartNum();i<=pager.getLastNum();i++){ %>
						<li><a href="./noticeList.jsp?curPage=<%=i%>"><%=i%></a></li>
						<%} %>

						<%if(pager.getCurBlock() < pager.getTotalBlock()){ %>
						<li><a
							href="./noticeList.jsp?curPage=<%=pager.getLastNum()+1%>"><span
								class="glyphicon glyphicon-chevron-right"></span></a></li>
						<%} %>

						<li><a
							href="./noticeList.jsp?curPage=<%=pager.getTotalPage()%>"><span
								class="glyphicon glyphicon-forward"></span></a></li>
					</ul>

				</div>

			</div>

		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1">
					<a href="./noticeWriteForm.jsp"></a>
				</div>
			</div>
		</div>
		
		<jsp:include page="../temp/footer.jsp"></jsp:include>
</body>
</html>