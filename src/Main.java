import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Thread tester = new Thread(){
            public void run(){
                FolioTracker tracker = new FolioTracker();
                tracker.createFolio("TEST");
                tracker.getFolio("TEST").addStock("AORGF", "Argos", 0.00, 0, true);
                tracker.getFolio("TEST").addStock("TSLA", "Tesla", 0.00, 0, true);
                tracker.getFolio("TEST").addStock("MSFT", "Microsoft", 0.00, 0, true);
                tracker.getFolio("TEST").addStock("AAPL", "Apple", 0.00, 0, true);

                while(!isInterrupted()){
                    try {
                        tracker.getFolio("TEST").getTimer().join();
                        System.out.println("STOCKS AT TIME: " + Calendar.getInstance().getTime());
                        for (Stock s : tracker.getFolio("TEST").getStocks()) {
                            System.out.println(s.getName() + "\t\t" + s.getTickerSymbol() + "\t\t" + s.getPricePerShare() + "\t\t" + s.getNumOfShares() + "\t\t" + s.getValue() + "\t\t" + s.getChange() + "\n");
                        }
                        sleep(1000);
                    } catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        };

        tester.start();
    }
}
