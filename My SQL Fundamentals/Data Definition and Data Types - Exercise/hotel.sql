DROP DATABASE IF EXISTS `hotel`;
CREATE DATABASE `hotel`;
USE `hotel`;
CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
    `first_name` VARCHAR(45) NOT NULL, 
    `last_name` VARCHAR(45) NOT NULL, 
    `title` VARCHAR(45) NOT NULL, 
    `notes` TEXT
); 

INSERT INTO `employees` (`first_name`, `last_name`, `title`)
VALUES ('Pesho', 'Peshov', 'Boss'),
('Gosho', 'Goshov', 'Director'),
('name', 'name', 'title');

CREATE TABLE `customers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`account_number` INT NOT NULL, 
    `first_name` VARCHAR(45) NOT NULL, 
    `last_name` VARCHAR(45) NOT NULL, 
    `phone_number` VARCHAR(45) NOT NULL, 
    `emergency_name` VARCHAR(45), 
    `emergency_number` VARCHAR(45), 
    `notes` TEXT
); 

INSERT INTO `customers` (`account_number`, `first_name`, `last_name`, `phone_number`)
VALUES (1, 'Pesho', 'Petrov', '112-2231-32'),
(2, 'Gosho', 'Petrov', '112-229-12'),
(3, 'Atanas', 'Petrov', '112-11-32');

CREATE TABLE `room_status` (
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`room_status` VARCHAR(45)  NOT NULL, 
    `notes` TEXT
); 

INSERT INTO `room_status` (`room_status`)
VALUES ('free'),
('occupied'), 
('cleaning');

CREATE TABLE `room_types` (
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`room_type` VARCHAR(45) NOT NULL, 
    `notes` TEXT
); 

INSERT INTO `room_types` (`room_type`)
VALUES('small'),
('normal'), 
('apartment');

CREATE TABLE `bed_types` (
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`bed_type` VARCHAR(45) NOT NULL, 
    `notes` TEXT
); 

INSERT INTO `bed_types` (`bed_type`)
VALUES('single'), 
('twin'), 
('king-size');

CREATE TABLE `rooms` (
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`room_number` INT NOT NULL, 
    `room_type` VARCHAR(45) NOT NULL, 
    `bed_type` VARCHAR(45) NOT NULL, 
    `rate` DOUBLE NOT NULL, 
    `room_status` VARCHAR(45) NOT NULL, 
    `notes` TEXT
); 

INSERT INTO `rooms` (`room_number`, `room_type`, `bed_type`, `rate`, `room_status`)
VALUES(1, 'small', 'single', 50, 'free'),
(2, 'apartment', 'king-size', 100, 'cleaning'),
(3, 'normal', 'twin', 70, 'occupied');

CREATE TABLE `payments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
    `employee_id` INT NOT NULL, 
    `payment_date` DATE NOT NULL, 
    `account_number` BIGINT NOT NULL, 
    `first_date_occupied` DATE NOT NULL, 
    `last_date_occupied` DATE NOT NULL, 
    `total_days` INT, 
    `amount_charged` DOUBLE NOT NULL, 
    `tax_rate` DOUBLE NOT NULL, 
    `tax_amount` DOUBLE, 
    `payment_total` DOUBLE, 
    `notes` TEXT
);

INSERT INTO `payments` (`employee_id`, `payment_date`, `account_number`,`first_date_occupied`, `last_date_occupied`, `total_days`, `amount_charged`,`tax_rate`)
VALUES (1, '2018-01-10', 2, '2018-01-02', '2018-01-10', 8, 300, 0.2),
(1, '2018-01-09', 2, '2018-01-02', '2018-01-09', 7, 270, 0.2),
(1, '2018-01-08', 2, '2018-01-02', '2018-01-08', 6, 240, 0.2);

CREATE TABLE `occupancies`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
    `employee_id` INT NOT NULL,  
    `date_occupied` DATE NOT NULL, 
    `account_number` BIGINT NOT NULL, 
    `room_number` INT NOT NULL, 
    `rate_applied` DOUBLE NOT NULL, 
    `phone_charge` DOUBLE, 
    `notes` TEXT
);

INSERT INTO `occupancies` (`employee_id`, `date_occupied`, `account_number`, `room_number`, `rate_applied`)
VALUES(2, '2018-01-02', 2, 3, 20),
(2, '2018-01-03', 2, 3, 30),
(2, '2018-01-05', 2, 1, 20);