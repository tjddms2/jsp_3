package com.se.notice;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.se.action.ActionFoward;
import com.se.board.BoardDTO;
import com.se.board.BoardService;
import com.se.file.FilDTO;
import com.se.file.FileDAO;
import com.se.page.MakePager;
import com.se.page.Pager;
import com.se.page.RowNumber;


public class NoticeService implements BoardService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	@Override
	public ActionFoward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		String method = request.getMethod();
		if(method.equals("POST")) {
			String message="fail";
			String path="./noticeList.do";
			//파일의 크기 byte
			int maxSize = 1024*1024*10;
			//파일의 저장공간
			String save = request.getServletContext().getRealPath("upload");
			System.out.println(save);
			File file =new File(save);
			if(!file.exists()) {
				file.mkdirs();
				
			}
			try {
				MultipartRequest multi = new MultipartRequest(request, save, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setTitle(request.getParameter("title"));
				noticeDTO.setWriter(request.getParameter("writer"));
				noticeDTO.setContents(request.getParameter("contents"));
				noticeDTO.setNum(noticeDAO.getNum());
				int result = noticeDAO.insert(noticeDTO);
				
			if(result>0) {
					FileDAO fileDAO = new FileDAO();
					//파일의 파라미터 명을 모은 것
					Enumeration<Object> e =multi.getFileNames();
				while(e.hasMoreElements()) {
					String p =(String)e.nextElement();
					FilDTO filDTO = new FilDTO();
					filDTO.setKind("N");
					filDTO.setNum(noticeDTO.getNum());
					filDTO.setfName(multi.getFilesystemName(p));
					filDTO.setoName(multi.getOriginalFileName(p));
					fileDAO.insert(filDTO);
					
				}
				
					message="Success";
					actionFoward.setCheck(true);
					actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}else {
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/viwq/common/result.jsp");
			}
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
			request.setAttribute("message", message);
			request.setAttribute("path", path);
			
		}else {
			request.setAttribute("board", "notice");
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/board/boardWrite.jsp");
		
		
		}
		
		return actionFoward;
	}

	@Override
	public ActionFoward update(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			//DB Update
			int max=1024*1024*10;
			String path = request.getServletContext().getRealPath("upload");
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs();
			}		
			try {
				MultipartRequest multi = new MultipartRequest(request, path, max,"UTF-8", new DefaultFileRenamePolicy());
				NoticeDTO noticeDTO = new NoticeDTO();
				noticeDTO.setNum(Integer.parseInt(multi.getParameter("num")));
				noticeDTO.setTitle(request.getParameter("title"));
				noticeDTO.setContents(request.getParameter("contents"));
				
				//update
				int result = noticeDAO.update(noticeDTO);
				if(result>0) {//파일을 집어넣는 실행을 하겠다
					 Enumeration<Object> e = multi.getFileNames();
					 FileDAO fileDAO = new FileDAO();
					 while(e.hasMoreElements()) {
						 FilDTO filDTO = new FilDTO();
						 String key = (String)e.nextElement();
					filDTO.setoName(multi.getOriginalFileName(key));   //return으로 오리지날이 나온다.
					filDTO.setfName(multi.getFilesystemName(key));
					filDTO.setKind("N");
					filDTO.setNum(noticeDTO.getNum());
					fileDAO.insert(filDTO);
					}//while의 끝
					 request.setAttribute("message", "updateSuccess");
					 request.setAttribute("path", "./noticeList.do");
				}else {
					//update fail
					request.setAttribute("message", "updateFail");
					request.setAttribute("path", "./noticeList.do");
				}
				
			} catch (Exception e) {
				request.setAttribute("message", "updateFail");
				request.setAttribute("path", "./noticeList.do");
				e.printStackTrace();
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}else {
			
			//form
			try {
				int num =Integer.parseInt(request.getParameter("num"));
				BoardDTO boardDTO = noticeDAO.selectOne(num);
				FileDAO fileDAO = new FileDAO();
				FilDTO filDTO = new FilDTO();
				filDTO.setNum(num);
				filDTO.setKind("N");
				List<FilDTO> ar = fileDAO.selectList(filDTO);
			
				fileDAO.selectList(filDTO);
				request.setAttribute("dto", boardDTO);
				request.setAttribute("files", ar);
				request.setAttribute("board", "notice");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/board/boardUpdate.jsp");
			}catch(Exception e) {
				
			}
		}
		
		return null;
	}

	@Override
	public ActionFoward delete(HttpServletRequest request, HttpServletResponse response) {
		
		ActionFoward actionFoward = new ActionFoward();
		
		
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			FileDAO fileDAO =new FileDAO();
			fileDAO.deleteAll(num);
			
			num = noticeDAO.delete(num);
			if(num>0) {
				 request.setAttribute("message", "DelteSuccess");
				 request.setAttribute("path", "./noticeList.do");
			}else {
				 request.setAttribute("message", "DelteFail");
				 request.setAttribute("path", "./noticeList.do");
			}
		} catch (Exception e) {
			 request.setAttribute("message", "DelteFail");
			 request.setAttribute("path", "./noticeList.do");
			e.printStackTrace();
		}
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		return actionFoward;
	}

	//selectList
	public ActionFoward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		int curPage=1;
		try {
				curPage = Integer.parseInt(request.getParameter("curPage"));
				
		}catch(Exception e){
			// TODO: handle exception
		}
		String kind = request.getParameter("kind");
		String search = request.getParameter("search"); 		//kind, search 찾아오기
		
		MakePager mk = new MakePager(curPage, search, kind);   //호출
		RowNumber rowNumber = mk.makeRow();
		
		try {
			List<BoardDTO>	ar = noticeDAO.selectList(rowNumber);
			int totalCount = noticeDAO.getCount(rowNumber.getSearch());
			Pager pager = mk.makePage(totalCount);		
			request.setAttribute("list", ar);							//속성추가
			request.setAttribute("pager", pager);
			request.setAttribute("board", "notice");
			actionFoward.setPath("../WEB-INF/view/board/boardList.jsp");
		} catch (Exception e) {
			request.setAttribute("message", "fail");
			request.setAttribute("path", "../index.jsp");
			actionFoward.setPath("../WEB-INF/common/result.jsp");
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		
		return actionFoward;
	}
	
	//selectOne
	public ActionFoward selectOne(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		BoardDTO boardDTO = null;
		
		try {
			int num= Integer.parseInt(request.getParameter("num"));  //익센션 발생할수 있어서 try 안에 넣기
			boardDTO = noticeDAO.selectOne(num);
			FileDAO fileDAO = new FileDAO();
			FilDTO filDTO = new FilDTO();
			filDTO.setNum(num);
			filDTO.setKind("N");
			List<FilDTO> ar = fileDAO.selectList(filDTO);
			request.setAttribute("dto", boardDTO);
			request.setAttribute("files", ar);
				actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/board/boardSelectOne.jsp");
		} catch (Exception e) {
			actionFoward.setCheck(false);
			actionFoward.setPath("./noticeList.do");
			e.printStackTrace();
		}
		
		if(boardDTO == null) {
			actionFoward.setCheck(false);
			actionFoward.setPath("./noticeList.do");
			
		}
		
		return actionFoward;
	}
	
}
