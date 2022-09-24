package com.kh.recommendation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recommendation.model.service.RecommendationService;
import com.kh.recommendation.model.vo.Recommendation;

/**
 * Servlet implementation class RecommendationAdminUpdateFormController
 */
@WebServlet("/adUpdateForm.re")
public class RecommendationAdminUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationAdminUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클릭했을때 게시글번호를 가져올것
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		// 글정보 가져오는 메소드
		Recommendation r = new RecommendationService().adminSelectBoard(boardNo);
		
		// 국가정보 가져오기
		ArrayList<Recommendation> list = new RecommendationService().registerRecommendationCountryList();	
		
		//System.out.println(r);
		//System.out.println(list);
		
		request.setAttribute("r", r);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/recommendation/admin_recUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
