package lp.be.jpa.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mysql.cj.util.StringUtils;
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

public abstract class DBConnection {

    protected static final String HR = "HR";
    protected static final String ENGINEERING = "Engineering";
    protected final LoggerService loggerService;
    protected final Logger log;
    protected DataSource dataSource;
    protected Statement statement;
    protected Connection connection;

    protected DBConnection() {
        loggerService = LoggerServiceImpl.getInstance(getClass());
        log = loggerService.getLog();
        loadDataSource();
        executeStatement();
    }

    protected abstract void runMethods() throws SQLException;

    protected void executeStatement() {
        try {
            connection = DriverManager.getConnection(
                    dataSource.getUrl(),
                    dataSource.getUser(),
                    dataSource.getPassword());
            statement = connection.createStatement();
            runMethods();
        } catch (Exception exp) {
            log.error(exp.getMessage());
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }

    protected void loadDataSource() {
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

    protected String getBasicData(ResultSet rs) throws SQLException {
        String result = rs.getString("last_name") + "," + rs.getString("first_name");
        return StringUtils.isNullOrEmpty(result) ? "Nothing to display" : result;
    }
}
