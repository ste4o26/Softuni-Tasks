DROP DATABASE IF EXISTS `minions`;
CREATE DATABASE `minions`;

USE `minions`;

CREATE TABLE `minions` (
    `id` INT NOT NULL PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    `age` INT
);

CREATE TABLE `towns` (
    `id` INT NOT NULL PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL
);

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT `town_id`
FOREIGN KEY (`town_id`) 
REFERENCES `towns`(`id`);

INSERT INTO `towns`(`id`, `name`) 
VALUES(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO `minions`(`id`, `name`, `age`, `town_id`)
 VALUES(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);

TRUNCATE TABLE `minions`;

DROP TABLE `minions`;
DROP TABLE `towns`;

CREATE TABLE `people`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(100,2),
`weight` DOUBLE(100,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people`(`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES ('Ste4o', NULL, 1.83, 85.2, 'm', '1999-05-06', 'I love progrramin!'),
('Maria', NULL, 1.63, 50.2, 'f', '1989-04-01', 'I am whore!'),
('Ivan', NULL, 1.90, 75.1, 'm', '1999-10-09', 'I am nerd!'),
('Zlatka', NULL, 1.50, 48.2, 'f', '1999-11-20', 'I love suck dicks!'),
('Yordan', NULL, 1.83, 80.2, 'm', '1999-04-05', NULL);


CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`username` CHAR(30),
`password` CHAR(26),
`profile_picture` BLOB(900),
`last_login_time` TIME NOT NULL,
`is_deleted` BOOLEAN NOT NULL
);

INSERT INTO `users`(`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`)
VALUES ('Ste4o26', 'enter12345', NULL, '16:48:52', false),
('Doctor', 'drdMaistora', NULL, '12:20:10', false),
('Achkata785', 'achkamise', NULL, '10:16:38', false),
('TheBigDick', 'shtaizkurtq', NULL, '23:38:46', false),
('SADOmazo', 'hilqdoletenSEX', NULL, '18:29:12', true);