package com.kh.userinfo.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import com.kh.common.JDBCTemplate;
import com.kh.userinfo.model.dao.UserInfoDao;
import com.kh.userinfo.model.vo.Reservation;
import com.kh.userinfo.model.vo.UserInfo;

public class UserInfoService {

	//로그인
	public UserInfo loginUserInfo(String userId, String userPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo u = new UserInfoDao().loginUserInfo(conn,userId,userPwd);
		
		JDBCTemplate.close(conn);
		
		return u;
		
	}

	//회원가입
	public int insertUserInfo(UserInfo u) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new UserInfoDao().insertUserInfo(conn,u);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int idCheck(String checkId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new UserInfoDao().idCheck(conn,checkId);
		
		JDBCTemplate.close(conn);
		
		return count;
	}

	public UserInfo idSerch(String userName, String phone) {
		
		Connection conn = JDBCTemplate.getConnection();
				
		UserInfo u = new UserInfoDao().idSerch(conn,userName,phone);
		
		JDBCTemplate.close(conn);
		
		return u;
		
	}

	public UserInfo pwdSerch(String userId, String phone) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo u = new UserInfoDao().pwdSerch(conn,userId,phone);
		
		JDBCTemplate.close(conn);
		
		return u;
		
		
		
	}

	public UserInfo pwdCheck(String userId, String newPwd) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new UserInfoDao().pwdCheck(conn,userId,newPwd);
		
		UserInfo updateUser = null;
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
			updateUser = new UserInfoDao().selectUserInfo(conn,userId);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return updateUser;
		
	}

	public int insertNomember(String userName, String email, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new UserInfoDao().insertNomember(conn,userName,email,phone);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int naverLogin(String email) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new UserInfoDao().naverLogin(conn,email);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	public UserInfo updateUser(UserInfo u) {
		Connection conn = JDBCTemplate.getConnection();
		UserInfo updateUser = null;		
		int result = new UserInfoDao().updateUser(conn,u);
		if(result>0) {
			JDBCTemplate.commit(conn);
			updateUser = new UserInfoDao().selectUser(conn,u.getUserId());
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return updateUser;
	
	}
	//비밀번호 변경 시작
	public UserInfo updatePwdUser(String userId, String userPwd, String userPwChk1) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new UserInfoDao().updatePwdUser(conn,userId,userPwd,userPwChk1);
		UserInfo updatePwdUser = null;
		if(result>0) {
			JDBCTemplate.commit(conn);
			
			updatePwdUser = new UserInfoDao().selectUser(conn, userId);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return updatePwdUser;
	}
	//비밀번호 변경 끝
	public UserInfo SearchUser(String userEmail) {
		
		Connection conn  = JDBCTemplate.getConnection();
		
		UserInfo ui = new UserInfoDao().SearchUser(conn, userEmail);
		
		JDBCTemplate.close(conn);
		
		return ui;
	}
	//예약조회
	public ArrayList<Reservation> reservationInquiry(String userId, int enrollNo, String flightNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Reservation> list = new UserInfoDao().reservationInquiry(conn,userId,enrollNo,flightNo);

		JDBCTemplate.close(conn);
		
		return list;
	}
	//예약 조회 끝
	//회원탈퇴 시작
	public int deleteUser(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new UserInfoDao().deleteUser(conn,userId,userPwd);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	//회원탈퇴 끝

	public UserInfo loginNomember(String email, int bookingNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo u = new UserInfoDao().loginNomember(conn,email,bookingNo);
		
		JDBCTemplate.close(conn);
		
		return u;
	}
}
