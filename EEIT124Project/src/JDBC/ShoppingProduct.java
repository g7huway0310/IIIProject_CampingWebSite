package JDBC;

public class ShoppingProduct {
	
	 String productId;
	 String productBrand;
	 String productName;
	 int productPrice;
	
	 String productSpec;
     int productStack;
	 String productWarring;
	
	int people;
	
	public ShoppingProduct(String productId, String productBrand, String productName, int productPrice,
			String productSpec, int productStack, String productWarring) {
		super();
		this.productId = productId;
		this.productBrand = productBrand;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSpec = productSpec;
		this.productStack = productStack;
		this.productWarring = productWarring;
	}
	
	public ShoppingProduct(int people,String productId, String productBrand, String productName, int productPrice,
			String productSpec, int productStack, String productWarring) {
		this.people=people;
		this.productId = productId;
		this.productBrand = productBrand;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSpec = productSpec;
		this.productStack = productStack;
		this.productWarring = productWarring;
	}
	
	
	
	
	
}
