<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.se.file.FileDAO"%>
<%@page import="com.se.file.FilDTO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@page import="com.se.notice.NoticeDAO"%>
<%@page import="com.se.notice.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
     <%
  
  
     String path = request.getServletContext().getRealPath("upload");
     System.out.println(path);
     int max = 1024*1024*10;
     
     MultipartRequest multi = new MultipartRequest(request, path, max, "UTF-8", new DefaultFileRenamePolicy());
     
     // path 경로에 파일 업로드 끝
     NoticeDTO noticeDTO = new NoticeDTO();
     noticeDTO.setTitle(multi.getParameter("title"));
     noticeDTO.setContents(multi.getParameter("contents"));
     noticeDTO.setWriter(multi.getParameter("writer"));
     
     //파일의 정보
	FilDTO f1 = new FilDTO();
    f1.setfName(multi.getFilesystemName("f1"));
    f1.setoName(multi.getOriginalFileName("f1"));
    
    FilDTO f2 = new FilDTO();
    f2.setfName(multi.getFilesystemName("f2")); //파라미터의 이름
    f2.setoName(multi.getOriginalFileName("f2"));
    
  /*   file f =multi.getFile("f1");
    Enumeration e = multi.getFileNames(); //파라미커 명들*/
    
    NoticeDAO noticeDAO = new NoticeDAO();
    int num = noticeDAO.getNum();
    noticeDTO.setNum(num);
    int result = noticeDAO.insert(noticeDTO);
    
    f1.setNum(num);
    f2.setNum(num);
    f1.setKind("N");
    f2.setKind("N");
    
    FileDAO fileDAO = new FileDAO();
    fileDAO.insert(f1);
    fileDAO.insert(f2);
           
    
    String s ="Write fail";
    if(result>0){
    	s ="Write Success";
    }
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert('<%=s%>');
	location.href="./noticeList.jsp";
</script>
</head>
<body>

</body>
</html>