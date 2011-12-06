package commodities;

import java.math.BigDecimal;

public class Resource {
	String name;
	BigDecimal qty;
	
	public Resource( String name, BigDecimal qty ){
		this.name = name;
		this.qty = qty;
	}
	
	public Resource( String name, String qty ){
		this.name = name;
		this.qty = new BigDecimal(qty);
	}
}
