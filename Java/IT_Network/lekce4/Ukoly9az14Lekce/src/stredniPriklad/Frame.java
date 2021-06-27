package stredniPriklad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class Frame extends JComponent {

    private boolean showLines = true;
    private final FrameModel model;

    public Frame(FrameModel model) {
        this.model = model;
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                paint(evt.getX(), evt.getY());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                paint(evt.getX(), evt.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < model.getHeight(); i++) {
            for (int j = 0; j < model.getWidth(); j++) {
                Color color = model.getColors()[i][j];
                if (color != null) {
                    g.setColor(color);
                    g.fillRect(j * model.getFieldWidth(), i * model.getFieldHeight(), model.getFieldWidth(), model.getFieldHeight());
                }
            }
        }
        if (showLines) {
            g.setColor(Color.BLACK);
            for (int i = 0; i <= model.getFrameWidth(); i += model.getFieldWidth()) {
                g.drawLine(i, 0, i, getHeight());
            }
            for (int i = 0; i <= model.getFrameHeight(); i += model.getFieldHeight()) {
                g.drawLine(0, i, getWidth(), i);
            }
        }
    }

    public void showLines(boolean showLines) {
        this.showLines = showLines;
        repaint();
    }

    private void paint(int x, int y) {
        int xField = x / model.getFieldWidth();
        int yField = y / model.getFieldHeight();
        if (xField < model.getColors()[0].length && yField < model.getColors().length) {
            model.paintPixel(xField, yField);
        }
        repaint();
    }
}
