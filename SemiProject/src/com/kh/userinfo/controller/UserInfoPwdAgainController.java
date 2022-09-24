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
 * Servlet implementation class UserInfoPwdAgainController
 */
@WebServlet("/pwdAgain.us")
public class UserInfoPwdAgainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoPwdAgainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		String newPwdCheck = request.getParameter("newPwdCheck");
		
		
		if(userPwd!=null && newPwd!=null && userPwd.equals(newPwd)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "이전 비밀번호와 동일합니다.");
			response.sendRedirect(request.getContextPath()+"/views/userinfo/user_pwdErrorAlert.jsp");
		}
		else {
			
			if(newPwd!=null && newPwd!=null && newPwd.equals(newPwdCheck)) {
				
				UserInfo updateUser = new UserInfoService().pwdCheck(userId,newPwd);
				
				HttpSession session = request.getSession();
				session.setAttribute("newPwd", newPwd);
				
				session.setAttribute("alertMsg", "비밀번호가 변경되었습니다");
				response.sendRedirect(request.getContextPath()+"/views/userinfo/user_pwdAlert.jsp");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("errorMsg", "새로운 비밀번호가 일지하지 않습니다.");
				response.sendRedirect(request.getContextPath()+"/views/userinfo/user_pwdErrorAlert.jsp");
			}
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
