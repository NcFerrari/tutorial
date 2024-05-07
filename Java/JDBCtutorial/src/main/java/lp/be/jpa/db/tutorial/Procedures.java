package lp.be.jpa.db.tutorial;

import lp.be.jpa.db.DBConnection;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Procedures extends DBConnection {

    @Override
    protected void runMethods() throws SQLException {
        preparedStatementExample();
        callableStatementExample();
        greet();
    }

    private void preparedStatementExample() {
        log.info("PREPARED STATEMENT EXAMPLE");
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
        log.info("SELECT completed.\n");
    }

    private void callableStatementExample() throws SQLException {
        log.info("CALLABLE STATEMENT EXAMPLE");
        int theIncreaseAmount = 10_000;
        log.info("Salaries BEFORE");
        testingOutput();
        try (CallableStatement cs = connection.prepareCall("{call increase_salaries_for_department(?, ?)}")) {
            cs.setString(1, ENGINEERING);
            cs.setDouble(2, theIncreaseAmount);

            log.info("");
            log.info("Calling stored procedure. increase_salaries_for_department('{}', {})",
                    ENGINEERING, theIncreaseAmount);
            cs.execute();
            log.info("Finished calling stored procedure");
            log.info("");
            log.info("Salaries AFTER");
        }
        testingOutput();
        log.info("CALLABLE STATEMENT EXAMPLE finished.\n");
    }

    private void greet() throws SQLException {
        log.info("GREETINGS");
        try (CallableStatement callableStatement = connection.prepareCall("{call greet_the_department(?)}")) {
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(1, HR);
            callableStatement.execute();
            String theResult = callableStatement.getString(1);
            log.info("The result = {}", theResult);
        }
        log.info("GREETINGS ended.\n");
    }

    private void testingOutput() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE department='" + ENGINEERING + "'");
        while (rs.next()) {
            String stringBuilder = getBasicData(rs) + ", " + rs.getString("department") + ", " + rs.getString("salary");
            log.info(stringBuilder);
        }
    }
}
