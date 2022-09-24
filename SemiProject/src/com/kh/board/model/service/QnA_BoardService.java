package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.QnA_BoardDao;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.QnA_Board;
import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class QnA_BoardService {

	public int selectListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new QnA_BoardDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	public ArrayList<QnA_Board> selectList(PageInfo pi) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<QnA_Board> list = new QnA_BoardDao().selectList(conn,pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

	public ArrayList<Category> selectCategoryList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Category> list = new QnA_BoardDao().selectCategoryList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
		
		
	}

	public int insertBoard(QnA_Board b) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnA_BoardDao().insertBoard(conn,b);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	public QnA_Board selectBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		QnA_Board b = new QnA_BoardDao().selectBoard(conn, boardNo);
		
		JDBCTemplate.close(conn);
		
		return b;
	}

	public int updateBoard(QnA_Board b) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnA_BoardDao().updateBoard(conn,b);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteBoard(int boardNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnA_BoardDao().deleteBoard(conn,boardNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public QnA_Board adminselectBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		QnA_Board b = new QnA_BoardDao().adminselectBoard(conn, boardNo);
		
		JDBCTemplate.close(conn);
		
		return b;
	}

	public ArrayList<Reply> selectReplyList(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Reply> list =new QnA_BoardDao().selectReplyList(conn,boardNo);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

	public int insertReply(Reply r) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new QnA_BoardDao().insertReply(conn,r);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int updateupdateAnswerStatus(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new QnA_BoardDao().updateAnswerStatus(conn,boardNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	

}
