<%@page import="java.util.List"%>
<%@page import="com.se.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../temp/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="../../../temp/header.jsp"></c:import>

<div class="container-fluid">
<div class="row">
<!-- 로그인 전 -->
<a href="./memberLogin.bo">Login</a>
<a href="./memberJoin.bo">Join</a>
<!-- 로그인 후  -->
<a href="./memberLogout.bo">Logout</a>
<a href="./memberMyPage.bo">MyPage</a>
</div>

</div>

	
<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>