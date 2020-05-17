

public class Oblast {
    
    private int x;
    private int y;
    private int sirka;
    private int vyska;
    
    public Oblast() {
        
    }
    
    public Oblast(int x, int y, int sirka, int vyska) {
        setOblast(x, y, sirka, vyska);
    }
    
    public Oblast(Pozice pozice, Rozmer rozmer) {
        setOblast(pozice, rozmer);
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getY() {
        return y;
    }
    
    public void setSirka(int sirka) {
        this.sirka = sirka;
    }
    
    public int getSirka() {
        return sirka;
    }
    
    public void setVyska(int vyska) {
        this.vyska = vyska;
    }
    
    public int getVyska() {
        return vyska;
    }
    
    public void setPozice(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void setPozice(Pozice pozice) {
        setPozice(pozice.getX(), pozice.getY());
    }
    
    public Pozice getPozice() {
        return new Pozice(getX(), getY());
    }
    
    public void setRozmer(int sirka, int vyska) {
        setSirka(sirka);
        setVyska(vyska);
    }
    
    public void setRozmer(Rozmer rozmer) {
        setRozmer(rozmer.getSirka(), rozmer.getVyska());
    }
    
    public Rozmer getRozmer() {
        return new Rozmer(getSirka(), getVyska());
    }
    
    public void setOblast(int x, int y, int sirka, int vyska) {
        setPozice(x, y);
        setRozmer(sirka, vyska);
    }
    
    public void setOblast(Pozice pozice, Rozmer rozmer) {
        setOblast(pozice.getX(), pozice.getY(), rozmer.getSirka(), rozmer.getVyska());
    }
    
    public void setOblast(Oblast o) {
        setOblast(o.getX(), o.getY(), o.getSirka(), o.getVyska());
    }
    
    public Oblast getOblast() {
        return new Oblast(getX(), getY(), getSirka(), getVyska());
    }
}
