package com.kh.recommendation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recommendation.model.service.RecommendationService;
import com.kh.recommendation.model.vo.Recommendation;

/**
 * Servlet implementation class RecommendationAdminUpdateController
 */
@WebServlet("/adUpdate.re")
public class RecommendationAdminUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationAdminUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		
		Recommendation r = new Recommendation();
		r.setBoardNo(boardNo);
		r.setBoardTitle(boardTitle);
		r.setBoardContent(boardContent);
		
		//System.out.println(r);
		
		int result = new RecommendationService().updateRecommendationBoard(r);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "게시글 수정 완료");
			response.sendRedirect(request.getContextPath()+"/adDetail.re?bno="+boardNo); 
		}else {
			request.setAttribute("errorMsg", "게시글 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

}
