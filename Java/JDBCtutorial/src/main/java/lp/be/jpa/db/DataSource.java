package lp.be.jpa.db;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Getter
@Setter
public class DataSource {

    private String driver;
    private String host;
    private int port;
    private String db;
    private String encoding;
    private String user;
    private String password;

    public String getUrl() {
        return String.format("%s%s:%d/%s%s", getDriver(), getHost(), getPort(), getDb(), getEncoding());
    }

    public DataSource loadSystemEnvironments() {
        for (Field field : getClass().getDeclaredFields()) {
            try {
                String fieldMethodName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                String text = "" + getClass().getMethod("get" + fieldMethodName).invoke(this);
                if (text.startsWith("${") && text.endsWith("}")) {
                    text = text.substring(2, text.length() - 1);
                    String systemEnvironment = System.getenv(text.split(":")[0]);
                    String newValue = systemEnvironment != null ? systemEnvironment : text.split(":")[1];
                    getClass().getMethod("set" + fieldMethodName, String.class).invoke(this, newValue);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                return null;
            }
        }
        return this;
    }
}
