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
 <script type="text/javascript">
 $(function () {
	 
	 $("#id").change(function(){
		$("#idcehck").var('f'); 
	 });
	 
		$("#join").click(function(){
			var check = $("#idcheck").val();
			if(check == 's'){
				alert("OK");
			}else {
				alert("ID 중복 체크");
			}
		});
	
	    $("#btn").click(function(){
	    		/*  var id=$("#id").val(); */
	    		var id = document.frm.id.value;
	    		window.open("./memberCheckid.do?id="+id, "", "width=300, height=200, top=300, left=500"); /*GET 방식*/
	    	 });
	      });
</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>
<div class="container-fluid">
<div class="row">
<form name="frm" action="./memberJoin.do" method="post" enctype="multipart/form-data">
	<input type="hidden" value="f" id="idcheck" name="idcheck">
	
	    <div class="form-group">
	      <label for="id">Id:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter Title" name="id">
	      <input type="button" id="btn" value="증복확인"> 
	    
	    </div>
	    
	    <div class="form-group">
	      <label for="pw">PW:</label>
	      <input type="Password" class="form-control" id="pw" placeholder="Enter Pw">
	    </div>
	     <div class="form-group">
	      <label for="pw">PW2:</label>
	      <input type="Password" class="form-control" id="pw2" placeholder="Enter Pw">
	    </div>
	    
	   <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
	    </div>
	    
	     <div class="form-group">
	      <label for="Kind">Kind:</label>
	      <input type="text" class="form-control" id="Kind" placeholder="Enter Kind" name="Kind">
	    </div>
	    
	    <div class="form-group">
	      <label for="ClassMate">ClassMate:</label>
	      <input type="text" class="form-control" id="ClassMate" placeholder="Enter ClassMate" name="classMate">
	    </div>
	    
	    
	    <div class="form-group">
	      <label for="file">file:</label>
	      <input type="text" class="form-control" id="file" placeholder="Enter file" name="file">
	    </div>
	
	  	    
	    <input type="button" id="join" class="btn btn-default" value="JOIN">
 	 </form>
</div>
</div>

	
<c:import url="../../../temp/footer.jsp"/>
</body>
</html>