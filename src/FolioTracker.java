import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FolioTracker {
	private static Double sampleTicker;
	private static List<String> stocks;
	private static List<Double> stockValue;
	private static List<Double> maxStockValue;
	private static List<Double> minStockValue;
	
	private final ScheduledExecutorService scheduler =
		     Executors.newScheduledThreadPool(1);
	
	public static void main(String[] args){				
		new FolioTracker();		
	}	
	
	FolioTracker(){
		init();
		System.out.print(stockValue);			
		scheduler.scheduleWithFixedDelay(new Runnable() {
		    public void run() {
		        System.out.println("stocks: " + stocks + "\n" +  update());
		    }
		}, 5, 5 , TimeUnit.SECONDS);
		
	}
			
	private void init(){
		stocks = new ArrayList<String>() {
			{
				add("AAPL");
				add("TSLA");
				add("AMZN");
				add("ADS");
			}
			
		};
		stockValue = new ArrayList<Double>(){			
			{
				add(0.0);
				add(0.0);
				add(0.0);
				add(0.0);
			}
		};
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
			System.err.println(e);			
		}
		return stockValue;
	}


}
