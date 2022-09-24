package com.kh.recommendation.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.PageInfo;
import com.kh.quarantine.model.dao.QuarantineDao;
import com.kh.quarantine.model.vo.Quarantine;
import com.kh.recommendation.model.dao.RecommendationDao;
import com.kh.recommendation.model.vo.Recommendation;

public class RecommendationService {

	public int adInsertBoard(Recommendation r) {
		Connection conn = getConnection();
		
		int result = new RecommendationDao().adInsertBoard(conn,r);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int listCount() {
		Connection conn = getConnection();
		
		int listCount = new RecommendationDao().listCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Recommendation> pageinfoList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Recommendation> list = new RecommendationDao().pageinfoList(conn,pi);
		
		close(conn);
		
		return list;
	}

	public Recommendation selectDetail(String boardNo) {
		
		Connection conn = getConnection();
		
		Recommendation r = new RecommendationDao().selectDetail(conn,boardNo);
		
		close(conn);
		
		return r;
	}

	public Recommendation adminSelectBoard(int boardNo) {
		Connection conn = getConnection();
		
		Recommendation r = new RecommendationDao().adminSelectBoard(conn,boardNo);
		
		close(conn);
		
		return r;
	}

	public int updateRecommendationBoard(Recommendation r) {
		Connection conn = getConnection();
		
		int result = new RecommendationDao().updateRecommendationBoard(conn,r);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteRecommendationBoard(int boardNo) {
		Connection conn = getConnection();
		
		int result = new RecommendationDao().deleteRecommendationBoard(conn,boardNo);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	//조회수증가 메소드
	public int increaseCount(int boardNo) {
		Connection conn = getConnection();
		
		int result = new RecommendationDao().increaseCount(conn, boardNo); //처리된 행수(성공/실패)
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Recommendation selectBoard(int boardNo) {
		Connection conn = getConnection();
		
		Recommendation r = new RecommendationDao().selectBoard(conn, boardNo); //조회결과
		
		close(conn);
		
		return r;
	}

	public ArrayList<Recommendation> registerRecommendationCountryList() {
		Connection conn = getConnection();
		
		ArrayList<Recommendation>list = new RecommendationDao().registerRecommendationCountryList(conn);
		close(conn);
		
		return list;
	}

	public ArrayList<Recommendation> listArea1(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Recommendation>list = new RecommendationDao().listArea1(conn, pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Recommendation> listArea2(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Recommendation>list = new RecommendationDao().listArea2(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Recommendation> listArea3(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Recommendation>list = new RecommendationDao().listArea3(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Recommendation> listArea4(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Recommendation>list = new RecommendationDao().listArea4(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Recommendation> listArea5(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Recommendation>list = new RecommendationDao().listArea5(conn, pi);
		
		close(conn);
		
		return list;
	}

}
