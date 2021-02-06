DROP DATABASE IF EXISTS `movies`;
CREATE DATABASE `movies`;
USE `movies`;

CREATE TABLE `directors`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `director_name` VARCHAR(45) NOT NULL,
    `notes` VARCHAR(255)
);

CREATE TABLE `genres`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `genre_name` VARCHAR(45) NOT NULL,
    `notes` VARCHAR(255)
);

CREATE TABLE `categories`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `category_name` VARCHAR(45) NOT NULL,
    `notes` VARCHAR(255)
);

CREATE TABLE `movies`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `title` VARCHAR(45) NOT NULL,
    `director_id` INT NOT NULL,
    `copyright_year` DATE,
    `length` TIME NOT NULL,
    `genre_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `rating` DOUBLE(2, 1) DEFAULT 0.0 NOT NULL,
    `notes` VARCHAR(255)
);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_directors`
FOREIGN KEY (`director_id`)
REFERENCES `directors`(`id`);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_genres`
FOREIGN KEY (`genre_id`)
REFERENCES `genres`(`id`);

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_categories`
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`);

INSERT INTO `directors` (`director_name`, `notes`)
VALUES ('Pencho', 'Junior director'),
	('Stefan', 'Senior director'),
    ('Mistin', 'Pomoshtnik direcrtor'),
    ('Krasen', 'Birthday boy director'),
    ('Yusmen', NULL);

INSERT INTO `genres` (`genre_name`, `notes`)
VALUES ('Triller', NULL),
	('Comedy', 'The funniest genre!'),
    ('Action', NULL),
    ('Horror', 'Horror movies can scare you a lot!'),
    ('Fantasy', 'The best genre for dreamers out there!');

INSERT INTO `categories` (`category_name`, `notes`)
VALUES ('American movies', NULL),
	('Classic movies', 'Classic is the best!'),
    ('Serial movies', 'Series stories with couple of seasons and episodes'),
    ('Animated movies', 'Animated series stories with couple of seasons and episodes'),
    ('Family movies', NULL);

INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES ('The black widow', 2, '2021-5-26', '1:32:26', 3, 2, 4.8, 'Black Widow is an upcoming American superhero film based on the Marvel Comics character'),
	('Project Power', 1, '2022-2-12', '1:18:48', 5, 1, 4.9, NULL),
    ('Yu-Gi-Oh', 3, '2024-10-20', '1:45:32', 5, 4, 5.0, 'The best card game anime series ever'),
    ('Inferno', 5, '2026-1-18', '1:00:00', 1, 2, 3.5, 'Some shitty movie'),
    ('Sherlock Holmes', 4, '2023-12-13', '2:52:39', 4, 5, 4.2, NULL);