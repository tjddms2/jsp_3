package com.se.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se.action.ActionFoward;
import com.se.board.BoardDTO;
import com.se.file.FilDTO;
import com.se.file.FileDAO;
import com.se.page.MakePager;
import com.se.page.Pager;
import com.se.page.RowNumber;

public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
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
			request.setAttribute("list", ar);
			request.setAttribute("pager", pager);
			actionFoward.setPath("../WEB-INF/notice/noticeList.jsp");
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
			actionFoward.setPath("../WEB-INF/notice/noticeSelectOne.jsp");
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
