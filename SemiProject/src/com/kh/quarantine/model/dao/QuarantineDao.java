package com.kh.quarantine.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.PageInfo;
import com.kh.quarantine.model.vo.Quarantine;
import static com.kh.common.JDBCTemplate.*;

public class QuarantineDao {

	private Properties prop = new Properties();
	
	public QuarantineDao() {
		
		String fileName =  QuarantineDao.class.getResource("/db/quarantine/quarantine-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Quarantine quarantineCity(Connection conn, String arrivalCity) {
		
		Quarantine q = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("quarantineCity");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, arrivalCity);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				q = new Quarantine(rset.getString("COUNTRY_KOR"),
								   rset.getString("COUNTRY_ENG"),
								   rset.getString("DEP_VY_PCR"),
								   rset.getString("DEP_VN_PCR"),
								   rset.getString("ARR_VY_PCR"),
								   rset.getString("ARR_VN_PCR"),
								   rset.getString("ARR_VY_SELF"),
								   rset.getString("ARR_VN_SELF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}
	public ArrayList<Quarantine> quarantineInfoList(Connection conn, String clickContinent) {
		// SELECT문
		ArrayList<Quarantine> listTap = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("quarantineInfoList");
		
		System.out.println(clickContinent);
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clickContinent);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listTap.add(new Quarantine(rset.getString("COUNTRY_KOR")
									  ,rset.getString("COUNTRY_ENG")
									  ,rset.getString("DEP_VY_PCR")
									  ,rset.getString("DEP_VN_PCR")
									  ,rset.getString("ARR_VY_PCR")
									  ,rset.getString("ARR_VN_PCR")
									  ,rset.getString("ARR_VY_SELF")
									  ,rset.getString("ARR_VN_SELF")));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(listTap);
		return listTap;
		
	}
	
	public ArrayList<Quarantine> quarantineInfoList1(Connection conn) {
		// SELECT문
		ArrayList<Quarantine> listTap1 = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("quarantineContinent-tap1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listTap1.add(new Quarantine(rset.getString("COUNTRY_KOR")
									  ,rset.getString("COUNTRY_ENG")
									  ,rset.getString("DEP_VY_PCR")
									  ,rset.getString("DEP_VN_PCR")
									  ,rset.getString("ARR_VY_PCR")
									  ,rset.getString("ARR_VN_PCR")
									  ,rset.getString("ARR_VY_SELF")
									  ,rset.getString("ARR_VN_SELF")));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listTap1;		
	}
	
	public ArrayList<Quarantine> quarantineInfoList2(Connection conn) {
		// SELECT문
		ArrayList<Quarantine> listTap2 = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("quarantineContinent-tap2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listTap2.add(new Quarantine(rset.getString("COUNTRY_KOR")
									  ,rset.getString("COUNTRY_ENG")
									  ,rset.getString("DEP_VY_PCR")
									  ,rset.getString("DEP_VN_PCR")
									  ,rset.getString("ARR_VY_PCR")
									  ,rset.getString("ARR_VN_PCR")
									  ,rset.getString("ARR_VY_SELF")
									  ,rset.getString("ARR_VN_SELF")));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listTap2;		
	}
	
	public ArrayList<Quarantine> quarantineInfoList3(Connection conn) {
		// SELECT문
		ArrayList<Quarantine> listTap3 = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("quarantineContinent-tap3");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listTap3.add(new Quarantine(rset.getString("COUNTRY_KOR")
									  ,rset.getString("COUNTRY_ENG")
									  ,rset.getString("DEP_VY_PCR")
									  ,rset.getString("DEP_VN_PCR")
									  ,rset.getString("ARR_VY_PCR")
									  ,rset.getString("ARR_VN_PCR")
									  ,rset.getString("ARR_VY_SELF")
									  ,rset.getString("ARR_VN_SELF")));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listTap3;		
	}
	
	public ArrayList<Quarantine> quarantineInfoList4(Connection conn) {
		// SELECT문
		ArrayList<Quarantine> listTap4 = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("quarantineContinent-tap4");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				listTap4.add(new Quarantine(rset.getString("COUNTRY_KOR")
									  ,rset.getString("COUNTRY_ENG")
									  ,rset.getString("DEP_VY_PCR")
									  ,rset.getString("DEP_VN_PCR")
									  ,rset.getString("ARR_VY_PCR")
									  ,rset.getString("ARR_VN_PCR")
									  ,rset.getString("ARR_VY_SELF")
									  ,rset.getString("ARR_VN_SELF")));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listTap4;		
	}

	//관리자 - 방역현황 목록조회
	public ArrayList<Quarantine> adminSelectList(Connection conn) {
		// SELECT문
		ArrayList<Quarantine> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminselectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Quarantine(rset.getString("CONTINENT")
									   ,rset.getString("COUNTRY_KOR")
									   ,rset.getString("COUNTRY_CODE")
									   ,rset.getDate("UPDATE_DATE")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	//관리자 - 페이징처리를 위한 게시글수
	public int adminListCount(Connection conn) {
		
		int listCount = 0; 
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql= prop.getProperty("adminListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	//관리자 - 페이징 한페이지 출력게시글 목록
	public ArrayList<Quarantine> adminPageinfoList(Connection conn, PageInfo pi) {
		ArrayList<Quarantine> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminPageinfoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			//BOARD_NO,CATEGORY_NAME,BOARD_TITLE,USER_NAME,COUNT,CREATE_DATE
			while(rset.next()) {
				list.add(new Quarantine(rset.getString("CONTINENT")
									   ,rset.getString("COUNTRY_CODE")
									   ,rset.getString("COUNTRY_KOR")
									   ,rset.getDate("UPDATE_DATE")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	//관리자 - 등록정보 상세보기
	public Quarantine selectDetail(Connection conn, String countryCode) {
		
		Quarantine q = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql = prop.getProperty("selectDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, countryCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Quarantine(rset.getString("COUNTRY_CODE")
								  ,rset.getString("DEP_VY_PCR")
								  ,rset.getString("DEP_VN_PCR")
								  ,rset.getString("ARR_VY_PCR")
								  ,rset.getString("ARR_VN_PCR")
								  ,rset.getString("ARR_VY_SELF")
								  ,rset.getString("ARR_VN_SELF")
								  ,rset.getDate("UPDATE_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}

	public int insertQuarantine(Connection conn, Quarantine q) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQuarantine");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getCountryCode());
			pstmt.setString(2, q.getDepVyPcr());
			pstmt.setString(3, q.getDepVnPcr());
			pstmt.setString(4, q.getArrVyPcr());
			pstmt.setString(5, q.getArrVnPcr());
			pstmt.setString(6, q.getArrVySelf());
			pstmt.setString(7, q.getArrVnSelf());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Quarantine> registerQuarantineCountryList(Connection conn) {
		ArrayList<Quarantine> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("registerQuarantineCountryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Quarantine(rset.getString("COUNTRY_CODE")
									   ,rset.getString("COUNTRY_KOR")
									   ,rset.getString("COUNTRY_ENG")
									   ,rset.getString("CONTINENT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Quarantine adminSelectInfo(Connection conn, String countryCode) {
		// select문, 국가코드에 해당하는 글 1개만 조회
		Quarantine q = null; 
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminSelectInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, countryCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Quarantine(rset.getString("COUNTRY_CODE")
							  ,rset.getString("DEP_VY_PCR")
							  ,rset.getString("DEP_VN_PCR")
							  ,rset.getString("ARR_VY_PCR")
							  ,rset.getString("ARR_VN_PCR")
							  ,rset.getString("ARR_VY_SELF")
							  ,rset.getString("ARR_VN_SELF")
							  ,rset.getDate("UPDATE_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
	}

	public int updateQuarantineInfo(Connection conn, Quarantine q) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQuarantineInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getDepVyPcr());
			pstmt.setString(2, q.getDepVnPcr());
			pstmt.setString(3, q.getArrVyPcr());
			pstmt.setString(4, q.getArrVnPcr());
			pstmt.setString(5, q.getArrVySelf());
			pstmt.setString(6, q.getArrVnSelf());
			pstmt.setString(7, q.getCountryCode());
			
			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteQuarantineInfo(Connection conn, String countryCode) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteQuarantineInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, countryCode);
			
			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
