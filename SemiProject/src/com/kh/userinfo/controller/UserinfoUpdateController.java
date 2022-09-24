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
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/updateInfo.us")
public class UserinfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		UserInfo u = new UserInfo(userId,userName,phone,email);
		
		HttpSession updateSession = request.getSession();
		
		UserInfo updateUser = new UserInfoService().updateUser(u);
		if(updateUser == null) {
			request.setAttribute("errorMsg","회원정보 수정에 실패 하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);			
		}else {
			updateSession.setAttribute("loginUser", updateUser);
			updateSession.setAttribute("alertMsg", "회원정보 수정 완료");					
			response.sendRedirect(request.getContextPath()+"/myPage.us");

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
