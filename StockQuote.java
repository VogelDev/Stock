package chaos.list;

public class StockQuote {
    //ID
    private String id;
    //Symbol
    private String t;
    //Last quote
    private double l;
    //Last update
    private String elt;
    @Override
    public String toString() {
        return "StockQuote [id=" + id + ", t=" + t + ", l=" + l
                + ", elt=" + elt + "]";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getT() {
        return t;
    }
    public void setT(String t) {
        this.t = t;
    }
    public double getL() {
        return l;
    }
    public void setL(double l) {
        this.l = l;
    }
    public String getElt() {
        return elt;
    }
    public void setElt(String elt) {
        this.elt = elt;
    }
}
