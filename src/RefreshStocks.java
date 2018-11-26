import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RefreshStocks extends Thread{

    private Set<Stock> stocks;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public RefreshStocks(){
        this.stocks = new HashSet<>();

        scheduler.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                refresh();
            }
        }, 5, 5, TimeUnit.SECONDS);
    }

    private boolean refresh(){
        for (Stock s : stocks) {
            try {
                s.setPricePerShare(Double.parseDouble(StrathQuoteServer.getLastValue(s.getTickerSymbol())));
            } catch (WebsiteDataException e) {
                System.out.println("Error connected to website.");
                System.out.println(e.getMessage());
                return false;
            } catch (NoSuchTickerException e) {
                System.out.println("A stock with the ticker symbol " + s.getTickerSymbol() + " does not exist on the server.");
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public Set<Stock> getStocks(){
        return stocks;
    }
}
