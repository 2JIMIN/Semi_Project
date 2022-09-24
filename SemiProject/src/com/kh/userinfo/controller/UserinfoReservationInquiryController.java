package com.kh.userinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.userinfo.model.service.UserInfoService;
import com.kh.userinfo.model.vo.Arrival;
import com.kh.userinfo.model.vo.Reservation;
import com.sun.xml.internal.ws.api.message.Attachment;

/**
 * Servlet implementation class UserinfoReservationInquiry
 */
@WebServlet("/reservationInquiry.us")
public class UserinfoReservationInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoReservationInquiryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		int bookingNo = Integer.parseInt(request.getParameter("bookingNo"));
		String flightNo = request.getParameter("flightNo");
		
		ArrayList<Reservation> list = new UserInfoService().reservationInquiry(userId,bookingNo,flightNo);

		request.setAttribute("list", list);
		request.getRequestDispatcher("views/userinfo/UserinfoReservationResult.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
