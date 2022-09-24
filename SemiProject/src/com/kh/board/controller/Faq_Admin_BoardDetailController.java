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
 * Servlet implementation class Faq_Admin_BoardDetailController
 */
@WebServlet("/detail.bo")
public class Faq_Admin_BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Faq_Admin_BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNo = Integer.parseInt( request.getParameter("bno"));
		
		Faq_BoardService bs=new Faq_BoardService();
		Board b = bs.selectBoard(boardNo);
		
		request.setAttribute("b", b);
		
		request.getRequestDispatcher("views/faq/admin_faqMainDetailView.jsp").forward(request, response);
	
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
