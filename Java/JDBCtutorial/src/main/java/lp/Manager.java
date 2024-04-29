package lp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Manager {

    public Manager() {
        Logger log = LogManager.getLogger(this);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        DataSource dataSource;
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("conf.yaml");
            if (inputStream == null) {
                return;
            }
            dataSource = mapper.readValue(inputStream, DataSource.class).loadSystemEnvironments();
        } catch (IOException e) {
            log.error(e.getMessage());
            return;
        }

        try (Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUser(),
                dataSource.getPassword()); Statement myStmt = connection.createStatement()) {
            ResultSet myRs = myStmt.executeQuery("select * from employees");
            while (myRs.next()) {
                String stringBuilder = myRs.getString("last_name") + "," + myRs.getString("first_name");
                log.info(stringBuilder);
            }
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
    }

    public static void main(String[] args) {
        new Manager();
    }
}
