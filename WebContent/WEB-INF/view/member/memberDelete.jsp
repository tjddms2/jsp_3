<%@page import="com.se.member.MemberDAO"%>
<%@page import="com.se.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
	MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
	MemberDAO memberDAO = new MemberDAO();
	

	
	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootstrap.jsp"/>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>



<c:import url="../../../temp/footer.jsp"/>
</body>
</html>