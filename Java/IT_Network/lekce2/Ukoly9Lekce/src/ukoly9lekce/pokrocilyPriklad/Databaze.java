package ukoly9lekce.pokrocilyPriklad;

public class Databaze {

    private static Databaze databaze;

    private String dataSourceName = "MySQL";

    private Databaze() {

    }

    public static Databaze getInstance() {
        if (databaze == null) {
            databaze = new Databaze();
        }
        return databaze;
    }

    public String getDatabaze() {
        return dataSourceName;
    }
}
