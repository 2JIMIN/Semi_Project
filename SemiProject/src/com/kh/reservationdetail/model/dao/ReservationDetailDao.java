package com.kh.reservationdetail.model.dao;

import static com.kh.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.kh.reservationdetail.model.vo.ReservationDetail;

public class ReservationDetailDao {
	
	private Properties prop = new Properties();
	
	public ReservationDetailDao() {
		
		String fileName =  ReservationDetailDao.class.getResource("/db/reservationdetail/reservationdetail-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertIntOneway(Connection conn, ReservationDetail rd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertIntOneway");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rd.getLastName());
			pstmt.setString(2, rd.getFirstName());
			pstmt.setString(3, rd.getPassportNo());
			pstmt.setInt(4, rd.getValidDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ReservationDetail selectBookingNo(Connection conn, String lastName) {
		
		ReservationDetail rd = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookingNo");
		
		try {
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, lastName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rd = new ReservationDetail(rset.getInt("BOOKING_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rd;
	}

	public int insertIntRound(Connection conn, ReservationDetail rd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertIntRound");
		
		return result;
	}

	public int insertDomOneway(Connection conn, ReservationDetail rd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertDomOneway");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rd.getPassengerName());
			pstmt.setInt(2, rd.getBirthDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ReservationDetail selectDomBookingNo(Connection conn, String passengerName) {
		
		ReservationDetail rd = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		String sql = prop.getProperty("selectDomBookingNo");
		
		try {
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, passengerName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rd = new ReservationDetail(rset.getInt("BOOKING_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rd;
	}
}