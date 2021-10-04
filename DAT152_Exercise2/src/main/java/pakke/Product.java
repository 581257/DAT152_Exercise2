package pakke;

import java.util.List;

public class Product {
	private int pno;
	private String pName;
	private int priceInEuro;
	private List<Description> description;
	private int qty=1;
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
	public int getPriceInEuro() {
		return priceInEuro;
	}
	public void setPriceInEuro(int priceInEuro) {
		this.priceInEuro = priceInEuro;
	}
	public List<Description> getDescription() {
		return description;
	}
	public void setDescription(List<Description> description) {
		this.description = description;
	}
	public Product(int pno, String pName, int priceInEuro, List<Description> description) {
		super();
		this.pno = pno;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.description = description;
		
	}
	public int getQty() {
		return qty;
	}
	public void setQty() {
		this.qty++;
	}
	
	
	

	
	
	
	

}
