package shoppingMall;

import java.io.Serializable;

public class Cooking implements Serializable {
	
	private String cID;
	private String cName;
	private int cPrice;
	private String cBrand;
	private String cSpec;
	private String warning;
	private int tQty;
	
	public Cooking(String cID, String cName){
		this.cID = cID;
		this.cName = cName;
		
	}
	
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcPrice() {
		return cPrice;
	}
	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}
	public String getcBrand() {
		return cBrand;
	}
	public void setcBrand(String cBrand) {
		this.cBrand = cBrand;
	}
	public String getcSpec() {
		return cSpec;
	}
	public void setcSpec(String cSpec) {
		this.cSpec = cSpec;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	public int gettQty() {
		return tQty;
	}
	public void settQty(int tQty) {
		this.tQty = tQty;
	}

}
