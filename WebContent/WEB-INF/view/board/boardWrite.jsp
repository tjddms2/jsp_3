
<%@page import="java.util.List"%>
<%@page import="com.se.notice.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>Bootstrap Theme Company Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../../../temp/bootstrap.jsp"></jsp:include>	
<script src="https://cdn.ckeditor.com/4.10.1/full/standard/ckeditor.js"> /*full : 모든 메뉴를 다 넣겠다!*/
</script>
<script type="text/javascript">
	$(function() {
		
		CKEDITOR.replace("contents")
		
		$("#btn").click(function(){
			var title = $("#title").val();
			if(title !=''){	/*타이틀의 벨류가 같지 않다면 */
				$("#frm").submit();
			}else {
				alert("Title을 입력");
			}
		});
		
		var count=1;
		var index=0;
		$("#add").click(function(){
			if(count<6){
			var r= '<div class="form-group" id="f'+index+'">';
			r = r+'<label for="file">File:</label>';
			r = r+' <input type="file" class="form-control" id="file" name="f'+index+'">';
			r = r+'<span class="remove" title="'+index+'">X</span>';
			r = r+'</div>';
		
		$("#file").append(r);
		count++;
		index++;
			}else {
				alert("파일의 5개 까지 가능합니다.");
			}
		});
		$("#file").on("click", ".remove", function(){
			var t = $(this).attr("title");
			$("#f"+t).remove();
			count--; // count는 감소 시켜야됨!
		});
	});

</script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<jsp:include page="../../../temp/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<form id="frm" action="./${board}Write.do" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="title">Title:</label> <input type="text"
						class="form-control" id="title" placeholder="Enter Title"
						name="title">
				</div>
				<div class="form-group">
					<label for="writer">Writer:</label> <input type="text"
						value="${member.id}" readonly="readonly" class="form-control"
						id="writer" placeholder="Enter Writer" name="writer">
				</div>
				<div class="form-group">
					<label for="contents">Contents:</label>
					<textarea rows="10" cols="" class="form-control" name="contents"></textarea>
				</div>

				<!-- <div class="form-group">
	      <label for="file">File:</label>
	      <input type="file" class="form-control"  id="file"  name="f1">
	    </div> -->

				<input type="button" value="file Add">
				<div class="files" id="file"></div>
				<input type="button" id="btn" value="write" class="btn btn-defualt">
			</form>
		</div>
	</div>



	<jsp:include page="../../../temp/footer.jsp"></jsp:include>
</body>
</html>