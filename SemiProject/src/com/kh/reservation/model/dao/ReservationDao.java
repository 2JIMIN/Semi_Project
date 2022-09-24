package com.kh.reservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

public class ReservationDao {
	
	private Properties prop = new Properties();
	
	public ReservationDao() {
		
		String fileName = ReservationDao.class.getResource("/db/reservation/reservation-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertIntOneway(Connection conn, int enrollNo, int bookingNo, String depCode, String flightNo, String depDate) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertIntOneway");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, enrollNo);
			pstmt.setInt(2, bookingNo);
			pstmt.setString(3, depCode);
			pstmt.setString(4, flightNo);
			pstmt.setString(5, depDate);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertIntRound(Connection conn, int enrollNo, int bookingNo, String depCode, String flightNo,
			String depDate, String rDepCode, String rFlightNo, String rDepDate) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertIntRound");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, enrollNo);
			pstmt.setInt(2, bookingNo);
			pstmt.setString(3, depCode);
			pstmt.setString(4, flightNo);
			pstmt.setString(5, depDate);
			pstmt.setString(6, rDepCode);
			pstmt.setString(7, rFlightNo);
			pstmt.setString(8, rDepDate);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
