DROP DATABASE IF EXISTS `minions`;
CREATE DATABASE `minions`;
USE `minions`;

CREATE TABLE `minions`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL,
`age` INT
);

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL;

ALTER TABLE `minions`
ADD CONSTRAINT `foreign_key_minions_towns` 
FOREIGN KEY(`town_id`)
REFERENCES `towns`(`id`);

-- judge wants all properties including tables id!!!
INSERT INTO `towns`(`id`, `name`)
VALUES (1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO `minions`(`id`, `name`, `age`, `town_id`)
VALUES (1,'Kevin', 22, 1),
(2,'Bob', 15, 3),
(3,'Steward', NULL, 2);

TRUNCATE TABLE `minions`;

DROP TABLE `minions`;
DROP TABLE `towns`;