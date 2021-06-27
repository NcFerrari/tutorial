
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

public class Hodiny {

    private BufferedImage background;
    private Point middle;
    private TypHodin typ;
    private boolean time24;

    public Hodiny() {
        try {
            background = ImageIO.read(new File("hodiny.png"));
        } catch (IOException ex) {
        }
        middle = new Point(background.getWidth() / 2, background.getHeight() / 2);
    }

    public Point poziceNaCiFerniku(double cast, int delka) {
        Point point = new Point();
        double angle = (cast - 0.25) * 2 * Math.PI;
        point.x = middle.x + (int) Math.round(Math.cos(angle) * delka);
        point.y = middle.y + (int) Math.round(Math.sin(angle) * delka);
        return point;
    }

    private void vykresliAnalogove(Graphics2D g) {
        LocalDateTime cas = LocalDateTime.now();
        double sec = cas.getSecond() / 60.0;
        double min = cas.getMinute() / 60.0 + sec / 60;
        double hod = cas.getHour() / 12.0 + min / 12;

        Point hodiny = poziceNaCiFerniku(hod, 100);
        Point minuty = poziceNaCiFerniku(min, 120);
        Point sekundy = poziceNaCiFerniku(sec, 120);

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(6));
        g.drawLine(middle.x, middle.y, hodiny.x, hodiny.y);
        g.setStroke(new BasicStroke(3));
        g.drawLine(middle.x, middle.y, minuty.x, minuty.y);
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(1));
        g.drawLine(middle.x, middle.y, sekundy.x, sekundy.y);
    }

    private void vykresliDigitalove(Graphics2D g) {
        DateTimeFormatter format;
        if (time24) {
            format = DateTimeFormatter.ofPattern("H:mm:ss");
        } else {
            format = DateTimeFormatter.ofPattern("K:mm:ss");
        }
        String time = format.format(LocalDateTime.now());
        g.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        FontMetrics velikostTextu = g.getFontMetrics();
        Point poziceTextu = new Point();
        poziceTextu.x = middle.x - velikostTextu.stringWidth(time) / 2;
        poziceTextu.y = middle.y + 50;
        g.setColor(Color.red);
        g.drawString(time, poziceTextu.x, poziceTextu.y);
    }

    public void vykresli(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (typ) {
            case ANALOG:
                g.drawImage(background, 0, 0, null);
                vykresliAnalogove(g2d);
                break;
            case DIGITAL:
                vykresliDigitalove(g2d);
                break;
            case COMBINED:
                g.drawImage(background, 0, 0, null);
                vykresliAnalogove(g2d);
                vykresliDigitalove(g2d);

        }
    }

    public TypHodin getTyp() {
        return typ;
    }

    public void setTyp(TypHodin typ) {
        this.typ = typ;
    }

    public boolean isTime24() {
        return time24;
    }

    public void setTime24(boolean time24) {
        this.time24 = time24;
    }

}
