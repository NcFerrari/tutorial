package lp.be.jpa.db.tutorial;

import lp.be.jpa.db.DBConnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilesInDB extends DBConnection {

    @Override
    protected void runMethods() throws SQLException {
        saveBLOBIntoDB();
        loadBLOBFromDB();
        saveCLOBIntoDB();
        loadCLOBFromDB();
    }

    private void loadCLOBFromDB() throws SQLException {
        log.info("LOAD CLOB FROM DB");
        String sql = "SELECT big_text FROM employees WHERE email='john.doe@foo.com'";
        ResultSet rs = statement.executeQuery(sql);
        File file = new File("xml_from_db.xml");
        try (FileWriter output = new FileWriter(file)) {
            while (rs.next()) {
                Reader input = rs.getCharacterStream("big_text");
                int character;
                while ((character = input.read()) > 0) {
                    output.write(character);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("LOADED CLOB FROM DB");
    }

    private void saveCLOBIntoDB() {
        log.info("SAVE CLOB INTO DB");
        String sql = "UPDATE employees SET big_text=? WHERE email='john.doe@foo.com'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            URL url = getClass().getClassLoader().getResource("sample.xml");
            if (url != null) {
                File file = new File(url.toURI());
                FileReader reader = new FileReader(file);
                preparedStatement.setCharacterStream(1, reader);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException | FileNotFoundException | URISyntaxException exp) {
            log.error(exp.getMessage());
        }
        log.info("CLOB SAVED");
    }

    private void loadBLOBFromDB() throws SQLException {
        log.info("LOAD BLOB FROM DB");
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
        log.info("LOADED BLOB FROM DB");
    }

    private void saveBLOBIntoDB() {
        log.info("SAVE BLOB INTO DB");
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