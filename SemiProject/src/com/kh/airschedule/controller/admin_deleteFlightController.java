package com.kh.airschedule.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.airschedule.model.service.AirScheduleService;

/**
 * Servlet implementation class admin_deleteFlightController
 */
@WebServlet("/deleteFlight.ai")
public class admin_deleteFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_deleteFlightController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String flightNo = request.getParameter("flightNo");
		String depDate = request.getParameter("depDate");
		
		int result = new AirScheduleService().deleteFlight(flightNo, depDate);
		
		if(result > 0) {
			request.setAttribute("alertMsg", "성공적으로 삭제되었습니다.");
			request.getRequestDispatcher("views/airschedule/admin_deleteFlightCompletePage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "삭제 실패");
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