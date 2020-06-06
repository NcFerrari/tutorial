package lp.cesky.tvary;



public class Kruh extends Elipsa {
    
    public Kruh() {
        this(0, 0, AP.getKrok());
    }
    
    public Kruh (int x, int y, int rozmer) {
        super(x, y, rozmer, rozmer);
    }
    
    public void setRozmer(int rozmer) {
        super.setRozmer(rozmer, rozmer);
    }
    
    @Override
    public void setRozmer(int sirka, int vyska) {
        int rozmer = Math.min(sirka, vyska);
        setRozmer(rozmer);
    }
}
