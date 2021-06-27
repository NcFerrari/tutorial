package stredniPriklad;

import java.awt.Color;

public class FrameModel {

    private int frameWidth = 500;
    private int frameHeight = 500;
    private int width = 10;
    private int height = 10;
    private boolean changes;
    private Color currentColor = Color.BLUE;
    private Color[][] colors = new Color[100][100];

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Color[][] getColors() {
        return colors;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isChanges() {
        return changes;
    }

    public void setChanges(boolean changes) {
        this.changes = changes;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public int getFieldWidth() {
        return frameWidth / width;
    }

    public int getFieldHeight() {
        return frameHeight / height;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void paintPixel(int x, int y) {
        if (x > -1 && x < getFieldWidth() * getWidth() && y > -1 && y < getFieldHeight() * getHeight()) {
            colors[y][x] = currentColor;
        }
        setChanges(true);
    }

    public String getData() {
        String result = "";
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (colors[i][j] != null) {
                    result += String.format("%s#%s#%s;", colors[i][j].getRed(), colors[i][j].getGreen(), colors[i][j].getBlue());
                } else {
                    result += "-;";
                }
            }
            result += "\n";
        }
        return result;
    }

    public void removeAll() {
        colors = new Color[100][100];
    }

}
