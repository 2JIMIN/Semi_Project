package com.kh.userinfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.userinfo.model.service.UserInfoService;
import com.kh.userinfo.model.vo.UserInfo;

/**
 * Servlet implementation class NaverLogin
 */
@WebServlet("/loginUser.us")
public class NaverLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
//		String name = request.getParameter("name");
////		String mobile = request.getParameter("mobile");
		
//		System.out.println(name);
////		System.out.println(mobile);
		
		int result = new UserInfoService().naverLogin(email);
		UserInfo u = new UserInfo(email);
		if(result>0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", u);
			
			response.sendRedirect(request.getContextPath());
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
