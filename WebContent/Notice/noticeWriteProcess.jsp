<%@page import="com.se.notice.NoticeDAO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@page import="com.se.notice.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dto" class="com.se.notice.NoticeDTO" scope="page"></jsp:useBean>
    <jsp:setProperty property="*" name="dto"/>
   <%--  <jsp:setProperty property="writer" name="dto"/>
    <jsp:setProperty property="contents" name="dto"/> --%>
     <%
     /*noticeDTO dto = new noticeDTO(); :useBean */
    /*dto.setTitle(request.getParameter("title")); :setProperty*/
   /*dto.setWriter(request.getParameter("writer")); :setProperty*/
  /*dto.setContents(request.getParameter("contents")); :setProperty*/
  
  String s1= request.getParameter("f1");
     
     System.out.println(s1);
  
    NoticeDAO noticeDAO = new NoticeDAO();
    int result= noticeDAO.insert(noticeDTO);
    
    String s ="Write fail";
    if(result>0){
    	s ="Write Success";
    }
    
    request.setAttribute("message", s);
    request.setAttribute("path", "noticeList.jsp?curPage=1");
    RequestDispatcher view = request.getRequestDispatcher("../common/result.jsp");
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