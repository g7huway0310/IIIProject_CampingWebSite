package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.sun.xml.internal.fastinfoset.util.StringArray;

public class shoppingdataJDBC {
	
   private DataSource dataSource;
   
   //init DB
   public DataSource getDataSource() {
	
		if (dataSource==null) {
			BasicDataSource ds = new BasicDataSource();
		    ds.setDriverClassName("oracle.jdbc.OracleDriver");
		    ds.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
		    ds.setUsername("scott");
		    ds.setPassword("tiger");
		    ds.setMaxTotal(50); 
		    ds.setMaxIdle(50);   
		    dataSource=ds;
		   
		}
		return dataSource;
	}
	
   
   //依照品牌搜尋全部商品
   public StringBuffer SearchBrandItem(String brand) {
	   
   StringBuffer searchResult=new StringBuffer();
		
   String sqlString="select * from shoppingdata where PRODUCT_BRAND like ?";	   
   try( 
		Connection connection = getDataSource().getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sqlString);)
     
   {
	 pstmt.setString(1,"%"+brand+"%");
	 ResultSet rs = pstmt.executeQuery();
	 
	 
	 
	 while (rs.next()) {
	      String name = rs.getString("PRODUCT_NAME");
	      String brands = rs.getString("PRODUCT_BRAND");
	      int price = rs.getInt("PRODUCT_PRICE");
	      String feature = rs.getString("PRODUCT_FEATURE");
	      int stack = rs.getInt("PRODUCT_STACK");
	      
	      searchResult.append("商品品牌: "+brands+"\n"+
	    		              "商品名稱: "+name+"\n"+	    		             
	    		              "商品價格: "+String.valueOf(price)+"\n"+
	    		              "商品庫存: "+feature+String.valueOf(stack)+"\n");

	 }
     System.out.println(searchResult);
	 
     

   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     return searchResult;
	}
   
   public StringBuffer searchtype(int type) {
	   
	   StringBuffer searchResult=new StringBuffer();
	   
	   String[] typeArray= {"carpet","bedding","furniture","ice","lamp","tableware","tool"};
       
	   System.out.println(typeArray[type]);
	   
	   String sqlString="select * from shoppingdata where PRODUCT_id like ?";	   
	   try( 
			Connection connection = getDataSource().getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sqlString);)
	     
	   {
	     
      } catch (SQLException e) {
	
    // TODO Auto-generated catch block
	e.printStackTrace();
}
	return searchResult;

}
}