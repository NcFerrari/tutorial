package ukoly5az8lekce.stredniPriklad;

public class Program {

    public static void main(String[] args) {
        Javista karel = new Javista("Karel Nový", 25, "InteliJ IDEA");
        System.out.println(karel);
        karel.behej(10);
        karel.behej(10);
        karel.programuj(5);
        karel.behej(10);
        karel.spi(8);
        karel.programuj(100);
    }
}
