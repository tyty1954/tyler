package agents;

import java.math.BigDecimal;
import java.util.HashMap;

import commodities.Values;

public class Consumer extends Agent {
	public Consumer(String name){
		super(name);
	}
	public void operate( HashMap<String, Values> commodity){
		Values cc = commodity.get("GLD");
		Double price = cc.getCurrentPrice().doubleValue();
		if( price < 5.0){
			cc.setNewPrice( new BigDecimal(price + 1.0));
		}
		//int temp = price.compareTo(new BigDecimal("5"));
		//if( price.compareTo(new BigDecimal("5")) ){
		//	cc.setNewPrice( price + 1.0);
		//}
	}
}
