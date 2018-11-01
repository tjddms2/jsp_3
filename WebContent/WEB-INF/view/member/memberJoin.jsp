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
<form action="./memberJoin.do" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label for="id">Id:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
	      
	    </div>
	    
	    <div class="form-group">
	      <label for="pw">PW:</label>
	      <input type="Password" class="form-control" id="pw" placeholder="Enter Pw">
	      
	    </div>
	    
	   <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">ClassMate:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="classMate">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
	    </div>
	    
	    <div class="form-group">
	      <label for="ClassMate">ClassMate</label>
	      <input type="text" class="form-control" id="classMate" placeholder="Enter ClassMate" name="classMate">
	    </div>
	
	  	    
	    <button type="submit" class="btn btn-default">WRITER</button>
 	 </form>
</div>
</div>

	
<c:import url="../../../temp/footer.jsp"></c:import>
</body>
</html>