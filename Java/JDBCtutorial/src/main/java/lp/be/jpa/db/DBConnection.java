package lp.be.jpa.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    private final LoggerService loggerService = LoggerServiceImpl.getInstance(DBConnection.class);
    private final Logger log = loggerService.getLog();

    public void execute() {
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
}
