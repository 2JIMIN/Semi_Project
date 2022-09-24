package com.kh.quarantine.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userQuarantineInfoController
 */
@WebServlet("/userQuarantineInfoDetail.qu")
public class QuarantineInfoDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuarantineInfoDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String arrivalCity = request.getParameter("arrivalCity");
		String countryKor = request.getParameter("countryKor");
		String countryEng = request.getParameter("countryEng");
		String depVyPcr = request.getParameter("depVyPcr");
		String depVnPcr = request.getParameter("depVnPcr");
		String arrVyPcr = request.getParameter("arrVyPcr");
		String arrVnPcr = request.getParameter("arrVnPcr");
		String arrVySelf = request.getParameter("arrVySelf");
		String arrVnSelf = request.getParameter("arrVnSelf");
				
		request.setAttribute("arrivalCity", arrivalCity);
		request.setAttribute("countryKor", countryKor);
		request.setAttribute("countryEng", countryEng);
		request.setAttribute("depVyPcr", depVyPcr);
		request.setAttribute("depVnPcr", depVnPcr);
		request.setAttribute("arrVyPcr", arrVyPcr);
		request.setAttribute("arrVnPcr", arrVnPcr);
		request.setAttribute("arrVySelf", arrVySelf);
		request.setAttribute("arrVnSelf", arrVnSelf);
		
		request.getRequestDispatcher("views/international/userQuarantineInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}