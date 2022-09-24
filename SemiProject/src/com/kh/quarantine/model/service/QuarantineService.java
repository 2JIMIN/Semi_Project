package com.kh.quarantine.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.quarantine.model.dao.QuarantineDao;
import com.kh.quarantine.model.vo.Quarantine;

public class QuarantineService {

	public Quarantine quarantineCity(String arrivalCity) {
		
		Connection conn = getConnection();
		
		Quarantine q = new QuarantineDao().quarantineCity(conn, arrivalCity);
		
		close(conn);
		
		return q;
	}
	public ArrayList<Quarantine> quarantineInfoList(String clickContinent) {
		Connection conn = getConnection();
		
		ArrayList<Quarantine> listTap= new QuarantineDao().quarantineInfoList(conn,clickContinent);

		close(conn);
		
		return listTap;
	}
	
	public ArrayList<Quarantine> quarantineInfoList1(){
		
		Connection conn = getConnection();
		
		ArrayList<Quarantine> listTap1= new QuarantineDao().quarantineInfoList1(conn);

		
		close(conn);
		
		return listTap1;
	}
	
	public ArrayList<Quarantine> quarantineInfoList2(){
		
		Connection conn = getConnection();
		
		ArrayList<Quarantine> listTap2= new QuarantineDao().quarantineInfoList2(conn);

		
		close(conn);
		
		return listTap2;
	}
	
	public ArrayList<Quarantine> quarantineInfoList3(){
		
		Connection conn = getConnection();
		
		ArrayList<Quarantine> listTap3= new QuarantineDao().quarantineInfoList3(conn);
		
		close(conn);
		
		return listTap3;
	}
	
	public ArrayList<Quarantine> quarantineInfoList4(){
		
		Connection conn = getConnection();
		
		ArrayList<Quarantine> listTap4= new QuarantineDao().quarantineInfoList4(conn);
		
		close(conn);
		
		return listTap4;
	}

	public ArrayList<Quarantine> adminSelectList() {
		
		Connection conn = getConnection();
		
		ArrayList<Quarantine> list = new QuarantineDao().adminSelectList(conn);
		
		close(conn);
		
		return list;
	}

	public Quarantine adminSelectInfo(String countryCode) {
		
		Connection conn = getConnection();
		
		Quarantine q = new QuarantineDao().adminSelectInfo(conn,countryCode);
		
		close(conn);
		
		return q;
	}

	public int adminListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new QuarantineDao().adminListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Quarantine> adminPageinfoList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Quarantine> list = new QuarantineDao().adminPageinfoList(conn,pi);
		
		close(conn);
		
		return list;
	}
	
	//관리자 - 등록정보 상세보기
	public Quarantine selectDetail(String countryCode) {
		
		Connection conn = getConnection();
		
		Quarantine q = new QuarantineDao().selectDetail(conn,countryCode);
		
		close(conn);
		
		return q;
	}
	
	public int insertQuarantine(Quarantine q) {
		
		Connection conn = getConnection();
		
		int result = new QuarantineDao().insertQuarantine(conn,q);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
	//국가테이블 조회하여 등록된 국가 리스트 출력(등록폼에서 사용)
	public ArrayList<Quarantine> registerQuarantineCountryList() {
		Connection conn = getConnection();
		
		ArrayList<Quarantine>list = new QuarantineDao().registerQuarantineCountryList(conn);
		close(conn);
		
		return list;
	}

	public int updateQuarantineInfo(Quarantine q) {
		Connection conn = getConnection();
		
		int result = new QuarantineDao().updateQuarantineInfo(conn,q);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteQuarantineInfo(String countryCode) {
		Connection conn = getConnection();
		
		int result = new QuarantineDao().deleteQuarantineInfo(conn,countryCode);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
}
