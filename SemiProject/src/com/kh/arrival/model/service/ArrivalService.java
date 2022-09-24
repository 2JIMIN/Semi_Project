package com.kh.arrival.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import com.kh.arrival.model.dao.ArrivalDao;
import com.kh.arrival.model.vo.Arrival;

public class ArrivalService {

	public ArrayList<Arrival> selectAsia1() {
		
		Connection conn = getConnection();
		
		ArrayList<Arrival> list = new ArrivalDao().selectAsia1(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Arrival> selectAsia2() {
		
		Connection conn = getConnection();
		
		ArrayList<Arrival> list = new ArrivalDao().selectAsia2(conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Arrival> selectEtc() {
		
		Connection conn = getConnection();
		
		ArrayList<Arrival> list = new ArrivalDao().selectEtc(conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Arrival> selectEurope() {
		
		Connection conn = getConnection();
		
		ArrayList<Arrival> list = new ArrivalDao().selectEurope(conn);
		
		close(conn);
		
		return list;
	}
}
