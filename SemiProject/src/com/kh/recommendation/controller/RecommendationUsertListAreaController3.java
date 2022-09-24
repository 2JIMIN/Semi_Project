package com.kh.recommendation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.PageInfo;
import com.kh.recommendation.model.service.RecommendationService;
import com.kh.recommendation.model.vo.Recommendation;

/**
 * Servlet implementation class RecommendationUsertListAreaController3
 */
@WebServlet("/listArea3.re")
public class RecommendationUsertListAreaController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendationUsertListAreaController3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리
		int listCount;	 //현재 총 게시글 개수
		int currentPage; //현재 페이지(사용자가 요청한 페이지)
		int pageLimit;	 //페이지 하단에 보이는 페이지 페이징 최대 개수
		int boardLimit;	 //한 페이지에서 보여질 게시글 개수
		
		int maxPage;	 //가장 마지막 페이지가 몇번페이지인지 (총 페이지수)
		int startPage;	 //페이지 하단에 보여질 페이징 시작 수 
		int endPage; 	 //페이지 하단에 보여질 페이징 끝 수 
		
		listCount = new RecommendationService().listCount();
		currentPage = Integer.parseInt(request.getParameter("kpage"));
		pageLimit = 5;
		boardLimit = 10;
		
		maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		startPage = (currentPage-1)/pageLimit * pageLimit + 1;
		endPage = startPage+pageLimit - 1;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit
				,maxPage,startPage,endPage);
		
		ArrayList<Recommendation>list = new RecommendationService().listArea3(pi);
		
		//이미지주소 추출용 변수
		int startIndex;
		int endIndex;
		String content2 = "";
		
		if(!list.isEmpty()) {
			for(int i =0; i<list.size(); i++) {
				startIndex = list.get(i).getBoardContent().indexOf("/KGG/");
				if(startIndex!=-1) {
					content2 = list.get(i).getBoardContent().substring(startIndex);
					endIndex = content2.indexOf("\" title=\"");
					
					list.get(i).setThumbnailRoot(content2.substring(0,endIndex));
				}
			}
		}
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/recommendation/user_recListArea3.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
