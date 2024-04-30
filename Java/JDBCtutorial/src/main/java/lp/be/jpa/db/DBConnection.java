package lp.be.jpa.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import generator.Human;
import generator.utils.HumanAtr;
import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private final LoggerService loggerService = LoggerServiceImpl.getInstance(DBConnection.class);
    private final Logger log = loggerService.getLog();
    private DataSource dataSource;
    private Statement statement;

    public void runDB() {
        loadDataSource();
        executeStatement();
    }

    private void runMethods() throws SQLException {
        read();
        create();
    }

    private void executeStatement() {
        try (Connection connection = DriverManager.getConnection(
                dataSource.getUrl(),
                dataSource.getUser(),
                dataSource.getPassword())) {
            statement = connection.createStatement();
            runMethods();
        } catch (Exception exp) {
            log.error(exp.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }

    private void loadDataSource() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("conf.yaml");
            if (inputStream == null) {
                return;
            }
            dataSource = mapper.readValue(inputStream, DataSource.class).loadSystemEnvironments();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void read() throws SQLException {
        log.info("READ FROM DATABASE");
        ResultSet myRs = statement.executeQuery("select * from employees");
        while (myRs.next()) {
            String stringBuilder = myRs.getString("last_name") + "," + myRs.getString("first_name");
            log.info(stringBuilder);
        }
    }

    private void create() throws SQLException {
        log.info("CREATE INTO DATABASE");
        for (int i = 0; i < 10; i++) {
            Object[] human = Human.generate(HumanAtr.SURNAME, HumanAtr.NAME, HumanAtr.EMAIL);
            StringBuilder sql = new StringBuilder("INSERT INTO employees (last_name, first_name, email) values (");
            sql.append(String.format("'%s', '%s', '%s')", human[0], human[1], human[2]));
            statement.execute(sql.toString());
        }
        log.info("Insert complete.");
    }
}
