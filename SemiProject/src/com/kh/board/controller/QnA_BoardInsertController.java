package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.QnA_BoardService;
import com.kh.board.model.vo.QnA_Board;

/**
 * Servlet implementation class Qna_BoardInsertController
 */
@WebServlet("/insert.qo")
public class QnA_BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnA_BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String category = request.getParameter("category");
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		String boardWriter = request.getParameter("userNo");
		
		QnA_Board b = new QnA_Board();
		b.setCategory(category);
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardWriter(boardWriter);
		
		int result = new QnA_BoardService().insertBoard(b);
		System.out.println(result);
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "작성 성공");
			response.sendRedirect(request.getContextPath()+"/list.qo?kpage=1");
		}else {
			request.setAttribute("errorMsg", "작성 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
