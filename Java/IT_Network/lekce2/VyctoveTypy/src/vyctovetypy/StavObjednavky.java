package vyctovetypy;

public enum StavObjednavky {

    NOVA("Nová objednávka"),
    PRIJATA("Objednávka byla přijata ke zpracování"),
    POTVRZENA("Objednávka byla potvrzena"),
    DOKONCENA("Zboží bylo expedováno");

    private String note;

    private StavObjednavky(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

}
