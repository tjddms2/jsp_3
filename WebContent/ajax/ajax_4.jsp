<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootstrap.jsp"/>
<script type="text/javascript">
$(function(){	//blur: focus 나갈대 event 발생
	$("#id").blur(function(){	//keyup : 한 글자 입력할 때마다 event 발생 
		var id= $(this).val();
	$.ajax({ //여러개일 때는 항상 {}로 묶기
		url:"../a/membercheckid.do", //여러개일 때 , 로 구분 ->AjaxController로 감
		type:"POST", 
		data:{
			id:id			
		},
		success:function(data){
			data = data.trim(); //trim : 앞뒤 공백을 제거
			if(data=='2'){
				$("#result").html("<h1>사용가능</h1>");
			}else {
				 $("#result").html("<h1>사용불가능</h1>");
                 $("#id").val(''); // 사용불가능 뜸과 동시에 id value 값 지우기 ('' 대입)

			}
		},
		error:function(){
			$("#id").val('');
			alert("error 발생");
		}
		
	});
	});
});


</script>
</head>
<body>
<input type="text" id="id">
<button id="btn">CLICK</button>
<div id="result"></div>
</body>
</html>