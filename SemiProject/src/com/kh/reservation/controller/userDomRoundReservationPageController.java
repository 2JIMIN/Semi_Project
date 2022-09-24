package com.kh.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userDomRoundReservationPageController
 */
@WebServlet("/roundDom.re")
public class userDomRoundReservationPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDomRoundReservationPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
request.setCharacterEncoding("UTF-8");
		
		String userNo = request.getParameter("userNo");
		
		String onewayFlightNo = request.getParameter("onewayFlightNo");
		String onewayDepTime = request.getParameter("onewayDepTime");
		String onewayArrivalTime = request.getParameter("onewayArrivalTime");
		String onewayAirline = request.getParameter("onewayAirline");
		String onewayDepCode = request.getParameter("onewayDepCode");
		String onewayArrivalCode = request.getParameter("onewayArrivalCode");
		String onewayDepCity = request.getParameter("onewayDepCity");
		String onewayArrivalCity = request.getParameter("onewayArrivalCity");
		String onewayDepDate = request.getParameter("onewayDepDate");
		
		String returnFlightNo = request.getParameter("returnFlightNo");
		String returnDepTime = request.getParameter("returnDepTime");
		String returnArrivalTime = request.getParameter("returnArrivalTime");
		String returnAirline = request.getParameter("returnAirline");
		String returnDepCode = request.getParameter("returnDepCode");
		String returnArrivalCode = request.getParameter("returnArrivalCode");
		String returnDepCity = request.getParameter("returnDepCity");
		String returnArrivalCity = request.getParameter("returnArrivalCity");
		String returnDepDate = request.getParameter("returnDepDate");
		String price = request.getParameter("price");
		String person = request.getParameter("person");
		String classtype = request.getParameter("classtype");
		
		
		if(userNo!=null) {
			
			request.setAttribute("userNo", userNo);
			
			request.setAttribute("onewayFlightNo", onewayFlightNo);
			request.setAttribute("onewayDepTime", onewayDepTime);
			request.setAttribute("onewayArrivalTime", onewayArrivalTime);
			request.setAttribute("onewayAirline", onewayAirline);
			request.setAttribute("onewayDepCode", onewayDepCode);
			request.setAttribute("onewayArrivalCode", onewayArrivalCode);
			request.setAttribute("onewayDepCity", onewayDepCity);
			request.setAttribute("onewayArrivalCity", onewayArrivalCity);
			request.setAttribute("onewayDepDate", onewayDepDate);
			
			request.setAttribute("returnFlightNo", returnFlightNo);
			request.setAttribute("returnDepTime", returnDepTime);
			request.setAttribute("returnArrivalTime", returnArrivalTime);
			request.setAttribute("price", price);
			request.setAttribute("returnAirline", returnAirline);
			request.setAttribute("returnDepCode", returnDepCode);
			request.setAttribute("returnArrivalCode", returnArrivalCode);
			request.setAttribute("returnDepCity", returnDepCity);
			request.setAttribute("returnArrivalCity", returnArrivalCity);
			request.setAttribute("returnDepDate", returnDepDate);
			request.setAttribute("person", person);
			request.setAttribute("classtype", classtype);
			
			request.getRequestDispatcher("views/reservation/userDomReservationRound.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/nomemberPage.us");
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