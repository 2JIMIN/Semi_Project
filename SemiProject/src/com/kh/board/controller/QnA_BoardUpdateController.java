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
 * Servlet implementation class QnA_BoardUpdateController
 */
@WebServlet("/update.qo")
public class QnA_BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnA_BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("qno"));
		int rnum = Integer.parseInt(request.getParameter("rno"));
		int categoryNo = Integer.parseInt(request.getParameter("category"));
		String boardTitle=request.getParameter("title");
		String boardContent = request.getParameter("content");
		
//		System.out.println(boardNo);
//		System.out.println(categoryNo);
//		System.out.println(boardTitle);
//		System.out.println(boardContent);
		
		QnA_Board b = new QnA_Board();
		b.setBoardNo(boardNo);
		b.setCategoryNo(categoryNo);
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		
		int result = new QnA_BoardService().updateBoard(b);
		
		if(result>0){//성공
			request.getSession().setAttribute("alertMsg", "게시글 수정 성공!!");
			response.sendRedirect(request.getContextPath()+"/detail.qo?qno="+rnum);
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
