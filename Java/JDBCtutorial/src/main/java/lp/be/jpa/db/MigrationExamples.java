package lp.be.jpa.db;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MigrationExamples extends DBConnection {

    @Override
    protected void runMethods() throws SQLException {
        transactionExample();
    }

    private void transactionExample() throws SQLException {
        log.info("TRANSACTION EXAMPLE");
        log.info("Salaries BEFORE");
        showSalariesByDepartment(HR);
        showSalariesByDepartment(ENGINEERING);
        processTransaction();
        showSalariesByDepartment(HR);
        showSalariesByDepartment(ENGINEERING);
        log.info("TRANSACTION EXAMPLE finished\n");
    }

    private void processTransaction() throws SQLException {
        statement.executeUpdate("DELETE FROM employees WHERE department='" + HR + "'");
        statement.executeUpdate("UPDATE employees SET salary=30000 WHERE department='" + ENGINEERING + "'");
        log.info("");
        log.info("");
        log.info(">> Transaction steps are ready.");
        log.info("");
        log.info("Is it okay to save? yes/no:");
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String answer = scanner.nextLine();

        if ("yes".equalsIgnoreCase(answer.trim())) {
            connection.commit();
            log.info(">> Transaction COMMITED.\n");
        } else {
            connection.rollback();
            log.info(">> Transaction ROLLED BACK.\n");
        }
    }

    private void showSalariesByDepartment(String department) throws SQLException {
        log.info("");
        log.info("Show Salaries for Department: {}", department);
        connection.setAutoCommit(false);
        ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE department = '" + department + "'");
        while (rs.next()) {
            String surNameAndName = getBasicData(rs);
            String departmentFromDB = rs.getString("department");
            Double salary = rs.getDouble("salary");
            log.info("{}, {}, {}", surNameAndName, departmentFromDB, salary);
        }
    }

}
