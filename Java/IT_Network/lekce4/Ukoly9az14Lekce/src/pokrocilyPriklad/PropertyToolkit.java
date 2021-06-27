package pokrocilyPriklad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyToolkit {

    private static PropertyToolkit instance;
    private final File file = new File("config.properties");
    private final Properties props = new Properties();

    public static PropertyToolkit getInstance() {
        if (instance == null) {
            instance = new PropertyToolkit();
        }
        return instance;
    }

    private PropertyToolkit() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            props.load(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    public void put(Object key, Object value) {
        props.put(key.toString(), value.toString());
        try {
            props.store(new FileOutputStream(file), null);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
