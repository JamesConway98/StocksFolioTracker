import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class refreshData {
	private  Double sampleTicker;
	private static List<String> stocks;
	private  List<Double> stockValue, minStockValue, maxStockValue;
	private final ScheduledExecutorService scheduler =
		     Executors.newScheduledThreadPool(1);
	
	refreshData(List<String> s){
		stocks = s;
		
		init(); 
		scheduler.scheduleWithFixedDelay(new Runnable() {
		    public void run() {
		        System.out.println("stocks: " + stocks + "\n" +  update());
		    }
		}, 5, 5 , TimeUnit.SECONDS);
		
	}
		
	/*
	 * We need to fill the arraylist with garbage before i can use set()
	 * once we get the file reader, we won't need to use init() we can set values
	 * from file instead.
	 */
	
	private void init(){
		stockValue = new ArrayList<Double>();
		for(int i = 0; i < stocks.size(); i++) {
			stockValue.add(0.0000);
		}

		maxStockValue = new ArrayList<Double>(){			
			{
				add(0.0);
				add(0.0);
				add(0.0);
				add(0.0);
			}
	};
		minStockValue = new ArrayList<Double>(){			
			{
				add(0.0);
				add(0.0);
				add(0.0);
				add(0.0);
			}
		};
	}
	
	private List<Double> update(){
		try {
			for(int i =0; i < stocks.size(); i++){
				sampleTicker = Double.valueOf(StrathQuoteServer.getLastValue(stocks.get(i)));
				stockValue.set(i, sampleTicker);								
				// if new max, set new max
				if(stockValue.get(i) > maxStockValue.get(i)){
					maxStockValue.set(i, stockValue.get(i));
				} // if new min, set new min
				if(stockValue.get(i) < minStockValue.get(i)){
					minStockValue.set(i, stockValue.get(i));
				}
			}
		} catch (Exception e) {
			System.err.println(e + "something went wrong");			
		}
		return stockValue;
	}
	


}
