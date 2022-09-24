package com.kh.userinfo.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.userinfo.model.vo.Reservation;
import com.kh.userinfo.model.vo.UserInfo;

public class UserInfoDao {
	
	private Properties prop = new Properties();
	
	public UserInfoDao() {
		String fileName = UserInfoDao.class.getResource("/db/userinfo/userinfo-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserInfo loginUserInfo(Connection conn, String userId, String userPwd) {
		//userId가 유니크이기때문에 1개또는 0개 중복불가
		UserInfo u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginUserInfo");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new UserInfo(rset.getInt("USER_NO")
							  ,rset.getString("USER_ID")
							  ,rset.getString("USER_PWD")
							  ,rset.getString("USER_NAME")
							  ,rset.getString("EMAIL")
							  ,rset.getString("PHONE")
							  ,rset.getDate("ENROLL_DATE")
							  ,rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
		
		
	}

	public int insertUserInfo(Connection conn, UserInfo u) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertUserInfo");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPwd());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getPhone());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}

	public int idCheck(Connection conn, String checkId) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
		
	}

	public UserInfo idSerch(Connection conn, String userName, String phone) {
		
		UserInfo u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idSerch");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, phone);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				u = new UserInfo(rset.getString("USER_ID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
//		System.out.println(u);
		return u;
	}

	public UserInfo pwdSerch(Connection conn, String userId, String phone) {
		
		UserInfo u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("pwdSerch");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, phone);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				
				u = new UserInfo(rset.getString("USER_ID"), rset.getString("USER_PWD"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
	}

	public int pwdCheck(Connection conn, String userId, String newPwd) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("pwdCheck");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
		
	}

	public UserInfo selectUserInfo(Connection conn, String userId) {
		
		UserInfo u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUserInfo");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				u = new UserInfo(rset.getInt("USER_NO")
								,rset.getString("USER_ID")
								,rset.getString("USER_PWD")
								,rset.getString("USER_NAME")
								,rset.getString("EMAIL")
								,rset.getString("PHONE")
								,rset.getDate("ENROLL_DATE")
								,rset.getString("STATUS"));
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
		
	}


	public int insertNomember(Connection conn, String userName,  String email, String phone) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNomember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}

	public int naverLogin(Connection conn, String email) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("naverLogin");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public UserInfo SearchUser(Connection conn, String userEmail) {
		
		UserInfo ui = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("SearchUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				ui = (new UserInfo(rset.getInt("USER_NO"),
								   rset.getString("USER_ID"),
								   rset.getString("USER_PWD"),
								   rset.getString("USER_NAME"),
								   rset.getString("EMAIL"),
								   rset.getString("PHONE"),
								   rset.getDate("ENROLL_DATE"),
								   rset.getString("STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		};
		
		return ui;
	}
	public UserInfo selectUser(Connection conn, String userId) {

		UserInfo u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectUser");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				u = new UserInfo(rset.getInt("USER_NO"), rset.getString("USER_ID"), rset.getString("USER_PWD"),
						rset.getString("USER_NAME"), rset.getString("EMAIL"), rset.getString("PHONE"),
						rset.getDate("ENROLL_DATE"), rset.getString("STATUS"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
	}
	public int updateUser(Connection conn, UserInfo u) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateUser");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, u.getUserName());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(2, u.getPhone());
			pstmt.setString(4, u.getUserId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}
	// 비밀번호 변경 시작
	public int updatePwdUser(Connection conn, String userId, String userPwd, String userPwChk1) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updatePwdUser");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPwChk1);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}
	// 비밀번호 변경 끝
	// 예약조회 시작
	public ArrayList<Reservation> reservationInquiry(Connection conn, String userId, int enrollNo, String flightNo) {
		
		ArrayList<Reservation> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reservationInquriy");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, enrollNo);
			pstmt.setString(2, flightNo);
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				list.add(new Reservation(rset.getInt("ENROLL_NO"),
										 rset.getString("INT_DOM_ID"),
										 rset.getInt("BOOKING_NO"),
										 rset.getString("USER_NAME"),
										 rset.getString("EMAIL"),
										 rset.getString("FLIGHT_NO"),
										 rset.getString("DEP_CITY"),
										 rset.getString("ARRIVAL_CITY"),
										 rset.getString("DEP_DATE"),
										 rset.getString("ARRIVAL_DATE")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	// 예약조회 끝
	// 회원탈퇴 시작
	public int deleteUser(Connection conn, String userId, String userPwd) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteUser");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}
	// 회원탈퇴 끝

	public UserInfo loginNomember(Connection conn, String email, int bookingNo) {
		
		UserInfo u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginNomember");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setInt(2, bookingNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new UserInfo(rset.getInt("USER_NO")
							  ,rset.getString("USER_ID")
							  ,rset.getString("USER_PWD")
							  ,rset.getString("USER_NAME")
							  ,rset.getString("EMAIL")
							  ,rset.getString("PHONE")
							  ,rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
	}
	
}
