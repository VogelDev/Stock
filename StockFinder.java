package chaos.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.stream.JsonReader;

public class StockFinder {

    /**
     * Searches Google Finance for the stock symbol given
     * @param symbol
     * @return
     * @throws Exception
     * 
     */
    public static StockQuote getQuote(String symbol) {

        String json = null;
        try {
            json = readUrl("https://www.google.com/finance/info?q=" + symbol);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        StockQuote quote = new StockQuote();
        try {
            JsonReader reader = new JsonReader(new StringReader(json));
            reader.setLenient(true);
            reader.beginObject();

            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("id")) {
                    quote.setId(reader.nextString());
                } else if (name.equals("t")) {
                    quote.setT(reader.nextString());
                } else if (name.equals("l")) {
                    quote.setL(reader.nextDouble());
                } else if (name.equals("elt")) {
                    quote.setElt(reader.nextString());
                } else {
                    reader.skipValue(); // avoid some unhandle events
                }
            }

            reader.endObject();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return quote;
    }
    
    private static String readUrl(String urlString) {
        BufferedReader reader = null;
        StringBuffer buffer = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        if(buffer != null)
            return buffer.toString();
        else
            return null;
    }

}
