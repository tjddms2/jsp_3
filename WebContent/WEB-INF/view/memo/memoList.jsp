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
$(function(){
	$("#write"),click(function(){
		var writer =$("#writer").val();
		var contents =$("#contents").val();
		
		var xhp= new XMLHttpRequest();
		xhp.open("GET","../../../memoList.jsp");
		xhp.send();
		
		
	});
});
</script>
</head>
<body>
<c:import url="../../../temp/header.jsp"/>
<div class="container-fluid">
  <div class="row">
     <div class="form-group">
       <label for="writer">WRITER:</label>
       <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
   </div>
   <div class="form-group">
       <label for="contents">CONTENTS:</label>
       <textarea rows="15" cols="" class="form-control" name="contents"></textarea>
   </div>
   
   <input type="button" id="write" value="write">
  </div>
  <div class="row">
       <table class="table table-hover">
          <tr>
             <td>NUM</td>
             <td>CONTENTS</td>
             <td>WRITER</td>
             <td>DATE</td>
          </tr>       
          <c:forEach items="${list}" var="m">
             <tr>
                <td>${m.num}</td>
                <td>${m.contents}</td>
                <td>${m.writer}</td>
                <td>${m.reg_date}</td>
             </tr>
          </c:forEach>
       </table>     
  </div>
</div>

<c:import url="../../../temp/footer.jsp"/>
</body>
</html>