package com.se.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.se.action.ActionFoward;
import com.se.board.BoardDTO;
import com.se.member.MemberDAO;
import com.se.member.MemberDTO;
import com.se.memo.MemoDAO;
import com.se.notice.NoticeDAO;
import com.se.page.RowNumber;
import com.se.page.Search;

import jdk.nashorn.internal.runtime.JSErrorType;


public class AjaxService {

	public ActionFoward list(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward =new ActionFoward();
		NoticeDAO noticeDAO = new NoticeDAO();
		RowNumber rowNumber = new RowNumber();
		rowNumber.setStartRow(1);
		rowNumber.setLastRow(10);
		rowNumber.setSearch(new Search());
		List<BoardDTO> ar= null;
		try {
			ar= noticeDAO.selectList(rowNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jr = new JSONArray();
		for(BoardDTO boardDTO:ar) {
			JSONObject js = new JSONObject();
			js.put("num", boardDTO.getNum());
			js.put("title", boardDTO.getTitle());
			js.put("writer", boardDTO.getWriter());
			jr.add(js);
			request.setAttribute("message", jr.toJSONString()); // 전체를 하나의문장으로 만들어서 보냄
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		}
		
		
		
		return actionFoward;
	}
	public ActionFoward memberInfo(HttpServletRequest request, HttpServletResponse response) {
		//id, pw, kind
		//memberDAO login 메서드 호출
		//id, name, email JSON 출력
		
	MemberDTO memberDTO =new MemberDTO();
	memberDTO.setId(request.getParameter("id"));
	memberDTO.setPw(request.getParameter("pw"));
	memberDTO.setKind(request.getParameter("kind"));
	MemberDAO memberDAO = new MemberDAO();
	try {
		memberDTO = memberDAO.login(memberDTO);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", memberDTO.getId());
		jsonObject.put("name", memberDTO.getName());
		jsonObject.put("email", memberDTO.getEmail());
		
		request.setAttribute("message", jsonObject.toJSONString());
		ActionFoward actionFoward = new ActionFoward();
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		return actionFoward;
	}
	//{}
	public ActionFoward checkId2(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		MemoDAO memoDAO = new MemoDAO();
		String id = request.getParameter("id");
		
		boolean result= true; //boolean: 1) true- foward  2) false-redirect로 쓰임
		
		try {
			result = memoDAO.checkId(id);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String message="1"; //불가능
		if(result) {
			message="2";    //가능
		}
		String j = "{\"result\":\""+message+"\",\"m\":\"v\"}";
		
		request.setAttribute("message", j);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		
		return actionFoward;
	}
		public ActionFoward checkId(HttpServletRequest request , HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		MemoDAO memoDAO = new MemoDAO();
		String id = request.getParameter("id");
		boolean result =true;
		
		try {
			result =memoDAO.checkid(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		String message="1";
		if(result) {
			message="2";
		}
		
		String j = "{\"result\":\""+message+"\", \"m\":\"v\"}";
		
		request.setAttribute("message", j);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		
		return actionFoward;
		
		
		
		
		return actionFoward;
	}
}
