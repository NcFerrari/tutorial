package lp;

import lp.be.jpa.db.DBConnection;
import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;
import org.apache.logging.log4j.Logger;

public class Manager {

    private final LoggerService loggerService = LoggerServiceImpl.getInstance(Manager.class);
    private final Logger log = loggerService.getLog();

    public Manager() {
        log.info("project started");
        new DBConnection().runDB();
    }

    public static void main(String[] args) {
        new Manager();
    }
}
