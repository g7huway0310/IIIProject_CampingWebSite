package JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

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
   
   public  List<ShoppingProduct> searchtype(int selectWhich) {
	  
	   
       String[] typeArray = {"bedding","carpet","furniture","ice","lamp","tableware","tool"}; 
	   
	   List<ShoppingProduct> list=new ArrayList<ShoppingProduct>();
	   
	   String sqlString="select * from shoppingdata where PRODUCT_id like ?";	   
	   try( 
			Connection connection = getDataSource().getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sqlString);)
	        
	   {
		   
	   pstmt.setString(1,"%"+typeArray[selectWhich]+"%");
	   
	   ResultSet rs = pstmt.executeQuery();
	   
	   while (rs.next()) {
		    String id = rs.getString("PRODUCT_ID");
			String brand = rs.getString("PRODUCT_BRAND");
			String name = rs.getString("PRODUCT_NAME");
			int price = rs.getInt("PRODUCT_PRICE");
			String feature = rs.getString("PRODUCT_FEATURE");
			String spec = rs.getString("PRODUCT_SPEC");
			int stack = rs.getInt("PRODUCT_STACK");
			String warring = rs.getString("PRODUCT_WARRING");
			
		    ShoppingProduct product=new ShoppingProduct();

		    product.setProductBrand(brand);
		    product.setProductPrice(price);
		    product.setProductSpec(spec);
		    product.setProductStack(stack);
		    product.setProductType(typeArray[selectWhich]);
		    product.setProductWarring(warring);
		    product.setProductId(id);
		    list.add(product);
		    
		    System.out.println(product.getProductId());
		 }
	   
	   
	     
      } catch (SQLException e) {
	
    // TODO Auto-generated catch block
	e.printStackTrace();
}
	  
	return list;
}
  public String creatOrder(String productID) {
	   
	  
	   
	   
	   
	   
	   
	return null;
	
}
  public void updateData() {
	  try (Connection conn = getDataSource().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("update emp set commission=?,hiredate=?,job=?,ename=?,salary=?,version=version+1 where empno=? and version=?")
	        ) {

  
  
  } catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
   
   
   
   
  }}