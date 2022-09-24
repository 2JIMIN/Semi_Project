package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.reservation.model.dao.ReservationDao;

public class ReservationService {

	public int insertIntOneway(int enrollNo, int bookingNo, String depCode, String flightNo, String depDate) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDao().insertIntOneway(conn, enrollNo, bookingNo, depCode, flightNo, depDate);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}

	public int insertIntRound(int enrollNo, int bookingNo, String depCode, String flightNo, String depDate,
			String rDepCode, String rFlightNo, String rDepDate) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDao().insertIntRound(conn, enrollNo, bookingNo, depCode, flightNo, depDate, rDepCode, rFlightNo, rDepDate);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}
}
