package pakke;

import java.util.List;

public class Product {
	private int pno;
	private String pName;
	private String priceInEuro;
	private List<Description> description; 
	//imagefile?
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getPriceInEuro() {
		return priceInEuro;
	}
	public void setPriceInEuro(String priceInEuro) {
		this.priceInEuro = priceInEuro;
	}
	public List<Description> getDescription() {
		return description;
	}
	public void setDescription(List<Description> description) {
		this.description = description;
	}
	public Product(int pno, String pName, String priceInEuro, List<Description> description) {
		super();
		this.pno = pno;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.description = description;
	}
	
	
	
	
	

}
