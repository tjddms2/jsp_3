package com.se.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.se.action.ActionFoward;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService(){
		memberDAO = new MemberDAO();			
	}
	
	//join
	public ActionFoward join(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		if(method.equals("POST")) {
			
			
		int max= 1024*1024*10;
		String path = request.getServletContext().getRealPath("upload");
		File file = new File(path);
		if(!file.exists()) {
				file.mkdirs();
		}
			try {
				
				//파일저장
				MultipartRequest multi = new MultipartRequest(request, path, max, "UTF-8", new DefaultFileRenamePolicy());
				//Member Data
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(multi.getParameter("id"));
				memberDTO.setPw(multi.getParameter("pw"));
				memberDTO.setName(multi.getParameter("name"));
				memberDTO.setEmail(multi.getParameter("email"));
				memberDTO.setKind(multi.getParameter("kind"));
				memberDTO.setClassMate(multi.getParameter("classMate"));
				/*
				 *  파일의 정보를 DTO에 추가  
				 * 
				 */
				int result = memberDAO.join(memberDTO);
				if(result>0) {
					request.setAttribute("message", "Join Success");
					request.setAttribute("path", "../index.jsp");
				}else {
					request.setAttribute("message", "Join Fail");
					request.setAttribute("path", "./memberJoin.do");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}else {
				
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberJoin.jsp");
			}
		return actionFoward;
	
		}
	
}