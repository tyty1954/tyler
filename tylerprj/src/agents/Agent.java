package agents;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import commodities.Values;
import commodities.Resource;

public abstract class Agent {
	//HashMap<String, Commodity> resources = new HashMap<String, Commodity>();
	public String name;
	BigDecimal money;
	ArrayList<Resource> resources;
	
	public Agent(String name ){
		this.name = name;
		money = new BigDecimal(1000.0);
		resources = new ArrayList<Resource>();
	}
	public Agent( String name, BigDecimal money ){
		this.name = name;
		this.money = money;
		resources = new ArrayList<Resource>();
	}
	public Agent( String name, String money ){
		this.name = name;
		this.money = new BigDecimal(money);
		resources = new ArrayList<Resource>();
	}

	public abstract void operate( HashMap<String, Values> marketVar );
	
	//adjust portfolio after buy
	public void buy( String name, BigDecimal price, BigDecimal qty ){
		Double moneyd = money.doubleValue();
		if( moneyd <= 0 )
			return;
		BigDecimal sub = price.multiply(qty);
		Double subd = sub.doubleValue();
		if( (moneyd - subd) >= 0){
			money = money.subtract(sub);
		}else{
			money = BigDecimal.ZERO;
		}		
	}

	//adjust portfolio after buy
	public void sell( Values cm, Double qty ){
		
	}
	
	protected Agent addResource( Resource rsrc ){
		resources.add( rsrc );
		return this;
	}
	public String getName(){ return name; }
}
