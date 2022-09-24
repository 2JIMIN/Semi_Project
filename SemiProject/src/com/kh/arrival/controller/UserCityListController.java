package com.kh.arrival.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.arrival.model.service.ArrivalService;
import com.kh.arrival.model.vo.Arrival;

/**
 * Servlet implementation class userCityListWindowController
 */
@WebServlet("/cityList.re")
public class UserCityListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCityListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Arrival> list1 = new ArrivalService().selectAsia1();
		ArrayList<Arrival> list2 = new ArrivalService().selectAsia2();
		ArrayList<Arrival> list3 = new ArrivalService().selectEtc();
		ArrayList<Arrival> list4 = new ArrivalService().selectEurope();
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		
		request.getRequestDispatcher("views/international/userCityList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}