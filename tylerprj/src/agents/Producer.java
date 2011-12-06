package agents;

import java.math.BigDecimal;
import java.util.HashMap;

import commodities.Values;
// TODO Producer<T> // T is a RawMaterial
public class Producer extends Agent {
	public Producer(String name){
		super(name);
	}
	public void operate( HashMap<String, Values> commodity ){
		Values cc = commodity.get("GLD");
		Double price = cc.getCurrentPrice().doubleValue();
		if( price > 4.0){
			cc.setNewPrice( new BigDecimal(price - 0.5));
		}
	}
}
