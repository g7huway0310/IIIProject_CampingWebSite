package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try ( Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.1.132:1521/XEPDB1","project2", "project2");
				
        ) {
		System.out.println("query finished");
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
    }

}