package common;

import java.util.HashMap;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import agents.*;
import commodities.*;

/*
 * TRY TO IMPLEMENT DETLEV'S EXAMPLES
 * 
 * o implement Agent.buy(), sell()
 * o write all/most agents in GROOVY - copy existing groovy code.
 * change all to BigDecimal
 * 1.) create money 		distribution for all traders (const ? )
 * 2.) create supply 		distribution for all traders (const ? )
 * 3.) create target price	distribution for all traders
 * 		- if target price < market price, sell
 * 		- if target price > market price, buy
 * 		- amount depends on delta, momentum, ... hold
 * 4.) Market.discoverPrice()
 * 	- the seller with the lowest (asking) price is matched to a buyer with the highest (bid) price
 *  - the closing price is the highest transacted bid at the end to the iteration
 *  - write unit tests for all cases
 *  - read stock market rules.
 *  5.) adjust target based on closing price (momentum, ...)
 *  6.) update chart of price
 *  7.) plot in frequency space (Excel ? - check previous work in skin response)
 * MomentumTrader
 * BuyLoSellHiTrader
 * enable PID for all Agents
 * PID with varying time horizons (integration and derivative)
 */
public class MarketTest {
	HashMap<String, Agent> agents = new HashMap<String, Agent>();
	//HashMap<String, Values> commodityPriceHistory = new HashMap<String, Values>();
	
	@Test
	public void createAgentsAndRun(){
		Market market = new Market();
		
		Trader trader1 = new Trader("T1", "1000");
		trader1.addResource("GLD", "10")
		.addPriceTarget("GLD", "10");
		market.addAgent(trader1);
		
		Trader trader2 = new Trader("T2", "1000");
		trader2.addResource("GLD", "10")
		.addPriceTarget("GLD", "20"); // TODO clone with target of 20
		market.addAgent(trader2)
		.addCommodity("GLD", new Values("1"))
		.run();	
		assertTrue( true );
	}
}
