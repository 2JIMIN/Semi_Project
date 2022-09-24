package com.kh.quarantine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.quarantine.model.service.QuarantineService;
import com.kh.quarantine.model.vo.Quarantine;

/**
 * Servlet implementation class QuarantineAdminDetailController
 */
@WebServlet("/adDetail.qu")
public class QuarantineAdminDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuarantineAdminDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryCode = request.getParameter("ccode");
		
		if(countryCode!=null) { //성공시
			// 상세조회
			Quarantine q = new QuarantineService().selectDetail(countryCode);
			//System.out.println(q);
			request.setAttribute("quarantine", q);
			request.getRequestDispatcher("views/quarantine/admin_quarantineDetailView.jsp").forward(request, response);
		} else { //실패시 에러페이지로 보내기
			request.setAttribute("errorMsg","등록정보 조회 실패");
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
