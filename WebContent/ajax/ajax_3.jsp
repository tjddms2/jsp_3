<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootstrap.jsp"/>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		var id= id=$("id").val();
		/* $.get("../member/memberCheckId.do?id="+id,function(data){
			$("#result").html(data);
		}); */
		 $.post("../member/memberCheckid.do?", , function(data){
				$("#result").html(data);
			});
	});
});

</script>
</head>
<body>
	<h1>$.GET</h1>
	<input type="text" id="id">
	<button id="btn">CLICK</button>
	<div id="result">	<!-- 결과물 -->
	
	
	</div>
</body>
</html>