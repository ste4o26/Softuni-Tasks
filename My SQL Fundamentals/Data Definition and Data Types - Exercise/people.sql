DROP DATABASE IF EXISTS `people`;
CREATE DATABASE  `people`;
USE `people`;

CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(6, 2),
`weight` DOUBLE(6, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people`(`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES('Ste4o', NULL, 1.83, 85.2, 'm', '1999-05-06', 'I love progrramin!'),
('Maria', NULL, 1.63, 50.2, 'f', '1989-04-01', 'I am whore!'),
('Ivan', NULL, 1.90, 75.1, 'm', '1999-10-09', 'I am nerd!'),
('Zlatka', NULL, 1.50, 48.2, 'f', '1999-11-20', 'I love suck dicks!'),
('Yordan', NULL, 1.83, 80.2, 'm', '1999-04-05', NULL);