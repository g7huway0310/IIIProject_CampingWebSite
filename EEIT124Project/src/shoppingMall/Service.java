package shoppingMall;

import java.util.ArrayList;
import java.util.List;

import JDBC.ShoppingProduct;
import JDBC.shoppingdataJDBC;

public class Service {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shoppingdataJDBC jdbcDB=new shoppingdataJDBC();
		
		jdbcDB.SearchBrandItem("MP");//依照品牌顯示產品
		
		List<ShoppingProduct> typeofwhichProduct = jdbcDB.searchtype(1);//顯示類別
	    
		System.out.println(typeofwhichProduct.get(0).getProductStack());
		int updateData = jdbcDB.updateData(typeofwhichProduct.get(0), 2);
		System.out.println(updateData);
		
		

	}

}
