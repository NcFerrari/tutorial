package lp.be.jpa.db;

import generator.Human;
import generator.utils.HumanAtr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class CRUD extends DBConnection {

    private static final String HR = "HR";
    private static final String ENGINEERING = "Engineering";
    private final Random rnd = new Random();
    private int newPeopleCount;

    @Override
    protected void runMethods() throws SQLException {
        newPeopleCount = 0;
        create();
        read();
        update();
        delete();
    }

    private void create() throws SQLException {
        log.info("CREATE INTO DATABASE");
        String[] departments = {HR, ENGINEERING, "Legal"};
        for (int i = 0; i < newPeopleCount; i++) {
            Object[] human = Human.generate(HumanAtr.SURNAME, HumanAtr.NAME, HumanAtr.EMAIL);
            String sql = "INSERT INTO employees (last_name, first_name, email, department, salary) VALUES " +
                    "(" + String.format("'%s', '%s', '%s', '%s', '%d')", human[1], human[0], human[2],
                    departments[rnd.nextInt(departments.length)], 20_000 + rnd.nextInt(100_000));
            statement.execute(sql);
        }
        log.info("Insert complete.\n");
    }

    private void read() throws SQLException {
        log.info("READ FROM DATABASE");
        ResultSet rs = statement.executeQuery("SELECT * FROM employees");
        while (rs.next()) {
            String result = getBasicData(rs);
            log.info(result);
        }
        log.info("SELECT completed.\n");
    }

    private void update() throws SQLException {
        log.info("UPDATE DATA");
        int updateCount = statement.executeUpdate("UPDATE employees SET email='demo@luv2code.com' WHERE id=9");
        log.info("Update complete. Updated {} records.\n", updateCount);
    }

    private void delete() throws SQLException {
        log.info("DELETE DATA");
        int deletedCount = statement.executeUpdate("DELETE FROM employees WHERE last_name LIKE '%l%'");
        log.info("Delete complete. Removed {} records.\n", deletedCount);
    }
}
