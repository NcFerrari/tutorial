package pokrocilyPriklad;

import javax.swing.ImageIcon;

public enum ImagesEnum {
    DOG("pet.png"),
    ICON("icon.png"),
    FEED("pet-food.png"),
    SLEEP("sleeping-pet.png"),
    WASH("dog.png"),
    WALK("walking-pet.png");

    private String path;

    private ImagesEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/pokrocilyPriklad/source/" + getPath()));
    }
}
