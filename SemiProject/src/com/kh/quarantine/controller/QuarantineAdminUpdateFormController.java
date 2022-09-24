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
 * Servlet implementation class QuarantineAdminUpdateFormController
 */
@WebServlet("/adUpdateForm.qu")
public class QuarantineAdminUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuarantineAdminUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클릭했을때 국가코드를 가져올것
		String countryCode = request.getParameter("ccode");
		
		// 방역정보가져오는 메소드
		Quarantine q = new QuarantineService().adminSelectInfo(countryCode);
		
		request.setAttribute("q", q);
		request.getRequestDispatcher("views/quarantine/admin_quarantineUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
