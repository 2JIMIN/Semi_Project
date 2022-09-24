package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.QnA_BoardService;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.QnA_Board;

/**
 * Servlet implementation class QnA_BoardUpdateFormController
 */
@WebServlet("/updateForm.qo")
public class QnA_BoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnA_BoardUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QnA_BoardService bs = new QnA_BoardService();
		int boardNo = Integer.parseInt(request.getParameter("qno"));
		
		QnA_Board b = new QnA_BoardService().selectBoard(boardNo);
		
		ArrayList<Category> qlist = bs.selectCategoryList();
		
		request.setAttribute("qlist", qlist);
		request.setAttribute("b", b);
		
		request.getRequestDispatcher("views/qna/user_qnaUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
