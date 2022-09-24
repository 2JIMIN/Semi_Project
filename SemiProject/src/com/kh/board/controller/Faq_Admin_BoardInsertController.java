package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.Faq_BoardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class Faq_Admin_BoardInsertController
 */
@WebServlet("/insert.bo")
public class Faq_Admin_BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Faq_Admin_BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int category =Integer.parseInt( request.getParameter("category"));
		String faqTitle = request.getParameter("title");
		String faqContent = request.getParameter("content");
		Board b = new Board(category,faqTitle,faqContent);
		

		int result = new Faq_BoardService().insertBoard(b);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "등록완료");
			response.sendRedirect(request.getContextPath()+"/faqmain.fm");
		}else {
			
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
