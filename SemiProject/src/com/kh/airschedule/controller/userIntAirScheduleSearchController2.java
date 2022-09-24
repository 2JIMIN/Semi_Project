package com.kh.airschedule.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.airschedule.model.service.AirScheduleService;
import com.kh.airschedule.model.vo.AirSchedule;

/**
 * Servlet implementation class UserAirScheduleSearchController2
 */
@WebServlet("/search2.ai")
public class userIntAirScheduleSearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userIntAirScheduleSearchController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String flightNo = request.getParameter("flightNo");
		String userNo = request.getParameter("userNo");
		String ticket = request.getParameter("ticket");
		String depTime = request.getParameter("depTime");
		String arrivalTime = request.getParameter("arrivalTime");
		String price = request.getParameter("price");
		String airline = request.getParameter("airline");
		String depCode = request.getParameter("depCode");
		String arrivalCode = request.getParameter("arrivalCode");
		String depCity = request.getParameter("depCity");
		String arrivalCity = request.getParameter("arrivalCity");
		String depDate = request.getParameter("depDate");
		String comingDate = request.getParameter("comingDate");
		String person = request.getParameter("person");
		String classtype = request.getParameter("classtype");
		String classType = request.getParameter("classType");
		
		if(ticket!=null && ticket.equals("round")) {
			ArrayList<AirSchedule> list = new AirScheduleService().searchFlight(arrivalCity, depCity, comingDate);
			
			request.setAttribute("onewayFlightNo", flightNo);
			request.setAttribute("onewayDepTime", depTime);
			request.setAttribute("onewayArrivalTime", arrivalTime);
			request.setAttribute("onewayPrice", price);
			request.setAttribute("onewayAirline", airline);
			request.setAttribute("onewayDepCode", depCode);
			request.setAttribute("onewayArrivalCode", arrivalCode);
			request.setAttribute("onewayDepCity", depCity);
			request.setAttribute("onewayArrivalCity", arrivalCity);
			request.setAttribute("onewayDepDate", depDate);
			
			request.setAttribute("list", list);
			request.setAttribute("depCity", arrivalCity);
			request.setAttribute("arrivalCity", depCity);
			request.setAttribute("person", person);
			request.setAttribute("classType", classType);
			request.setAttribute("classtype", classtype);
			request.setAttribute("depDate", depDate);
			request.setAttribute("comingDate", comingDate);
			
			request.getRequestDispatcher("views/airschedule/userIntReturnSearchPage.jsp").forward(request, response);
		}
		
		if(ticket!=null && ticket.equals("oneway")) {
			
			if(userNo!=null) {
				
				request.setAttribute("flightNo", flightNo);
				request.setAttribute("userNo", userNo);
				request.setAttribute("depTime", depTime);
				request.setAttribute("arrivalTime", arrivalTime);
				request.setAttribute("price", price);
				request.setAttribute("airline", airline);
				request.setAttribute("depCode", depCode);
				request.setAttribute("arrivalCode", arrivalCode);
				request.setAttribute("depCity", depCity);
				request.setAttribute("arrivalCity", arrivalCity);
				request.setAttribute("person", person);
				request.setAttribute("classtype", classtype);
				request.setAttribute("depDate", depDate);
				
				request.getRequestDispatcher("/oneway.re").forward(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath()+"/nomemberPage.us");
			}
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