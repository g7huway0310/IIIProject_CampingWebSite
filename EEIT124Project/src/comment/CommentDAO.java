package comment;

import java.sql.*;

public class CommentDAO {
	private Connection conn;

public CommentDAO(Connection conn) {
	this.conn = conn;
}


public boolean insertComment(CommentBean commentData) {
	try {
		String sqlString = "insert into Ranking values ('"
				+commentData.getCampgroundid()+"','"
				+commentData.getMemberid()+"','"
				+commentData.getRanking()+"','"
				+commentData.getContent()+ "')";
	
		  Statement stmt = conn.createStatement();
	      System.out.println(sqlString);
		    int updatecount = stmt.executeUpdate(sqlString);
	      stmt.close();
	      if (updatecount >= 1) return true;
	      else                  return false;
		  } catch (Exception e) {
		    System.err.println("新增資料失敗:" + e);
			  return false;
	    }
	  }


	}