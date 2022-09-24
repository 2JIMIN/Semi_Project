package com.kh.userinfo.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.userinfo.model.service.UserInfoService;
import com.kh.userinfo.model.vo.UserInfo;

/**
 * Servlet implementation class userSearchController
 */
@WebServlet("/searchCon.us")
public class userInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userEmail = request.getParameter("userEmail");
		
		UserInfo ui = new UserInfoService().SearchUser(userEmail);
		
		if(ui!=null) {
			
//			int userNo = ui.getUserNo();
//			String userId = ui.getUserId();
//			String userPwd = ui.getUserPwd();
//			String userName = ui.getUserName();
//			userEmail = ui.getEmail();
//			String phone = ui.getPhone();
//			Date enrollDate = ui.getEnrollDate();
//			String status = ui.getStatus();
//			
//			request.setAttribute("userNo", userNo);
//			request.setAttribute("userId", userId);
//			request.setAttribute("userPwd", userPwd);
//			request.setAttribute("userName", userName);
//			request.setAttribute("email", userEmail);
//			request.setAttribute("phone", phone);
//			request.setAttribute("enrollDate", enrollDate);
//			request.setAttribute("status", status);
			
			request.setAttribute("ui", ui);
			
			request.getRequestDispatcher("views/userinfo/admin_userManagement.jsp").forward(request, response);
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
