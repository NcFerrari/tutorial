package lp.be.jpa.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mysql.cj.util.StringUtils;
import generator.Human;
import generator.utils.HumanAtr;
import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DBConnection {

    private final LoggerService loggerService = LoggerServiceImpl.getInstance(DBConnection.class);
    private final Logger log = loggerService.getLog();
    private DataSource dataSource;
    private Statement statement;
    private Connection connection;
    private int newPeopleCount;

    public void runDB() {
        loadDataSource();
        executeStatement();
    }

    private void runMethods() throws SQLException {
        newPeopleCount = 10;
        create();
        read();
        update();
        delete();
        preparedStatementExample();
        callableStatementExample();
        greet();
    }

    private void executeStatement() {
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

    private void create() throws SQLException {
        log.info("CREATE INTO DATABASE");
        String[] departments = {"HR", "Engineering", "Legal"};
        Random rnd = new Random();
        for (int i = 0; i < newPeopleCount; i++) {
            Object[] human = Human.generate(HumanAtr.SURNAME, HumanAtr.NAME, HumanAtr.EMAIL);
            String sql = "INSERT INTO employees (last_name, first_name, email, department, salary) VALUES " +
                    "(" + String.format("'%s', '%s', '%s', '%s', '%d')", human[1], human[0], human[2],
                    departments[rnd.nextInt(departments.length)], 20_000 + rnd.nextInt(100_000));
            log.info(sql);
            statement.execute(sql);
        }
        log.info("Insert complete.");
    }

    private void read() throws SQLException {
        log.info("READ FROM DATABASE");
        ResultSet rs = statement.executeQuery("SELECT * FROM employees");
        while (rs.next()) {
            String result = getBasicData(rs);
            log.info(result);
        }
    }

    private void update() throws SQLException {
        log.info("UPDATE DATA");
        int updateCount = statement.executeUpdate("UPDATE employees SET email='demo@luv2code.com' WHERE id=9");
        log.info("Update complete. Updated {} records.", updateCount);
    }

    private void delete() throws SQLException {
        log.info("DELETE DATA");
        int deletedCount = statement.executeUpdate("DELETE FROM employees WHERE last_name LIKE '%l%'");
        log.info("Delete complete. Removed {} records.", deletedCount);
    }

    private void preparedStatementExample() {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM employees WHERE first_name LIKE ?")) {
            preparedStatement.setString(1, "%a%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String result = getBasicData(rs);
                log.info(result);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    private void callableStatementExample() throws SQLException {
        String theDepartment = "Engineering";
        int theIncreaseAmount = 10_000;
        log.info("Salaries BEFORE");
        log.info("");
        testingOutput(theDepartment);
        try (CallableStatement cs = connection.prepareCall("{call increase_salaries_for_department(?, ?)}")) {
            cs.setString(1, theDepartment);
            cs.setDouble(2, theIncreaseAmount);

            log.info("");
            log.info("");
            log.info("Calling stored procedure. increase_salaries_for_department('{}', {})",
                    theDepartment, theIncreaseAmount);
            cs.execute();
            log.info("Finished calling stored procedure");
            log.info("");
            log.info("");
            log.info("Salaries AFTER");
            log.info("");
        }
        testingOutput(theDepartment);
    }

    private void greet() throws SQLException {
        String theDepartment = "Engineering";
        testingOutput(theDepartment);
        try (CallableStatement callableStatement = connection.prepareCall("{call greet_the_department(?)}")) {
            callableStatement.setString(1, theDepartment);
            callableStatement.execute();
        }
        testingOutput(theDepartment);
    }

    private void testingOutput(String theDepartment) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE department='" + theDepartment + "'");
        while (rs.next()) {
            String stringBuilder = getBasicData(rs) + ", " + rs.getString("department") + ", " + rs.getString("salary");
            log.info(stringBuilder);
        }
    }

    private String getBasicData(ResultSet rs) throws SQLException {
        String result = rs.getString("last_name") + "," + rs.getString("first_name");
        return StringUtils.isNullOrEmpty(result) ? "Nothing to display" : result;
    }
}
