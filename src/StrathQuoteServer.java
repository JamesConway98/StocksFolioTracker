import java.net.*;
import java.io.*;

/**
 * StrathQuoteServer is a utility class that allows calling code to retrieve the
 * latest market value of a given stock by ticker symbol. The QuoteServer
 * obtains the stock value by using the website: <a
 * href="http://www.tickertech.com"> <tt>http://www.tickertech.com</tt> </a>
 * <Br>
 * Examples of ticker symbols are <tt>MSFT</tt> and <tt>orcl</tt>. (Note
 * that ticker symbols are not case sensitive. That is that "MSFT" and "msft"
 * are functionally equivalent.)
 * <p>
 * 
 * A valid ticker symbol is one that is currently registered with either the New
 * York Stock Exchange (NYSE) or NASDAQ.
 */

public class StrathQuoteServer {

    protected static final String _URL = "http://www.tickertech.com/cgi/?ticker=";

    protected static final String _TOKEN1a = new String("ticker=");

    protected static final String _TOKEN1b = new String("&a=detailed");

    protected static String _TOKEN1 = new String();

    /**
     * 
     * retrieve the latest market value of a stock
     * 
     * @requires: tickerSymbol != null
     * @effects: returns a current value for tickerSymbol as a dollar amount,
     *           with a period separating dollars and cents (eg, "120.50" for
     *           one hundred and twenty dollars and fifty cents) <BR>
     *           unless tickerSymbol is not a valid NYSE or NASDAQ symbol, when
     *           throws NoSuchTickerException <br>
     *           or unless an error connecting to the website or some other
     *           error occurs, when throws WebsiteDataException <BR>
     *           The amount returned may contain commas, for example, "2,243.87"
     *           <br>
     */
    public static String getLastValue(String tickerSymbol)
            throws WebsiteDataException, NoSuchTickerException {
        _TOKEN1 = _TOKEN1a + tickerSymbol.toUpperCase() + _TOKEN1b;
        String strURLStart = _URL;
        URL urlWebPage = null;
        InputStreamReader isr = null;
        BufferedReader brWebPage = null;

        // open the web page for reading
        try {
			urlWebPage = new URL(strURLStart + tickerSymbol);
            isr = new InputStreamReader(urlWebPage.openStream());

            brWebPage = new BufferedReader(isr);
        } catch (Exception e) {
            throw new WebsiteDataException();
        }

        // find the line with the stock quote on it
        String strLine = null;
        try {

            while (true) {
                strLine = brWebPage.readLine();
                if (strLine == null) {
                    throw new WebsiteDataException("Parse failed!");
                }
                if (strLine.indexOf(_TOKEN1) != -1) {
                    System.out.println("found token");
                    brWebPage.readLine();
                    strLine = brWebPage.readLine(); //move down two lines
                    break;
                }

            }
        } catch (IOException e) {
            throw new WebsiteDataException();
        }

        // find the stock quote in the line
        int a = strLine.indexOf("<b>");
        int b = strLine.indexOf("</b>");
        String strStockValue = strLine.substring(a + 3, b);

        // close the web page stream
        try {
            brWebPage.close();
            isr.close();
        } catch (IOException e) {
            throw new WebsiteDataException();
        }

        return strStockValue;
    }
}

class WebsiteDataException extends Exception {
    WebsiteDataException() {
    }

    WebsiteDataException(String s) {
        super(s);
    }
}

class NoSuchTickerException extends Exception {
    NoSuchTickerException() {
    }

    NoSuchTickerException(String s) {
        super(s);
    }
}