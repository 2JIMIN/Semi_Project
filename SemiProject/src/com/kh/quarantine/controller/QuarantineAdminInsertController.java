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
 * Servlet implementation class QuarantineAdminInsertController
 */
@WebServlet("/adInsert.qu")
public class QuarantineAdminInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuarantineAdminInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String countryCode = request.getParameter("cCode");
		String depVyPcr = request.getParameter("depVyPcr");
		String depVnPcr = request.getParameter("depVnPcr");
		String arrVyPcr = request.getParameter("arrVyPcr");
		String arrVnPcr = request.getParameter("arrVnPcr");
		String arrVySelf = request.getParameter("arrVySelf");
		String arrVnSelf = request.getParameter("arrVnSelf");
		
		Quarantine q = new Quarantine();
		q.setCountryCode(countryCode);
		q.setDepVyPcr(depVyPcr);
		q.setDepVnPcr(depVnPcr);
		q.setArrVyPcr(arrVyPcr);
		q.setArrVnPcr(arrVnPcr);
		q.setArrVySelf(arrVySelf);
		q.setArrVnSelf(arrVnSelf);
		
		int result = new QuarantineService().insertQuarantine(q);
		
		if(result>0) { //성공시 리스트페이지 출력
			request.getSession().setAttribute("alertMsg", "방역정보 등록 완료");
			response.sendRedirect(request.getContextPath()+"/adList.qu?kpage=1");
		}else { //실패시 오류페이지 출력
			request.setAttribute("errorMsg", "방역정보 등록 실패");
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
