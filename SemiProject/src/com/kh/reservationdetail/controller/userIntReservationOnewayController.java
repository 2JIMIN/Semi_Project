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
 * Servlet implementation class userIntReservationOnewayController
 */
@WebServlet("/intOneway.rd")
public class userIntReservationOnewayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userIntReservationOnewayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String passportNo = request.getParameter("passportNo");
		int validDate = Integer.parseInt(request.getParameter("validDate"));
		int enrollNo = Integer.parseInt(request.getParameter("enrollNo"));
		String depCode = request.getParameter("depCode");
		String flightNo = request.getParameter("flightNo");
		String depDate = request.getParameter("depDate");
		int price = Integer.parseInt(request.getParameter("price"));
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		ReservationDetail rd = new ReservationDetail();
		rd.setLastName(lastName);
		rd.setFirstName(firstName);
		rd.setPassportNo(passportNo);
		rd.setValidDate(validDate);
		
		int result = new ReservationDetailService().insertIntOneway(rd);
		
		ReservationDetail rd1 = new ReservationDetailService().selectBookingNo(lastName);
		
		int bookingNo = rd1.getBookingNo();
		
		if(result > 0) {
			
			int result1 = new ReservationService().insertIntOneway(enrollNo, bookingNo, depCode, flightNo, depDate);
			
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