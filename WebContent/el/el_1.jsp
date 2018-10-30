<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%
    request.setAttribute("start", 1);
    request.setAttribute("end", 5);
    
    ArrayList<Integer>ar = new ArrayList<>();
    ar.add(100);
    ar.add(200);
    ar.add(300);
    
    request.setAttribute("ar", ar);
    
    Map<String, String >map = new HashMap<>(); // key도 String 
    map.put("f1", "name1");
    map.put("f2", "name2");
    map.put("f3", "name3");
    request.setAttribute("ar", "m");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="">test</a>
	<%for(int i=0;i<10;i++) {%>
		<h1><%=i %></h1>
		
	<%}%>
	<c:forEach begin="1" end="10" var="i">
	<h1>${i}</h1>
	</c:forEach>

	 <c:forEach begin="${start}" end="${last}" step="2" var="i">
	<h1>${i}</h1>
	</c:forEach> 
	<hr>
	<%-- 
		ERROR!<c:forEach begin="${ena}" end="${start}" step="-1" var="i"> <!-- step: 증감식은 -가 없다. -->
	<h1>${i}</h1>
	</c:forEach> --%>
	
	<%	for(int i=0;i<ar.size();i++) {}%>
	<%	for(Integer num : ar){} %> <!-- ar: 출력 -->
				<!-- || -->
	<c:forEach items="${ar}" var="i" varStatus="v"><!-- items : 집합객체/참조변수 -->
		<h3>${i}</h3>
		<h3>${v.count}</h3>	
		<h3>${v.index}</h3>	
		<h3>${v.first}</h3>
		<h3>${v.begin}</h3>
		<h3>${v.end}</h3>
		<h3>${v.step}</h3>
		<!-- count : 1부터 순서
			 index : 0부터 순서 *(많이 씀)
			 first : 첫번째인지 여부(true, false) *
			 last  : 마지막인지 여부(true, false) 
			 begin : 시작번호 
			 end   : 끝번호
			 step  : 증가값
		 -->
	</c:forEach>
	<hr>
	<c:forEach items="${m}" var="n">
		<h1>${n}</h1>
		<h1>${n.value}</h1>
		<h3>${n.key}</h3>
	</c:forEach>
	
</body>
</html>