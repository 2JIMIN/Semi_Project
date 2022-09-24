package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.AdminService;
import com.kh.admin.model.vo.*;

/**
 * Servlet implementation class AdminReservatiomDelete
 */
@WebServlet("/reservationChangeGood.re")
public class AdminReservationChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReservationChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int eno = Integer.parseInt(request.getParameter("eno"));
		String flyingNo =request.getParameter("flying");
		
		
		int bookingNo = Integer.parseInt(request.getParameter("bookingNo"));
		String depCity = request.getParameter("depCity");
		String flightNo = request.getParameter("flightNo");
		String depDate = request.getParameter("depDate");
		String arrivalCity = request.getParameter("arrivalCity");
		String arrivalDate = request.getParameter("arrivalDate");
		int result = new AdminService().changeReservation(bookingNo,depCity,flightNo,depDate,arrivalCity,arrivalDate, eno, flyingNo);
		
		if(result>0) {
			session.setAttribute("alertMsg", "예약변경이 완료되었습니다.");
			session.removeAttribute("changeUser");
			request.getRequestDispatcher("views/admin/adminReservation.jsp").forward(request, response);			
		}else {
			request.setAttribute("errorMsg", "예약변경이 실패하였습니다.");
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
