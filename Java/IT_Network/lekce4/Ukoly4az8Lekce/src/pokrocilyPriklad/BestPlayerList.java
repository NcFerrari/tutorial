package pokrocilyPriklad;

import javax.swing.DefaultListModel;

public class BestPlayerList {

    private static DefaultListModel<String> players = new DefaultListModel<>();

    public static DefaultListModel<String> getPlayers() {
        return players;
    }

    public static void addPlayer(String player, int tips) {
        players.addElement(String.format("%s - počet chyb: %d", player, tips));
    }
}
