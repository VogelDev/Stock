package chaos.list;

public class StockQuote {
    //ID
    private String id;
    //Symbol
    private String symbol;
    //Last quote
    private double lastPrice;
    //Last update
    private String lastTrade;
    //Shares
    private int shares;
    //Total spent
    private double totalCost;
    //Average share worth;
    private double sharePrice;
    
    /**
     * Creates new object with initial data.
     */
    public StockQuote(String id, String symbol, double lastPrice, String lastTrade){
        this.id = id;
        this.symbol = symbol;
        this.lastPrice = lastPrice;
        this.lastTrade = lastTrade;
        shares = 0;
    }
    
    @Override
    public String toString() {
        
        //loss/gain
        double difference = totalCost - (lastPrice * shares);
        
        return symbol + "\t" + shares + "\n" + lastPrice + "\t" + difference;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSymbol() {
        return t;
    }
    public void setSymbol(String t) {
        this.t = t;
    }
    public double getLastPrice() {
        return l;
    }
    public void setLastPrice(double l) {
        lastPrice = l;
    }
    public String getLastTrade() {
        return elt;
    }
    public void setLastTrade(String elt) {
        lastTrade = elt;
    }
    public int getShares(){
        return shares;
    }
    public void setShares(int shares){
        this.shares = shares;
    }
    public void addShares(int shares, double price){
        
        this.shares += shares;
        totalCost += (shares * price);
        sharePrice = totalCost / shares;
    }
    public double sellShares(int shares){
        
        this.shares -= shares;
        worth = shares * lastPrice;
        totalCost -= worth;
        sharePrice = totalCost / this.shares;
        
        return worth;
    }
}
