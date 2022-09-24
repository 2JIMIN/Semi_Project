package com.kh.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userOnewayReservationPageController
 */
@WebServlet("/oneway.re")
public class userIntOnewayReservationPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userIntOnewayReservationPageController() {
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
		String depTime = request.getParameter("depTime");
		String arrivalTime = request.getParameter("arrivalTime");
		String price = request.getParameter("price");
		String airline = request.getParameter("airline");
		String depCode = request.getParameter("depCode");
		String arrivalCode = request.getParameter("arrivalCode");
		String depCity = request.getParameter("depCity");
		String arrivalCity = request.getParameter("arrivalCity");
		String person = request.getParameter("person");
		String classtype = request.getParameter("classtype");
		String depDate = request.getParameter("depDate");
		
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
		
		request.getRequestDispatcher("views/reservation/userIntReservationOneway.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
