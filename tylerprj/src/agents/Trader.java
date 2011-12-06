package agents;

import java.math.BigDecimal;
import java.util.HashMap;

import commodities.Resource;
import commodities.Values;

public class Trader extends Agent {
	HashMap<String, BigDecimal> priceTargets;
	public Trader(String name){
		super(name, "1000");
		//super.addResource( new Resource( "GLD", "10" ));
		priceTargets = new HashMap<String, BigDecimal>();
	}

	public Trader( String name, String money ){
		super(name, money);
		//super.addResource( new Resource( "GLD", "10" ));
		priceTargets = new HashMap<String, BigDecimal>();
	}
	
	public Trader addPriceTarget(String rsrcName, String price){
		priceTargets.put(rsrcName, new BigDecimal(price));
		return this;
	}
	
	public Trader addResource(String rsrcName, String qty){
		super.addResource( new Resource( rsrcName, qty ));
		return this;
	}

	public void operate( HashMap<String, Values> commodity){
		Values cc = commodity.get("GLD");
		Double priceTarget = priceTargets.get("GLD").doubleValue();
		Double price = cc.getCurrentPrice().doubleValue();
		BigDecimal newPrice = cc.getCurrentPrice();
		if( price > priceTarget){
			newPrice = new BigDecimal(price - 0.5);
			//cc.setNewPrice( new BigDecimal(price - 0.5));
		}else if( price < priceTarget){
			newPrice = new BigDecimal(price + 1.0);
			//cc.setNewPrice( new BigDecimal(price + 1.0));
		}
		cc.setNewPrice( newPrice );
		System.out.print(newPrice + " ");

	}
}
