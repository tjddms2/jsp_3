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
		$("#idcehck").val('f'); 
	 });
	 
		$("#join").click(function(){
			var check = $("#idcheck").val();
			if(check == 's'){
				alert("OK");
			}else {
				alert("ID 중복 체크");
			}
		});
	
		$("#btn").click(function() {
			//var id=$("#id").val();
			var id=document.frm.id.value;
			window.open("./memberCheckid.do?id="+id, "", "width=300, height=200, top=300, left=500");
	    	 });
	      });
</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>
<div class="container-fluid">
<div class="row">
	<form name="frm" action="./memberJoin.do" method="post" enctype="multipart/form-data">
			<input type="hidden" value="f" name="idCheck" id="idCheck">
			
		    <div class="form-group">
		      <label for="title">ID:</label>
		      <input type="text" class="form-control" id="id" placeholder="Enter Title" name="id">
		      <input type="button" id="btn" value="중복확인">
		    </div>
		    <div class="form-group">
		      <label for="writer">PW:</label>
		      <input type="password" class="form-control" id="writer" placeholder="Enter Writer" name="pw">
		    </div>
		     <div class="form-group">
		      <label for="writer">PW:</label>
		      <input type="password" class="form-control" id="writer" placeholder="Enter Writer" name="pw">
		    </div>
		    <div class="form-group">
		      <label for="title">NAME:</label>
		      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="name">
		    </div>
		    <div class="form-group">
		      <label for="title">Email:</label>
		      <input type="email" class="form-control" id=email placeholder="Enter Title" name="email">
		    </div>
		    <div class="form-group">
		      <label for="title">Kind:</label>
		      <input type="text" class="form-control" id="kind" placeholder="Enter Title" name="kind">
		    </div>
		    <div class="form-group">
		      <label for="title">ClassMate:</label>
		      <input type="text" class="form-control" id="classMate" placeholder="Enter Title" name="classMate">
		    </div>
		    
		    <div class="form-group">
		      <label for="file">File:</label>
		      <input type="file" class="form-control" id="file" name="f1">
		    </div>
	  	    
	    <input type="button" id="join" class="btn btn-default" value="JOIN">
 	 </form>
</div>
</div>

	
<c:import url="../../../temp/footer.jsp"/>
</body>
</html>