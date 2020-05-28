package lp.cesky.priklady;

public class Sipka {
    
    private ISipka sipka;
    
    public Sipka() {
        sipka = new SipkaVychod(50, 62, 50, 25, lp.cesky.tvary.Barva.CERVENA, 20);
    }
    
    public void vpravoVbok() {
        sipka = sipka.vpravoVbok();
    }
    
    public void vlevoVbok() {
        sipka = sipka.vlevoVbok();        
    }
    
    public void vpred() {
        sipka.vpred();
    }
}
