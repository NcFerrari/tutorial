package jednoduchyPriklad;

import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;

public class Model {

    private DefaultListModel<String> model = new DefaultListModel<>();

    public DefaultListModel<String> getModel() {
        return model;
    }

    public List<String> getItems() {
        return Collections.list(model.elements());
    }

    public void addItem(String item) {
        model.addElement(item);
    }

    public void removeItem(String item) {
        if (model.contains(item)) {
            model.removeElement(item);
        }
    }
}
