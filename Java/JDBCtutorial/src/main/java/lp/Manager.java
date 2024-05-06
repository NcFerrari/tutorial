package lp;

import lp.be.jpa.db.tutorial.CRUD;
import lp.be.jpa.db.tutorial.Procedures;
import lp.be.jpa.db.tutorial.MigrationExamples;
import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;
import org.apache.logging.log4j.Logger;

public class Manager {

    private final LoggerService loggerService = LoggerServiceImpl.getInstance(Manager.class);
    private final Logger log = loggerService.getLog();

    public Manager() {
        log.info("project started");
        switch (3) {
            case 2:
                new Procedures();
                break;
            case 3:
                new MigrationExamples();
                break;
            default:
                new CRUD();
        }
    }

    public static void main(String[] args) {
        new Manager();
    }
}
