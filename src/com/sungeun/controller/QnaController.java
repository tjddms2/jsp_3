package com.sungeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.se.action.ActionFoward;
import com.se.qna.QnaService;

/**
 * Servlet implementation class QnaController
 */
@WebServlet("/QnaController")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QnaService qnaService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaController() {
        super();
        qnaService = new QnaService();
      
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String board = config.getInitParameter("board");
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board = this.getServletConfig().getInitParameter("board");
		System.out.println(board);
		String command = request.getPathInfo();
		
		ActionFoward actionFoward = null;
		
		if(command.equals("/qnaList.do")) {
			actionFoward =  qnaService.selectList(request, response);
		}else if(command.equals("/qnaSelectOne.do")) {
			actionFoward= qnaService.selectOne(request, response);
			}else if(command.equals("/qnaWrite.do")) {
			actionFoward = qnaService.insert(request, response);
		}
		
		if(actionFoward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionFoward.getPath());
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
