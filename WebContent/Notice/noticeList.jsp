
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
    
    request.setAttribute("list", ar);
    request.setAttribute("board", "norice");
    request.setAttribute("pager", pager);
    
    RequestDispatcher view= request.getRequestDispatcher("../board/boardList.jsp");
    view.forward(request, response);
    
    
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>