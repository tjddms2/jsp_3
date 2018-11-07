package com.sungeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se.action.ActionFoward;
import com.se.ajax.AjaxService;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("/AjaxController")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String command = request.getPathInfo();
	     ActionFoward actionForward = null;
	      
	      AjaxService ajaxService = new AjaxService();
	      if(command.equals("/memberCheckId.do")) {
	         actionForward = ajaxService.checkId(request, response);
	      }else if(command.equals("/memberCheckId2.do")) {
	         actionForward = ajaxService.checkId2(request, response);
	      }else if(command.equals("/memberInfo.do")) {
	         actionForward = ajaxService.memberInfo(request, response);
	      }else if(command.equals("/list.do")) {
	    	  actionForward = ajaxService.list(request, response);
	      }
	      
	      
	      if(actionForward.isCheck()) { //true일 때 forward
	         RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
	         view.forward(request, response);
	      }else { //false일 때 redirect
	         response.sendRedirect(actionForward.getPath());
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
