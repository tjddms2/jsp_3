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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionFoward delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
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
