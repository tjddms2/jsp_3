<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../../../tmp/bootstrap.jsp"/>
<script type="text/javascript">
$(function(){
	$("#id").click(function(){
		opener.document.frm.id.value="${param.id}";
		opener.document.frm.id.value="${'s'}"
		/* opener.document.getElementById("id").value="${param.id}"; */		
		self.close();
	});
});
</script>
</head>
<body>
	<h1>member Check Id</h1>
	<div>
		<c:if test="${result eq 1}">
		<h3>${param.id}사용 가능한 아이디입니다.</h3>
		<button id="btn">사용하기</button>
		</c:if>
		
		<c:if test="${result eq 2}">
		<h3>${param.id}이미 사용된 아이디입니다.</h3>
		
		</c:if>
	</div>
	<div>
		<form action="./memberCheckid.do">
			<input type="text" name="id">
			<button>중복확인</button>
		</form>
	</div>
</body>
</html>