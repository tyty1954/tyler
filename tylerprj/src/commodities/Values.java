package commodities;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Values {
	
	public ArrayList<BigDecimal> priceHistory;
	
	public Values(){
		priceHistory = new ArrayList<BigDecimal>();
		priceHistory.add( new BigDecimal( 0.0 ));
	}
	
	public Values( String price ){
		priceHistory = new ArrayList<BigDecimal>();
		priceHistory.add( new BigDecimal( price ));
	}
	
	public Values add(){
		priceHistory.add( new BigDecimal( 0.0 ));
		return this;
	}
	
	public BigDecimal getCurrentPrice(){
		return priceHistory.get(priceHistory.size()-2);
	}

	public void setNewPrice( BigDecimal price ){
		priceHistory.set(priceHistory.size()-1, price );
	}
	
	public void print(){
		for(BigDecimal p : priceHistory){
			System.out.print(p + " ");
		}
		System.out.println(" ");
	}
}
