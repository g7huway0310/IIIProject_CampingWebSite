package shoppingMall;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CookingDAO {
	
	private Connection connection;
	
	public CookingDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	
	
	
	
	
	public Cooking findCooking(String cName) {
		try {
			Cooking cooking = null;
			String cID = null;
			
			Statement stmt = connection.createStatement();
			String sqlString = "SELECT ID,PNAME,PRICE,BRAND,QTY "+
					" From MALLCOOKING Where PNAME like"+ "'%"+ cName +"%'";
			
			System.out.println(sqlString);
			
			ResultSet rs = stmt.executeQuery(sqlString);
			
			if(rs.next()) {
				
				cName = rs.getString("PNAME");
				cooking = new Cooking(cID,cName); 
			}
			rs.close();
			stmt.close();
			return cooking;
			
		}catch(Exception e) {
			System.err.println("尋找部門資料時發生錯誤:" + e);
		    return null;
		}
		
	}

}
