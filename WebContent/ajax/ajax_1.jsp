<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
<c:import url="../temp/bootstrap.jsp"/>
<script type="text/javascript">
$(function(){
	
	$("#btn3").click(function(){
		var title=$("#title").val();
		var writer=$("#writer").val();
		var contents=$("#contents").val();
		
		var xhp = new XMLHttpRequest();	
		xhp.open("POST", "../notice/noticeSelectOne.do");
		xhp.send("title="+title+"&writer="+writer+"&contents="+contents);
		
		xhp.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200)  /*4번은끝났다.*/{
				$("#result").html(this.responseText);
			}
			}
	});
	$("#btn2").click(function(){
		var num= $("#num").val();
		var xhp= new XMLHttpRequest();
		
		xhp.open("GET","../notice/noticeDelete.do?num="+num);
		xhp.send();
		xhp.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200)
				$("#result").html(this.responseText);
		
		}
		
	});
	$("#btn").click(function(){
		var num= $("#num").val();
		var xhp = new XMLHttpRequest();	
		
		xhp.open("GET", "../notice/noticeSelectOne.do?num="+num);
		xhp.send();
		xhp.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200)  /*4번은끝났다.*/{
				$("#result").html(this.responseText);
			}
		}
		
	});
});


</script>

</head>
<body>
<h1>AJAX TEST</h1>
<div>
	<input type="text" id="writer">
	<input type="text" id="title">
	<textarea rows="contens" cols=""></textarea>
	<button id="btn">WRITE</button>

</div>
<h1>AJAX TEST</h1>
	<input type="number" id="num">
	<input type="button" id="btn" value="CLICK">
	<input type="button" id="btn2" name="delete" value="delete">
	<div class="result">
	
	</div>

</body>
</html>