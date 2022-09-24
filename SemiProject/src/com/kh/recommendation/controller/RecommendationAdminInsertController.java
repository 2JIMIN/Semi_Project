package com.kh.recommendation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.recommendation.model.service.RecommendationService;
import com.kh.recommendation.model.vo.Recommendation;

/**
 * Servlet implementation class RecommendationAdminInsertController
 */
@WebServlet("/adInsert.re")
public class RecommendationAdminInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationAdminInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    String countryCode = request.getParameter("cCode");
	    String boardTitle = request.getParameter("title");
	    String boardContent = request.getParameter("content");
	    

		Recommendation r = new Recommendation();
		r.setCountryCode(countryCode);
		r.setBoardTitle(boardTitle);
		r.setBoardContent(boardContent);
		
//		System.out.println(r);
		
		int result = new RecommendationService().adInsertBoard(r);
			
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "게시글 작성 성공");
			response.sendRedirect(request.getContextPath()+"/adList.re?kpage=1");
		}else {
			request.setAttribute("errorMsg","게시글 작성 실패");
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
