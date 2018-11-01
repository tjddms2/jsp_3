package com.se.member;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.se.action.ActionFoward;
import com.sun.accessibility.internal.resources.accessibility;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService(){
		memberDAO = new MemberDAO();			
	}
	//myPage
	public ActionFoward myPage(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward= new ActionFoward();
		
		actionFoward.setCheck(true);
		actionFoward.setPath("./WEB-INF/view/member/memberList.do?");
		
		return actionFoward;
	}
	
	//logout
	public ActionFoward logout(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward= new ActionFoward();
		
		HttpSession session= request.getSession();
		session.invalidate(); //시간을 삭제
		
		actionFoward.setCheck(false); 
		actionFoward.setPath("../index.jsp");
		
		return actionFoward;
	}
	
	//login
	public ActionFoward login(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		String method= request.getMethod();
		
		if(method.equals("POST")) {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(request.getParameter("id"));
		memberDTO.setPw(request.getParameter("pw"));
		memberDTO.setKind(request.getParameter("kind"));
		
		try {
			memberDTO = memberDAO.login(memberDTO);
		
		} catch (Exception e) {
			memberDTO = null;
			e.printStackTrace();
		}
		if(memberDTO!=null) {	//member not null이라면
			HttpSession session = request.getSession();	//리턴이 session
			session.setAttribute("member", memberDTO);
			actionFoward.setCheck(false);	//부정을  하면 리다이넥트로 갈수있음!
			actionFoward.setPath("../index.jsp"); //리다이넥트의 경로
		}else {
			request.setAttribute("message", "login Fail");
			actionFoward.setCheck(true); 
			actionFoward.setPath("../WEB-INF/view/member/memberLogin.jsp");
		}
		}else {//get
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberLogin.jsp");
		}
		return actionFoward;
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
				memberDTO.setFname(multi.getFilesystemName("fName"));
				memberDTO.setOname(multi.getOriginalFileName("oName"));
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