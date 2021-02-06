DROP DATABASE IF EXISTS `soft_uni`;
CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(45) NOT NULL
);

INSERT INTO `towns`(`name`)
VALUES ('Sofia'), 
('Plovdiv'), 
('Varna'), 
('Burgas');

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`address_text` VARCHAR(100) NOT NULL,
`town_id` INT NOT NULL
);

ALTER TABLE `addresses`
ADD CONSTRAINT `fk_addresses_towns`
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);

INSERT INTO `addresses` (`address_text`, `town_id`)
VALUES('Sofia first street', 1),
('Plovdiv first street', 2),
('Varna first street', 3),
('Varna second street', 3);


CREATE TABLE `departments`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(45) NOT NULL
);

INSERT INTO `departments` (`name`)
VALUES ('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');


CREATE TABLE `employees`(
`id`INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
`first_name` VARCHAR(45) NOT NULL, 
`middle_name` VARCHAR(45), 
`last_name` VARCHAR(45) NOT NULL,
`job_title` VARCHAR(45) NOT NULL,
`department_id` INT,
`hire_date` DATE,
`salary` DECIMAL(6, 2) NOT NULL,
`address_id` INT
);

ALTER TABLE `employees`
ADD CONSTRAINT `fk_employees_departments`
FOREIGN KEY (`department_id`)
REFERENCES `departments`(`id`);

ALTER TABLE `employees`
ADD CONSTRAINT `fk_employees_addresses`
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`);

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`, `address_id`)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer',4 , '2013-02-01', 3500.00, 1),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00, 2),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, 1),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00, 3),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, 4);


SELECT * FROM `towns`
ORDER BY `name` ASC;

SELECT * FROM `departments`
ORDER BY `name` ASC;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

SELECT `name` FROM `towns`
ORDER BY `name` ASC;

SELECT `name` FROM `departments`
ORDER BY `name` ASC;

SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;

UPDATE `employees`
SET `salary` = `salary` * 1.10
WHERE `id` > 0;

SELECT `salary` FROM `employees`;

