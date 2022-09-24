package com.kh.airschedule.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.airschedule.model.service.AirScheduleService;
import com.kh.airschedule.model.vo.AirSchedule;

/**
 * Servlet implementation class admin_addFlightController
 */
@WebServlet("/addFlight.ai")
public class admin_addFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_addFlightController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String flightNo = request.getParameter("flightNo");
		String airline = request.getParameter("airline");
		String depCode = request.getParameter("depCode");
		String depDate = request.getParameter("depDate");
		String depTime = request.getParameter("depTime");
		String arrivalCode = request.getParameter("arrivalCode");
		String arrivalDate = request.getParameter("arrivalDate");
		String arrivalTime = request.getParameter("arrivalTime");
		String wholeTime = request.getParameter("wholeTime");
		int price = Integer.parseInt(request.getParameter("price"));
		String nonstopFlightYn = request.getParameter("nonstopFlightYn");
		String transfer = request.getParameter("transfer");
		String waitingTime = request.getParameter("waitingTime");
		
		AirSchedule a = new AirSchedule();
		a.setFlightNo(flightNo);
		a.setAirline(airline);
		a.setDepCode(depCode);
		a.setDepDate(depDate);
		a.setDepTime(depTime);
		a.setArrivalCode(arrivalCode);
		a.setArrivalDate(arrivalDate);
		a.setArrivalTime(arrivalTime);
		a.setWholeTime(wholeTime);
		a.setPrice(price);
		a.setNonstopFlightYn(nonstopFlightYn);
		a.setTransfer(transfer);
		a.setWaitingTime(waitingTime);
		
		int result = new  AirScheduleService().addFlight(a);
		
		if(result > 0) {
			request.setAttribute("alertMsg", "성공적으로 추가되었습니다.");
			request.getRequestDispatcher("views/airschedule/admin_addFlightCompletePage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "추가 실패");
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