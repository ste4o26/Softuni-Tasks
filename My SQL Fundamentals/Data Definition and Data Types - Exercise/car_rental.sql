DROP DATABASE IF EXISTS `car_rental`;
CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    `daily_rate` DOUBLE(7,2) NOT NULL,
    `weekly_rate` DOUBLE(7,2) NOT NULL,
    `monthly_rate` DOUBLE(7,2) NOT NULL,
    `weekend_rate` DOUBLE(7,2) NOT NULL
);

CREATE TABLE `cars`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
    `plate_number` VARCHAR(45) NOT NULL, 
    `make` VARCHAR(50) NOT NULL, 
    `model` VARCHAR(50) NOT NULL, 
    `car_year` YEAR, 
    `category_id` INT NOT NULL, 
    `doors` TINYINT, 
    `picture` BLOB, 
    `car_condition` VARCHAR(255), 
    `available` BOOLEAN NOT NULL
);

CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`first_name` VARCHAR(45) NOT NULL, 
	`last_name` VARCHAR(45) NOT NULL,
	`title` VARCHAR(45) NOT NULL, 
	`notes` TEXT
 ); 
 
 CREATE TABLE `customers`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
    `driver_licence_number` VARCHAR(45) NOT NULL,
	`full_name` VARCHAR(70) NOT NULL,
	`address` VARCHAR(255) NOT NULL,
	`city` VARCHAR(45) NOT NULL,
	`zip_code` VARCHAR(45) NOT NULL,
	`notes` TEXT
);

CREATE TABLE `rental_orders`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`employee_id` INT NOT NULL,
	`customer_id` INT NOT NULL, 
	`car_id` INT NOT NULL,
	`car_condition` VARCHAR(255),
	`tank_level` INT,
	`kilometrage_start` INT,
	`kilometrage_end` INT,
	`total_kilometrage` INT,
	`start_date` DATE NOT NULL,
	`end_date` DATE NOT NULL,
	`total_days` INT,
	`rate_applied` ENUM('daily_rate', 'weekly_rate', 'monthly_rate', 'weekend_rate') NOT NULL,
	`tax_rate` DOUBLE(7, 2) NOT NULL,
	`order_status` TEXT,
	`notes` TEXT
);

ALTER TABLE `cars`
ADD CONSTRAINT `fk_cars_categories`
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`);

ALTER TABLE  `rental_orders`
ADD CONSTRAINT `fk_orders_employees`
FOREIGN KEY (`employee_id`)
REFERENCES `employees` (`id`);

ALTER TABLE `rental_orders`
ADD CONSTRAINT `fk_orders_customers`
FOREIGN KEY (`customer_id`)
REFERENCES `customers` (`id`);

ALTER TABLE `rental_orders`
ADD CONSTRAINT `fk_orders_cars`
FOREIGN KEY (`car_id`)
REFERENCES `cars` (`id`);

INSERT INTO `categories`(category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
VALUES ('first', 3, 20, 70, 5),
('second', 4, 22, 80, 7),
('third', 5, 31, 115, 9);

INSERT INTO cars(plate_number, make, model, category_id, available)
VALUES ('SX555', 'Mercedes', 'S-class', 2, true),
('somenum', 'Mercedes', 'G-class', 2, false),
('anothernum', 'Mercedes', 'S-class', 2, false);

INSERT INTO employees(first_name, last_name, title)
VALUES ('Pesho', 'Peshov', 'Boss'),
('name', 'name', 'title'),
('name2', 'name2', 'title2');

INSERT INTO customers(driver_licence_number, full_name, address, city, zip_code)
VALUES (9393938, 'Pesho Peshov', 'address', 'sofia', 'code'),
(929393, 'Pesho Peshov', 'address', 'sofia', 'code'),
(939393438, 'Pesho Peshov', 'address', 'sofia', 'code');


INSERT INTO rental_orders(employee_id, customer_id, car_id, start_date, end_date, rate_applied, tax_rate)
VALUES (1, 2, 1, '2018-01-02', '2018-01-07', 'daily_rate', 0.2),
(1, 1, 2, '2018-01-02', '2018-01-09', 'weekly_rate', 0.2),
(1, 2, 3, '2018-01-02', '2018-02-02', 'monthly_rate', 0.2);

SELECT * FROM `rental_orders`;