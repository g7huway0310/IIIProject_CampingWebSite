package shoppingMall;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	
	private Map<String,CartItem> ProductMap = new LinkedHashMap<>();
	
	private double price;
	
	public void addProduct(Product product) {
		CartItem cartItem = ProductMap.get(product.getpID());
		
		if(cartItem == null) {
			cartItem = new CartItem();
			
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			ProductMap.put(product.getpID(), cartItem);
			}else {
				
		
		}
	}

}
