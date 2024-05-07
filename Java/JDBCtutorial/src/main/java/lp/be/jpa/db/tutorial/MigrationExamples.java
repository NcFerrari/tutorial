package lp.be.jpa.db.tutorial;

import lp.be.jpa.db.DBConnection;

import java.nio.charset.StandardCharsets;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        metaData2();
    }

    private void metaData2() throws SQLException {
        log.info("META DATA2");
        String sql = "SELECT id, last_name, first_name, salary FROM employees";
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        log.info("Column count: {}", columnCount);
        log.info("");
        for (int column = 1; column <= columnCount; column++) {
            String name = resultSetMetaData.getColumnName(column);
            String type = resultSetMetaData.getColumnTypeName(column);
            int nullable = resultSetMetaData.isNullable(column);
            boolean ai = resultSetMetaData.isAutoIncrement(column);
            log.info("ColumnName: {}", name);
            log.info("Column type name: {}", type);
            log.info("Is Nullable: {}", nullable);
            log.info("Is Auto Increment: {}", ai);
            log.info("");
        }
        log.info("META DATA2 finished");
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
