DROP DATABASE IF EXISTS `table_relations_exercises`;
CREATE DATABASE `table_relations_exercises`;
USE `table_relations_exercises`;

-- 1. One-To-One Relationship
CREATE TABLE `passports`(
	`passport_id` INT PRIMARY KEY NOT NULL,
    `passport_number` VARCHAR(10) UNIQUE NOT NULL
);

INSERT INTO `passports`(`passport_id`, `passport_number`) 
VALUES (101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

CREATE TABLE `persons`(
	`person_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `first_name` VARCHAR(30) NOT NULL,
    `salary` DECIMAL(7, 2) NOT NULL,
    `passport_id` INT UNIQUE NOT NULL,
    CONSTRAINT `fk_persons_passports`
	FOREIGN KEY (`passport_id`)
	REFERENCES `passports`(`passport_id`)
	ON DELETE CASCADE
);

INSERT INTO `persons` (`person_id`, `first_name`, `salary`, `passport_id`)
VALUES (1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103),
(3, 'Yana', 60200.00, 101);

-- 02. One-To-Many Relationship
CREATE TABLE `manufacturers`(
	`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(25) NOT NULL,
	`established_on` DATE NOT NULL
);

INSERT INTO `manufacturers` (`manufacturer_id`, `name`, `established_on`)
VALUES (1, 'BMW', STR_TO_DATE('01/03/1916', '%d/%m/%Y')),
(2, 'Tesla', STR_TO_DATE('01/01/2003', '%d/%m/%Y')),
(3, 'Lada', STR_TO_DATE('01/05/1966', '%d/%m/%Y'));

CREATE TABLE `models`(
	`model_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(25) NOT NULL,
    `manufacturer_id` INT NOT NULL,
    CONSTRAINT `fk_models_manufacturers`
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `manufacturers`(`manufacturer_id`)
    ON DELETE CASCADE
);

INSERT INTO `models` (`model_id`, `name`, `manufacturer_id`)
VALUES (101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

-- 03. Many-To-Many Relationship
CREATE TABLE `exams`(
	`exam_id` INT PRIMARY KEY NOT NULL,
	`name` VARCHAR(30) NOT NULL
);

INSERT INTO `exams` (`exam_id`, `name`)
VALUES (101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

CREATE TABLE `students`(
	`student_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(25)
);

INSERT INTO `students` (`student_id`, `name`)
VALUES(1, 'Mila'),
(2, 'Toni'),
(3, 'Ron');

CREATE TABLE `students_exams`(
	`student_id` INT NOT NULL,
	`exam_id` INT NOT NULL,
    PRIMARY KEY (`student_id`, `exam_id`),
    
    CONSTRAINT `fk_students`
    FOREIGN KEY (`student_id`)
    REFERENCES `students`(`student_id`)
    ON DELETE CASCADE,
    
    CONSTRAINT `fk_exams`
    FOREIGN KEY (`exam_id`)
    REFERENCES `exams`(`exam_id`)
    ON DELETE CASCADE
);

INSERT INTO `students_exams` (`student_id`, `exam_id`)
VALUES (1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

-- Usecase for this task (`select data for all students and their exams`)
SELECT `s`.`name` AS `student_name`,
`e`.`name` AS `exam_name`
FROM `students_exams` AS `s_e`
INNER JOIN `exams` AS `e`
ON `s_e`.`exam_id` = `e`.`exam_id`
INNER JOIN `students` AS `s`
ON `s_e`.`student_id` = `s`.`student_id`;

-- 04. Self-Referencing

CREATE TABLE `teachers`(
	`teacher_id` INT PRIMARY KEY NOT NULL,
	`name`VARCHAR(25) NOT NULL,
	`manager_id` INT,
    CONSTRAINT `fk_teachers_teachers`
    FOREIGN KEY (`manager_id`)
    REFERENCES `teachers`(`teacher_id`)
    ON DELETE CASCADE
); 

SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO `teachers` (`teacher_id`, `name`, `manager_id`)
VALUES (101, 'John', NULL),
(102, 'Maya', 106),
(103, 'Silvia', 106),
(104, 'Ted', 105),
(105, 'Mark', 101),
(106, 'Greta', 101);

SET FOREIGN_KEY_CHECKS = 1;

-- 05. Online Store Database
DROP DATABASE IF EXISTS `online_store`;
CREATE DATABASE `online_store`;
USE `online_store`;

CREATE TABLE `cities`(
	`city_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50)
);

CREATE TABLE `customers`(
	`customer_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `birthday` DATE,
    `city_id` INT(11),
    CONSTRAINT `fk_cities_customers`
    FOREIGN KEY (`city_id`)
    REFERENCES `cities`(`city_id`)
    ON DELETE CASCADE
);

CREATE TABLE `orders`(
	`order_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `customer_id` INT(11) NOT NULL,
    CONSTRAINT `fk_orders_customers`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers`(`customer_id`)
    ON DELETE CASCADE 
);

CREATE TABLE `item_types`(
	`item_type_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `items`(
	`item_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `item_type_id` INT(11) NOT NULL,
    CONSTRAINT `items_item_types`
    FOREIGN KEY (`item_type_id`)
    REFERENCES `item_types`(`item_type_id`)
    ON DELETE CASCADE
);

CREATE TABLE `order_items`(
	`order_id` INT(11) NOT NULL,
    `item_id` INT(11) NOT NULL,
    PRIMARY KEY (`order_id`, `item_id`),
    
    CONSTRAINT `fk_orders`
    FOREIGN KEY (`order_id`)
    REFERENCES `orders`(`order_id`)
    ON DELETE CASCADE,
    
    CONSTRAINT `fk_items`
    FOREIGN KEY (`item_id`)
    REFERENCES `items`(`item_id`)
    ON DELETE CASCADE
);

-- 06. University Database
DROP DATABASE IF EXISTS `university`;
CREATE DATABASE `university`;
USE `university`;

CREATE TABLE `majors`(
	`major_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50)
);

CREATE TABLE `students`(
	`student_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `student_number` VARCHAR(12) NOT NULL,
    `student_name` VARCHAR(50) NOT NULL,
    `major_id` INT(11) NOT NULL,
    CONSTRAINT `fk_students_majors`
    FOREIGN KEY (`major_id`)
    REFERENCES `majors`(`major_id`)
    ON DELETE CASCADE
);

CREATE TABLE `payments`(
	`payment_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `payment_date` DATE,
    `payment_amount` DECIMAL(8, 2),
    `student_id` INT(11) NOT NULL,
    CONSTRAINT `fk_payments_students`
    FOREIGN KEY(`student_id`)
    REFERENCES `students`(`student_id`)
    ON DELETE CASCADE
);

CREATE TABLE `subjects`(
	`subject_id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `subject_name` VARCHAR(50) NOT NULL
);

CREATE TABLE `agenda`(
    `student_id` INT(11) NOT NULL,
	`subject_id` INT(11) NOT NULL,
    PRIMARY KEY(`student_id`, `subject_id`),
    
    CONSTRAINT `fk_students`
    FOREIGN KEY(`student_id`)
    REFERENCES `students`(`student_id`)
    ON DELETE CASCADE,
    
    CONSTRAINT `fk_subjects`
    FOREIGN KEY(`subject_id`)
    REFERENCES `subjects`(`subject_id`)
    ON DELETE CASCADE
);

-- 09. Peaks in Rila
USE `geography`;
SELECT `m`.`mountain_range`,
`p`.`peak_name`,
`p`.`elevation` AS `peak_elevation`
FROM `mountains` AS `m`
INNER JOIN `peaks` AS `p`
ON `m`.`id` = `p`.`mountain_id`
WHERE LOWER(`mountain_range`) = 'rila'
ORDER BY `peak_elevation` DESC;
