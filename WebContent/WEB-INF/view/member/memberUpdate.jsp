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
			<form action="./memberUpdate.do" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="id">Id:</label> 
				<input type="text" value="${member.id}" readonly="readonly" class="form-control" id="id" placeholder="Enter id" name="id"></div>

		<div class="form-group">
			<label for="pw">PW:</label> 
				<input type="Password" value="${member.pw}" class="form-control" id="pw" placeholder="Enter Pw"></div>

		<div class="form-group">
				<label for="name">Name:</label> 
					<input type="text" value="${member.name}" class="form-control" id="name" placeholder="Enter Name" name="name"></div>


		<div class="form-group">
			<label for="email">Email:</label> 
					<input type="text" value="${member.email}" class="form-control" id="email" placeholder="Enter Email" name="email"></div>

				<div class="form-group">
					<label for="file">file:</label> 
					<input type="text" class="form-control" id="file" name="f1"></div>


				<button type="submit" class="btn btn-default">Writer</button>
			</form>
		</div>
	</div>


	<c:import url="../../../temp/footer.jsp"/>
</body>
</html>