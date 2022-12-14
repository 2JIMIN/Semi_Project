package com.kh.airschedule.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.airschedule.model.service.AirScheduleService;
import com.kh.airschedule.model.vo.AirSchedule;

/**
 * Servlet implementation class admin_updateFlightController
 */
@WebServlet("/updateFlight.ai")
public class admin_updateFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_updateFlightController() {
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
		String depTime = request.getParameter("depTime");
		String arrivalDate = request.getParameter("arrivalDate");
		String arrivalTime = request.getParameter("arrivalTime");
		int price = Integer.parseInt(request.getParameter("price"));
		
		AirSchedule a = new AirSchedule();
		a.setDepDate(depDate);
		a.setDepTime(depTime);
		a.setArrivalDate(arrivalDate);
		a.setArrivalTime(arrivalTime);
		a.setPrice(price);
		
		int result = new AirScheduleService().updateFlight(flightNo, a);
		
		if(result > 0) {
			request.setAttribute("alertMsg", "성공적으로 변경되었습니다.");
			request.getRequestDispatcher("views/airschedule/admin_updateFlightCompletePage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "변경 실패");
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