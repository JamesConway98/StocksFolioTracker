import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FolioTracker {
	private static String sampleTicker;
	private static List<String> stocks;
	private final ScheduledExecutorService scheduler =
		     Executors.newScheduledThreadPool(1);
	
	public static void main(String[] args){				
		new FolioTracker();		
	}	
	
	FolioTracker(){
		init();
		scheduler.scheduleWithFixedDelay(new Runnable() {
		    public void run() {
		        System.out.println("scheduleWithFixedDelay: " + update());
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
	}
	
	private List<String> update(){
		try {
			for(int i =0; i < stocks.size(); i++){
				sampleTicker = StrathQuoteServer.getLastValue(stocks.get(i));
				stocks.set(i, sampleTicker);
			}
		} catch (Exception e) {
			System.err.println(e);
			
		}return stocks;
	} 
}

