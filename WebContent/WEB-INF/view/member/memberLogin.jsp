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
			<h3>${message}</h3>

		</div>
		<div class="row">
			<form action="./memberLogin.do" method="post">
				<div class="form-group">
					<label for="id">Id:</label> <input type="text" class="form-control"
						id="id" placeholder="Enter id" name="id"></div>

				<div class="form-group">
					<label for="pw">PW:</label> <input type="Password"
						class="form-control" id="pw" placeholder="Enter Pw"></div>

				<div class="form-group">
					<label for="Kind">Kind:</label> <input type="text"
						class="form-control" id="Kind" placeholder="Enter Kind"
						name="Kind"></div>

				<button type="submit" class="btn btn-default">writer</button>
			</form>
		</div>
	</div>


	<c:import url="../../../temp/footer.jsp"/>
</body>
</html>