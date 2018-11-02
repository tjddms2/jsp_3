
<%@page import="java.util.List"%>
<%@page import="com.se.notice.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   		String board =(String)request.getAttribute("board");
    %> 
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>Bootstrap Theme Company Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../../../temp/bootstrap.jsp"></jsp:include>	
<script type="text/javascript">
	$(function() {
		$("#btn").click(function(){
			var.title = $("#title").val();
			if(title!=''){	/*타이틀의 벨류가 같지 않다면 */
				$("#frm").submit();
			}else {
				alert("Title을 입력");
			}
		});
	});

</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<jsp:include page="../../../temp/header.jsp"></jsp:include>
	
<div class="container-fluid">
	<div class="row">
	
	  <form id="frm" action="./${board}Write.do" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label for="title">TITLE:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">WRITER:</label>
	      <input type="text" value="${member.id}" readonly="readonly" class="form-control"  id="writer" placeholder="Enter writer" name="writer">
	    </div>
	    <div class="form-group">
	      <label for="contents">CONTENTS:</label>
	      <textarea rows="25" cols="" class="form-control" name="contents"></textarea>
	    </div>
	    
	    <!-- <div class="form-group">
	      <label for="file">File:</label>
	      <input type="file" class="form-control"  id="file"  name="f1">
	    </div> -->
	    
	    <input type="button" value="file Add">
	    <div class="files" id="file">
	    
	    </div>
	    <input type="button" id="btn" value="write" class="btn btn-default">
 	 </form>
 	 </div>
	</div>
</div>


<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>