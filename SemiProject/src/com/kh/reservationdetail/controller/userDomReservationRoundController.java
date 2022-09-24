package com.kh.reservationdetail.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.reservation.model.service.ReservationService;
import com.kh.reservationdetail.model.service.ReservationDetailService;
import com.kh.reservationdetail.model.vo.ReservationDetail;

/**
 * Servlet implementation class userDomReservationRoundController
 */
@WebServlet("/domRound.rd")
public class userDomReservationRoundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDomReservationRoundController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String passengerName = request.getParameter("passengerName");
		int birthDate = Integer.parseInt(request.getParameter("birthDate"));
		int enrollNo = Integer.parseInt(request.getParameter("enrollNo"));
		String depCode = request.getParameter("depCode");
		String flightNo = request.getParameter("flightNo");
		String depDate = request.getParameter("depDate");
		String rDepCode = request.getParameter("rDepCode");
		String rFlightNo = request.getParameter("rFlightNo");
		String rDepDate = request.getParameter("rDepDate");
		int price = Integer.parseInt(request.getParameter("price"));
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		ReservationDetail rd = new ReservationDetail();
		rd.setPassengerName(passengerName);
		rd.setBirthDate(birthDate);
		
		int result = new ReservationDetailService().insertDomOneway(rd);
		
		ReservationDetail rd1 = new ReservationDetailService().selectDomBookingNo(passengerName);
		
		int bookingNo = rd1.getBookingNo();
		
		if(result > 0) {
			
			int result1 = new ReservationService().insertIntRound(enrollNo, bookingNo, depCode, flightNo, depDate, rDepCode, rFlightNo, rDepDate);
			
			if(result1 > 0) {
				
				request.setAttribute("price", price);
				request.setAttribute("userName", userName);
				request.setAttribute("email", email);
				request.setAttribute("phone", phone);
				
				request.getRequestDispatcher("views/reservation/kakao.jsp").forward(request, response);
//				request.setAttribute("alertMsg", "예약 완료되었습니다. 마이페이지에서 예약 조회 가능합니다.");
//				request.getRequestDispatcher("views/reservation/reservationCompletePage.jsp").forward(request, response);
			}
			else {
				request.setAttribute("errorMsg", "예약 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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