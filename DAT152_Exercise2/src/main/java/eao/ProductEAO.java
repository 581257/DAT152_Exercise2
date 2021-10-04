package eao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import pakke.Description;
import pakke.Product;

//mock eao
public class ProductEAO {
	List<Product> prod = Arrays.asList( 
			new Product( 1111, "White cup", "1234", Arrays.asList(new Description("en_US", "english text................"), new Description("no_NO", "norsk tekst.................."))),
			new Product(2222, "Black cup", "5678", Arrays.asList(new Description("en_US", "english text................."), new Description("no_NO", "norsk tekst................"))) 
			);
	
	public List<Product> getAll() {
		return prod;
	}
	
	public Product getProduct(int pno) {
		return prod.stream().filter(p->p.getPno()==pno).collect(Collectors.toList()).get(0);
	}
	
	
	

}
