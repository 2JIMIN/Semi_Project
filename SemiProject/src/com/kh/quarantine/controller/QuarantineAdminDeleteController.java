package com.kh.quarantine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.quarantine.model.service.QuarantineService;

/**
 * Servlet implementation class QuarantineAdminDeleteController
 */
@WebServlet("/adDelete.qu")
public class QuarantineAdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuarantineAdminDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryCode = request.getParameter("ccode");
		
		int result = new QuarantineService().deleteQuarantineInfo(countryCode);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "방역 정보 삭제 성공");
			response.sendRedirect(request.getContextPath()+"/adList.qu?kpage=1"); 
		}else {
			request.setAttribute("errorMsg", "방역 정보 삭제 실패");
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
