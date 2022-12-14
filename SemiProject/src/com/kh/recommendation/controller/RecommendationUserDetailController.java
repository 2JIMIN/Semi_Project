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
 * Servlet implementation class RecommendationUserDetailController
 */
@WebServlet("/detail.re")
public class RecommendationUserDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationUserDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		//조회수 증가 // 게시글 조회(board) // 첨부파일 조회(attachment)
		
		RecommendationService rs = new RecommendationService();
		
		//조회수 증가 결과
		int result = rs.increaseCount(boardNo);
		//만약 조회수 증가 결과가 0(실패)면 나머지 처리도 해주면 안되니까 조건으로 사용 
		if(result > 0) { //성공시 (유효한 게시글일경우) 게시글,첨부파일 조회 후 상세조회 페이지로 이동 
			
			Recommendation r = rs.selectBoard(boardNo);
			
//			System.out.println(r);
			
			request.setAttribute("r", r);
			
			request.getRequestDispatcher("views/recommendation/user_recDetailView.jsp").forward(request, response);
	
			}else {//실패시
			request.setAttribute("errorMsg", "게시글 상세조회 실패");
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
