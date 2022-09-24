package com.kh.recommendation.model.dao;

import static com.kh.common.JDBCTemplate.close;

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
import com.kh.recommendation.model.vo.Recommendation;

public class RecommendationDao {
	
	private Properties prop = new Properties();
	
	public RecommendationDao() {
		
		String fileName = Recommendation.class.getResource("/db/recommendation/recommendation-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int adInsertBoard(Connection conn, Recommendation r) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adInsertBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getBoardTitle());
			pstmt.setString(2, r.getBoardContent());
			pstmt.setString(3, r.getCountryCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int listCount(Connection conn) {
		int listCount = 0; 
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql= prop.getProperty("listCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT"); //나올 행이 하나뿐이기 때문에 while문이 아닌 if문 사용
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

	public ArrayList<Recommendation> pageinfoList(Connection conn, PageInfo pi) {
		ArrayList<Recommendation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("pageinfoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recommendation(rset.getInt("BOARD_NO")
									   ,rset.getInt("BOARD_TYPE")
									   ,rset.getString("BOARD_TITLE")
									   ,rset.getString("BOARD_CONTENT")
									   ,rset.getDate("CREATE_DATE")
									   ,rset.getInt("COUNT")
									   ,rset.getString("CONTINENT")));
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

	public Recommendation selectDetail(Connection conn, String boardNo) {
		
		Recommendation r = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql = prop.getProperty("selectDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Recommendation(rset.getInt("BOARD_NO")
								      ,rset.getString("BOARD_TITLE")
								      ,rset.getString("BOARD_CONTENT")
								      ,rset.getString("CONTINENT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}

	public Recommendation adminSelectBoard(Connection conn, int boardNo) {
		// select문, 게시글반호에 해당하는 글 1개만 조회
		Recommendation r = null; 
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("adminSelectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Recommendation(rset.getInt("BOARD_NO")
									  ,rset.getString("BOARD_TITLE")
						              ,rset.getString("BOARD_CONTENT")
						              ,rset.getString("COUNTRY_CODE")
						              ,rset.getString("CONTINENT")
						              ,rset.getString("COUNTRY_KOR"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}

	public int updateRecommendationBoard(Connection conn, Recommendation r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateRecommendationBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getBoardTitle());
			pstmt.setString(2, r.getBoardContent());
			pstmt.setInt(3, r.getBoardNo());
			
			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteRecommendationBoard(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteRecommendationBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int increaseCount(Connection conn, int boardNo) {
		//update 문 => 처리된 행의 수 
		int result = 0;
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate(); //처리된 행 수 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Recommendation selectBoard(Connection conn, int boardNo) {
		//select 문 -> ResultSet (한 행) 
		
		Recommendation r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Recommendation(rset.getInt("BOARD_NO")
							 ,rset.getString("BOARD_TITLE")
							 ,rset.getString("BOARD_CONTENT")
							 ,rset.getDate("CREATE_DATE")
							 ,rset.getInt("COUNT")
							 ,rset.getString("COUNTRY_CODE")
							 ,rset.getString("CONTINENT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return r;
	}

	public ArrayList<Recommendation> registerRecommendationCountryList(Connection conn) {
		ArrayList<Recommendation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("registerRecommendationCountryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recommendation(rset.getString("CONTINENT")
										   ,rset.getString("COUNTRY_KOR")
										   ,rset.getString("COUNTRY_ENG")
										   ,rset.getString("COUNTRY_CODE")));
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

	public ArrayList<Recommendation> listArea1(Connection conn, PageInfo pi) {
		ArrayList<Recommendation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("listArea1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recommendation(rset.getInt("BOARD_NO")
									   ,rset.getInt("BOARD_TYPE")
									   ,rset.getString("BOARD_TITLE")
									   ,rset.getString("BOARD_CONTENT")
									   ,rset.getDate("CREATE_DATE")
									   ,rset.getInt("COUNT")
									   ,rset.getString("CONTINENT")));
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
	
	public ArrayList<Recommendation> listArea2(Connection conn, PageInfo pi) {
		ArrayList<Recommendation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("listArea2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recommendation(rset.getInt("BOARD_NO")
									   ,rset.getInt("BOARD_TYPE")
									   ,rset.getString("BOARD_TITLE")
									   ,rset.getString("BOARD_CONTENT")
									   ,rset.getDate("CREATE_DATE")
									   ,rset.getInt("COUNT")
									   ,rset.getString("CONTINENT")));
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
	
	public ArrayList<Recommendation> listArea3(Connection conn, PageInfo pi) {
		ArrayList<Recommendation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("listArea3");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recommendation(rset.getInt("BOARD_NO")
									   ,rset.getInt("BOARD_TYPE")
									   ,rset.getString("BOARD_TITLE")
									   ,rset.getString("BOARD_CONTENT")
									   ,rset.getDate("CREATE_DATE")
									   ,rset.getInt("COUNT")
									   ,rset.getString("CONTINENT")));
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
	
	public ArrayList<Recommendation> listArea4(Connection conn, PageInfo pi) {
		ArrayList<Recommendation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("listArea4");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recommendation(rset.getInt("BOARD_NO")
									   ,rset.getInt("BOARD_TYPE")
									   ,rset.getString("BOARD_TITLE")
									   ,rset.getString("BOARD_CONTENT")
									   ,rset.getDate("CREATE_DATE")
									   ,rset.getInt("COUNT")
									   ,rset.getString("CONTINENT")));
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
	
	public ArrayList<Recommendation> listArea5(Connection conn, PageInfo pi) {
		ArrayList<Recommendation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("listArea5");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recommendation(rset.getInt("BOARD_NO")
									   ,rset.getInt("BOARD_TYPE")
									   ,rset.getString("BOARD_TITLE")
									   ,rset.getString("BOARD_CONTENT")
									   ,rset.getDate("CREATE_DATE")
									   ,rset.getInt("COUNT")
									   ,rset.getString("CONTINENT")));
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

}
