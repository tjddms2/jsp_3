<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootstrap.jsp"></c:import>
<script type="text/javascript">
	$(function(){
	$("#btn").click(function(){
		$.ajax({
			url:"../a/list.do",
			type:"GET",
			success:function(data){
				data = data.trim();
				con.log(data);
				data = JSON.parse(data);
				console.log(data);
				console.log(data.length);
				
				/*1. for(vat i=0;i<data.length;i++){
					console.log(data[i].num)
					console.log(data[i].writer)
					console.log("===========");
				} */
				 $.each(data,function(){
					 console.log("=============");
					 console.log(index)
					 console.log(d.num)
					console.log(this.num)
				});
				alert("F");
			}
		});
	});
});
</script>
</head>
<body>

<input type="button" value="click" id="btn">
</body>
</html>