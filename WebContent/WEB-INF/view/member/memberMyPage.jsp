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
<c:import url="../../../temp/bootstrap.jsp"/>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>

	<div class="container-fluid">
		<div class="row">
			<h1>ID: ${member.id}</h1>
			<h1>Name: ${member.name}</h1>
			<h1>Email: ${member.email}</h1>
		<img src="../upload/${member.fname}">
		</div>
	<div class="row">
	<a href="./memberUpdate.do">Update</a>	
	<a href="memberDelete.do">Delete</a>
	</div>
	</div>
<!-- ./memberUpdate.do \  memberDelete.do
				 둘다 현재위치 가리키는것  -->

	<c:import url="../../../temp/footer.jsp"/>
</body>
</html>