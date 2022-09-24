package com.kh.airschedule.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import com.kh.airschedule.model.dao.AirScheduleDao;
import com.kh.airschedule.model.vo.AirSchedule;

public class AirScheduleService {

	public ArrayList<AirSchedule> searchFlight(String depCity, String arrivalCity, String depDate) {
		
		Connection conn = getConnection();
		
		ArrayList<AirSchedule> list = new AirScheduleDao().searchFlight(conn, depCity, arrivalCity, depDate);
		
		close(conn);
		
		return list;
	}

	public int addFlight(AirSchedule a) {
		
		Connection conn = getConnection();
		
		int result = new AirScheduleDao().addFlight(conn, a);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public AirSchedule searchFlight1(String flightNo, String depDate) {
		
		Connection conn = getConnection();
		
		AirSchedule a = new AirScheduleDao().searchFlight1(conn, flightNo, depDate);
		
		close(conn);
		
		return a;
	}

	public int updateFlight(String flightNo, AirSchedule a) {
		
		Connection conn = getConnection();
		
		int result = new AirScheduleDao().updateFlight(conn, flightNo, a);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteFlight(String flightNo, String depDate) {
		
		Connection conn = getConnection();
		
		int result = new AirScheduleDao().deleteFlight(conn, flightNo, depDate);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
}
