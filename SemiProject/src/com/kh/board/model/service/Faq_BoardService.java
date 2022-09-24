package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.Faq_BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;

public class Faq_BoardService {

	public ArrayList<Board> mainPage() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().mainPage(conn);
		
		close(conn);
		
		return list;
	}

	public Board selectBoard (int boardNo) {
		Connection conn=getConnection();
		
		Board b = new Faq_BoardDao().selectBoard(conn, boardNo);
		
		return b;
	}

	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new Faq_BoardDao().insertBoard(conn,b);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();
		
		ArrayList<Category> list =  new Faq_BoardDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
		
	}
	public int updateBoard(Board b) {
		Connection conn =getConnection();
		int result = new Faq_BoardDao().updateBoard(conn,b);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int deleteBoard(int faqNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		int result = new Faq_BoardDao().deleteBoard(conn,faqNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
		
	}
	//해외시작
	public ArrayList<Board> out1Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().out1Page(conn);
		
		close(conn);
		
		return list;
		
	}

	public ArrayList<Board> out2Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().out2Page(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Board> out3Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().out3Page(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Board> out4Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().out4Page(conn);
		
		close(conn);
		
		return list;
	}//해외끝
	//국내  시작
	public ArrayList<Board> in1Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().in1Page(conn);
		
		close(conn);
	
		return list;
	}

	public ArrayList<Board> in2Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().in2Page(conn);
		
		close(conn);
	
		return list;
	}

	public ArrayList<Board> in3Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().in3Page(conn);

		close(conn);
	
		return list;
	}

	public ArrayList<Board> in4Page() {
		// TODO Auto-generated method stub
		Connection conn =getConnection();
		
		ArrayList<Board> list = new Faq_BoardDao().in4Page(conn);

		close(conn);
	
		return list;
	}

	
}