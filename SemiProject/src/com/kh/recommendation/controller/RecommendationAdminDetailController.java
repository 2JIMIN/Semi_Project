package com.kh.recommendation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.quarantine.model.service.QuarantineService;
import com.kh.quarantine.model.vo.Quarantine;
import com.kh.recommendation.model.service.RecommendationService;
import com.kh.recommendation.model.vo.Recommendation;

/**
 * Servlet implementation class RecommendationAdminDetailController
 */
@WebServlet("/adDetail.re")
public class RecommendationAdminDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationAdminDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("bno");
		
		if(boardNo!=null) { //성공시
			// 상세조회
			Recommendation r = new RecommendationService().selectDetail(boardNo);
			//System.out.println(r);
			request.setAttribute("recommendation", r);
			request.getRequestDispatcher("views/recommendation/admin_recDetailView.jsp").forward(request, response);
		} else { //실패시 에러페이지로 보내기
			request.setAttribute("errorMsg","게시글 조회 실패");
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
