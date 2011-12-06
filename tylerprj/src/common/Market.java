package common;

import java.util.HashMap;

import agents.Agent;

import commodities.Values;

public class Market {
	HashMap<String, Agent> agents = new HashMap<String, Agent>();
	HashMap<String, Values> priceHistories = new HashMap<String, Values>();
	
	public Market addAgent(Agent agent ){
		this.agents.put( agent.getName(), agent );
		return this;
	}

	public Market addCommodity(String name, Values val ){
		this.priceHistories.put( name, val );
		return this;
	}
	
	public Values getCommodity(String name){
		return priceHistories.get(name);
	}
	
	public Market run(){
		for( int i=0; i<20; i++ ){
			for( Values priceHistory : priceHistories.values() ){
				priceHistory.add();
			}
			for( Agent agent : agents.values() ){
				agent.operate(priceHistories);
			}
			//for( Values priceHistory : priceHistories.values() ){
			//	priceHistory.print();
			//}
			System.out.println(" ");
		}
		Values priceHistory = priceHistories.get("GLD");
		priceHistory.print();
		return this;
	}
}
