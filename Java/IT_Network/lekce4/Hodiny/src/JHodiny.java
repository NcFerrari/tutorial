
import java.awt.Graphics;
import javax.swing.JComponent;

public class JHodiny extends JComponent {

    private Hodiny hodiny;

    public JHodiny(Hodiny hodiny) {
        super();
        this.hodiny = hodiny;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        hodiny.vykresli(g);
    }
}
