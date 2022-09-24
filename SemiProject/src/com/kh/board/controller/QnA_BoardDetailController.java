package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.QnA_BoardService;
import com.kh.board.model.vo.QnA_Board;
import com.kh.board.model.vo.Reply;

/**
 * Servlet implementation class QnA_BoardDetailController
 */
@WebServlet("/detail.qo")
public class QnA_BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnA_BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("qno"));
		QnA_Board b = new QnA_BoardService().selectBoard(boardNo);
		
		request.setAttribute("b", b);
		
		int boardNo2 = b.getBoardNo();
		ArrayList<Reply> list = new QnA_BoardService().selectReplyList(boardNo2);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/qna/user_qnaDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
