package com.se.memo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se.action.ActionFoward;
import com.se.page.MakePager;
import com.se.page.RowNumber;

public class MemoService {
	
	private MemoDAO memoDAO;
	
	public MemoService() {
		memoDAO = new MemoDAO();
	}
	//delete
	public ActionFoward delete(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String [] nums= request.getParameterValues("num");
		
		int num=0;
		MemoDAO memoDAO = new MemoDAO();
		for(String s : nums) {
			
			try {	//몇번 지워지는가?
				num= Integer.parseInt(s);
				num = memoDAO.delete(num);
			}catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		request.setAttribute("message", num);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		return actionFoward;
	}
	
	//insert
	public ActionFoward insert(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setContents(request.getParameter("contents"));
		memoDTO.setWriter(request.getParameter("writer"));
		try {
			int result = memoDAO.insert(memoDTO);
			String message = "fail";
			if(result>0) {
				message="Success";
			}
			request.setAttribute("message", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/resultAjax.jsp");
		return actionFoward;
	}
	
	
	
	public ActionFoward selectList(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		//1.curPage
		//2.kind,search
		
		int curPage=1;
				
		try {		
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}catch(Exception e){
			
		}
		MakePager makePager = new MakePager(curPage, "", "");
		RowNumber rowNumber = makePager.makeRow();
		try {
			List<MemoDTO> ar= memoDAO.selectList(rowNumber);
			request.setAttribute("list", ar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path=request.getPathInfo();
		
	//memoList.do -> path : MemoList.jsp
		/*path = path.substring(0, path.lastIndexOf("."));  //lastIndexof : 마지막꺼 찾는것*/
	//memoMore.do -> path : MemoMore.jsp
		
		/*path = path+".jsp";*/
		path =path.replace(".do", ".jsp");   //바꾸는 방식이 다를수 있다.
		actionFoward.setCheck(true);
		actionFoward.setPath("./WEB-INF/view/memo"+path);
		
		return actionFoward;
	}
}
