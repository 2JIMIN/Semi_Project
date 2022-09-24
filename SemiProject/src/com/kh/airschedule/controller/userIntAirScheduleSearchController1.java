package com.kh.airschedule.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.airschedule.model.service.AirScheduleService;
import com.kh.airschedule.model.vo.AirSchedule;

/**
 * Servlet implementation class UserAirScheduleSearchController1
 */
@WebServlet("/search1.ai")
public class userIntAirScheduleSearchController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userIntAirScheduleSearchController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String ticket = request.getParameter("ticket");
		String person = request.getParameter("person");
		String classType = request.getParameter("classType");
		String depCity = request.getParameter("depCity");
		String arrivalCity = request.getParameter("arrivalCity");
		String depDate = request.getParameter("depDate");
		String comingDate = request.getParameter("comingDate");
		
		String classtype = null;
		
		if(classType.equals("1")) {
			classtype = "이코노미";
		}
		if(classType.equals("2")) {
			classtype = "비즈니스";
		}
		
		ArrayList<AirSchedule> list = new AirScheduleService().searchFlight(depCity, arrivalCity, depDate);
		
		request.setAttribute("list", list);
		request.setAttribute("ticket", ticket);
		request.setAttribute("depCity", depCity);
		request.setAttribute("arrivalCity", arrivalCity);
		request.setAttribute("person", person);
		request.setAttribute("classType", classType);
		request.setAttribute("classtype", classtype);
		request.setAttribute("depDate", depDate);
		request.setAttribute("comingDate", comingDate);
		
		request.getRequestDispatcher("views/airschedule/userIntOnewaySearchPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}