package com.kh.airschedule.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.airschedule.model.vo.AirSchedule;

public class AirScheduleDao {
	
	private Properties prop = new Properties();
	
	public AirScheduleDao() {
		
		String fileName = AirScheduleDao.class.getResource("/db/airschedule/airschedule-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AirSchedule> searchFlight(Connection conn, String depCity, String arrivalCity, String depDate) {
		
		ArrayList<AirSchedule> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchFlight");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, depCity);
			pstmt.setString(2, arrivalCity);
			pstmt.setString(3, depDate);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new AirSchedule(rset.getString("AIRLINE"),
										 rset.getString("DEP_CODE"),
									     rset.getString("DEP_CITY"),
									     rset.getString("ARRIVAL_CODE"),
									     rset.getString("ARRIVAL_CITY"),
									     rset.getString("DEP_TIME"),
									     rset.getString("ARRIVAL_TIME"),
									     rset.getString("WHOLE_TIME"),
									     rset.getInt("PRICE"),
									     rset.getString("NONSTOP_FLIGHT_YN"),
									     rset.getString("TRANSFER"),
									     rset.getString("WAITING_TIME"),
									     rset.getString("FLIGHT_NO")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int addFlight(Connection conn, AirSchedule a) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("addFlight");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, a.getFlightNo());
			pstmt.setString(2, a.getAirline());
			pstmt.setString(3, a.getDepCode());
			pstmt.setString(4, a.getDepDate());
			pstmt.setString(5, a.getDepTime());
			pstmt.setString(6, a.getArrivalCode());
			pstmt.setString(7, a.getArrivalDate());
			pstmt.setString(8, a.getArrivalTime());
			pstmt.setString(9, a.getWholeTime());
			pstmt.setInt(10, a.getPrice());
			pstmt.setString(11, a.getNonstopFlightYn());
			pstmt.setString(12, a.getTransfer());
			pstmt.setString(13, a.getWaitingTime());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public AirSchedule searchFlight1(Connection conn, String flightNo, String depDate) {
		
		AirSchedule a = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchFlight1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, flightNo);
			pstmt.setString(2, depDate);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				a = new AirSchedule(rset.getString("FLIGHT_NO"),
									rset.getString("DEP_CODE"),
									rset.getString("ARRIVAL_CODE"),
									rset.getString("DEP_DATE"),
									rset.getString("DEP_TIME"),
									rset.getString("ARRIVAL_DATE"),
									rset.getString("ARRIVAL_TIME"),
									rset.getInt("PRICE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return a;
	}

	public int updateFlight(Connection conn, String flightNo, AirSchedule a) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateFlight");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, a.getDepDate());
			pstmt.setString(2, a.getDepTime());
			pstmt.setString(3, a.getArrivalDate());
			pstmt.setString(4, a.getArrivalTime());
			pstmt.setInt(5, a.getPrice());
			pstmt.setString(6, flightNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteFlight(Connection conn, String flightNo, String depDate) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteFlight");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, flightNo);
			pstmt.setString(2, depDate);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}