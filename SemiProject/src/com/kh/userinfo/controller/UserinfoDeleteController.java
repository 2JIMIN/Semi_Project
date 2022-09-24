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
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/deleteUser.us")
public class UserinfoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = ((UserInfo)session.getAttribute("loginUser")).getUserId();
		String userPwd = ((UserInfo)session.getAttribute("loginUser")).getUserPwd();
		
		int result = new UserInfoService().deleteUser(userId,userPwd);
		
		if(result>0) {
			session.setAttribute("alertMsg", "회원탈퇴를 성공하였습니다. 감사합니다.");
			session.removeAttribute("loginUser");
			response.sendRedirect(request.getContextPath());
			
		}else {
			request.setAttribute("errorMsg", "회원탈퇴를 실패하였습니다.");
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
