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
 * Servlet implementation class Faq_Admin_BoardUpdateController
 */
@WebServlet("/update.bo")
public class Faq_Admin_BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Faq_Admin_BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int faqNo = Integer.parseInt(request.getParameter("bno"));
		int categoryNo = Integer.parseInt(request.getParameter("category"));
		String faqTitle=request.getParameter("title");
		String faqContent = request.getParameter("content");
		
		Board b = new Board();
		b.setFaqNo(faqNo);
		b.setCategoryNo(categoryNo);
		b.setFaqTitle(faqTitle);
		b.setFaqContent(faqContent);
		
		
		int result = new Faq_BoardService().updateBoard(b);
		if(result>0){//성공
			request.getSession().setAttribute("alertMsg", "게시글 수정 성공!!");
			response.sendRedirect(request.getContextPath()+"/faqmain.fm");
		}else {
			request.setAttribute("errorMsg", "게시글 수정 실패"); 
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
