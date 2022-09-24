package com.kh.userinfo.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.userinfo.model.service.UserInfoService;
import com.kh.userinfo.model.vo.UserInfo;

/**
 * Servlet implementation class MemberUpdatePwdController
 */
@WebServlet("/updatePwdForm.us")
public class UserinfoUpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoUpdatePwdController() {
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
		String userPwChk1 = request.getParameter("userPwChk1");
		UserInfo updatePwdUser = new UserInfoService().updatePwdUser(userId,userPwd,userPwChk1);

		HttpSession session = request.getSession();
		
		if(updatePwdUser == null) {
//			session.setAttribute("alertMsg","공란이 없이 입력해주세요.");
			request.setAttribute("errorMsg","비밀번호 수정을 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);			
		}else {
 			session.setAttribute("alertMsg", "비밀번호 변경이 완료되었습니다.");
 			session.setAttribute("loginUser", updatePwdUser);
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
