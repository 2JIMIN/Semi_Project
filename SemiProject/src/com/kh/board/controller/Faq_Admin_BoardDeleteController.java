package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.Faq_BoardService;

/**
 * Servlet implementation class FAq_Admin_BoardDeleteController
 */
@WebServlet("/delete.bo")
public class Faq_Admin_BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Faq_Admin_BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int faqNo = Integer.parseInt(request.getParameter("bno"));
		
		int result = new Faq_BoardService().deleteBoard(faqNo);
		if(result>0){//성공
			request.getSession().setAttribute("alertMsg", "게시글 삭제 성공!!");
			response.sendRedirect(request.getContextPath()+"/faqmain.fm");
		}else {
			request.setAttribute("errorMsg", "게시글 삭제 실패"); 
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
