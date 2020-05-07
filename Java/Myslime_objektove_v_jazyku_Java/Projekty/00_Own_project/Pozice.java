public class Pozice {
    
    private int x;
    private int y;
    
    public Pozice(int x, int y) {
        setPozice(x, y);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setPozice(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setPozice(Pozice pozice) {
        setPozice(pozice.getX(), pozice.getY());
    }
}
