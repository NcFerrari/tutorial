package lp.cesky.tvary;



public class Ctverec extends Obdelnik {
    
    public Ctverec() {
        this(0, 0, AP.getKrok());
    }
    
    public Ctverec(int x, int y, int rozmer) {
        super(x, y, rozmer, rozmer);
        AP.pridej(this);
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
