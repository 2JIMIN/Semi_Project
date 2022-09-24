package com.kh.reservationdetail.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;
import java.sql.Connection;
import com.kh.reservationdetail.model.dao.ReservationDetailDao;
import com.kh.reservationdetail.model.vo.ReservationDetail;

public class ReservationDetailService {

	public int insertIntOneway(ReservationDetail rd) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDetailDao().insertIntOneway(conn, rd);
		
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ReservationDetail selectBookingNo(String lastName) {
		
		Connection conn = getConnection();
		
		ReservationDetail rd = new ReservationDetailDao().selectBookingNo(conn, lastName);
		
		close(conn);
		
		return rd;
	}

	public int insertDomOneway(ReservationDetail rd) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDetailDao().insertDomOneway(conn, rd);
		
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ReservationDetail selectDomBookingNo(String passengerName) {
		
		Connection conn = getConnection();
		
		ReservationDetail rd = new ReservationDetailDao().selectDomBookingNo(conn, passengerName);
		
		close(conn);
		
		return rd;
	}
}
