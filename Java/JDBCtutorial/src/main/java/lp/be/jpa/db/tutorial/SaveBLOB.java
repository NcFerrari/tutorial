package lp.be.jpa.db.tutorial;

import lp.be.jpa.db.DBConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveBLOB extends DBConnection {

    @Override
    protected void runMethods() throws SQLException {
        saveIntoDB();
        loadFromDB();
    }

    private void loadFromDB() throws SQLException {
        log.info("LOAD FROM DB");
        String sql = "SELECT resume FROM employees WHERE email = 'john.doe@foo.com'";
        ResultSet rs = statement.executeQuery(sql);
        File file = new File("resume_from_db.pdf");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("resume");
                byte[] buffer = new byte[4096];
                while (input.read(buffer) > 0) {
                    outputStream.write(buffer);
                }
            }
        } catch (IOException e) {
            log.error("File not found");
        }
        log.info("LOADED FROM DB");
    }

    private void saveIntoDB() {
        log.info("SAVE INTO DB");
        String sql = "UPDATE employees SET resume=? WHERE email='john.doe@foo.com'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.pdf");
            preparedStatement.setBinaryStream(1, inputStream);

            preparedStatement.executeUpdate();
        } catch (Exception exp) {
            log.error(exp.getMessage());
        }
        log.info("SAVED INTO DB");
    }
}