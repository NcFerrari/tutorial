create database if not exists demo;

use demo;

drop table if exists employees;

CREATE TABLE `employees`
(
    `id`         int(11) NOT null auto_increment,
    `last_name`  varchar(64)    DEFAULT NULL,
    `first_name` varchar(64)    DEFAULT NULL,
    `email`      varchar(64)    DEFAULT NULL,
    `department` varchar(64)    DEFAULT NULL,
    `salary`     decimal(10, 2) DEFAULT NULL,
    `resume`     blob,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (1, 'Doe', 'John', 'john.doe@foo.com', 'HR', 55000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (2, 'Public', 'Mary', 'mary.public@foo.com', 'Engineering', 75000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (3, 'Queue', 'Susan', 'susan.queue@foo.com', 'Legal', 130000.00);

INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (4, 'Williams', 'David', 'david.williams@foo.com', 'HR', 120000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (5, 'Johnson', 'Lisa', 'lisa.johnson@foo.com', 'Engineering', 50000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (6, 'Smith', 'Paul', 'paul.smith@foo.com', 'Legal', 100000.00);

INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (7, 'Adams', 'Carl', 'carl.adams@foo.com', 'HR', 50000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (8, 'Brown', 'Bill', 'bill.brown@foo.com', 'Engineering', 50000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (9, 'Thomas', 'Susan', 'susan.thomas@foo.com', 'Legal', 80000.00);

INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (10, 'Davis', 'John', 'john.davis@foo.com', 'HR', 45000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (11, 'Fowler', 'Mary', 'mary.fowler@foo.com', 'Engineering', 65000.00);
INSERT INTO `employees` (`id`, `last_name`, `first_name`, `email`, `department`, `salary`)
VALUES (12, 'Waters', 'David', 'david.waters@foo.com', 'Legal', 90000.00);

--
-- DEFINE STORED PROCEDURES
--

DELIMITER $$
drop procedure if exists `get_count_for_department`$$

create
    definer = `student`@`localhost` procedure `get_count_for_department`(in the_department varchar(64), out the_count int)
begin
    select COUNT(*) into the_count from employees where department = the_department;
end$$
DELIMITER :

DELIMITER $$
drop procedure if exists `get_employees_for_department`$$

create
    definer = `student`@`localhost` procedure `get_employees_for_department`(in the_department varchar(64))
begin
    select * from employees where department = the_department;
end$$
DELIMITER :

DELIMITER $$
drop procedure if exists `greet_the_department`$$

create
    definer = `student`@`localhost` procedure `greet_the_department`(inout department varchar(64))
begin
    set department = concat('Hello to the awasome ', department, ' team!');
end$$
DELIMITER :

DELIMITER $$
drop procedure if exists `increase_salaries_for_department`$$

create
    definer = `student`@`localhost` procedure `increase_salaries_for_department`(in the_department varchar(64), in increase_amount decimal(10, 2))
begin
    update employees
    set salary= salary + increase_amount
    where department = the_department;
end$$
DELIMITER :
