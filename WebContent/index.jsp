<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="./temp/bootstrap.jsp"></jsp:include>		<!-- 나머지를 컴파일 끝내놓고 누군가가 인덱스를 호출하면 애를 가지고 실행을 하고 오는것 -->
</head>
<body>
	<jsp:include page="./temp/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<h1>Index Page</h1>

		</div>

	</div>

	<jsp:include page="./temp/footer.jsp"></jsp:include>						
</body>
</html>