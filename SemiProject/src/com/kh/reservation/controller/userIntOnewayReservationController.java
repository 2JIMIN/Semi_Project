package com.kh.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.reservation.model.service.ReservationService;

/**
 * Servlet implementation class userIntOnewayReservationController
 */
@WebServlet("/intOneway.re")
public class userIntOnewayReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userIntOnewayReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int enrollNo = Integer.parseInt(request.getParameter("enrollNo"));
		int bookingNo = Integer.parseInt(request.getParameter("bookingNo"));
		String depCode = request.getParameter("depCode");
		String flightNo = request.getParameter("flightNo");
		String depDate = request.getParameter("depDate");
		
		System.out.println(bookingNo);
		int result = new ReservationService().insertIntOneway(enrollNo, bookingNo, depCode, flightNo, depDate);
		
		if(result > 0) {
			request.setAttribute("alertMsg", "예약 완료되었습니다. 마이페이지에서 예약 조회 가능합니다.");
			request.getRequestDispatcher("views/reservation/reservationCompletePage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "예약 실패");
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