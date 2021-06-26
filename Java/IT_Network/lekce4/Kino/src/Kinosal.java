
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Kinosal extends JComponent {

    private static final int SIZE = 25;
    private static final int SPACE = 4;

    private boolean[][] places = new boolean[30][15];

    public Kinosal(int width, int height) {
        setSize(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                if (places[i][j]) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.GREEN);
                }
                g.fillRect(i * (SIZE + SPACE), j * (SIZE + SPACE), SIZE, SIZE);
            }
        }
    }

    public void prepniStav(int x, int y) {
        places[x][y] = !places[x][y];
    }

    public void klikni(int x, int y) {
        int px = x / (SIZE + SPACE);
        int py = y / (SIZE + SPACE);
        if (px < places.length && py < places[0].length) {
            prepniStav(px, py);
        }
    }

    public String getState() {
        String output = "";
        int used = 0;
        for (int i = 0; i < places[0].length; i++) {
            for (int j = 0; j < places.length; j++) {
                if (places[j][i]) {
                    output += "1";
                    used++;
                } else {
                    output += "0";
                }
            }
            output += "\n";
        }
        output += "Obsazených: " + used + "\nVolných: " + (places.length * places[0].length - used);
        return output;
    }
}
