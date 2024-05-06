package lp.be.jpa.db;

import java.nio.charset.StandardCharsets;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MigrationExamples extends DBConnection {

    private DatabaseMetaData databaseMetaData;

    @Override
    protected void runMethods() throws SQLException {
        databaseMetaData = connection.getMetaData();
        transactionExample();
        metaData();
        schemaScan();
    }

    private void schemaScan() throws SQLException {
        log.info("SCHEMA SCAN");
        log.info("");
        log.info("List of Tables");
        log.info("--------------");
        ResultSet rs = databaseMetaData.getTables(null, null, "employees", null);
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            log.info(tableName);
        }
        log.info("");
        log.info("List of Columns");
        log.info("---------------");
        rs = databaseMetaData.getColumns(null, null, "employees", null);
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            log.info(columnName);
        }

        log.info("SCHEMA SCAN finished.\n");
    }

    private void metaData() throws SQLException {
        log.info("META DATA");
        databaseMetaData = connection.getMetaData();
        log.info("Product name: {}", databaseMetaData.getDatabaseProductName());
        log.info("Product version: {}", databaseMetaData.getDatabaseProductVersion());
        log.info("");
        log.info("JDBC Driver name: {}", databaseMetaData.getDriverName());
        log.info("JDBC Driver version: {}", databaseMetaData.getDriverVersion());
        log.info("META DATA finished.\n");
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
