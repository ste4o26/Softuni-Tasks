DROP DATABASE IF EXISTS `users`;
CREATE DATABASE `users`;
USE `users`;

CREATE TABLE `users`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `username` VARCHAR(30) NOT NULL,
	`password` VARCHAR(26) NOT NULL,
	`profile_picture` BLOB,
    `last_login_time` TIME,
    `is_deleted` BOOLEAN
);

INSERT INTO `users`(`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`)
VALUES('Ste4o26', 'enter12345', NULL, '16:48:52', false),
	('Doctor', 'drdMaistora', NULL, NULL, false),
	('Achkata785', 'achkamise', NULL, '10:16:38', false),
	('TheBigDick', 'shtaizkurtq', NULL, '23:38:46', false),
	('SADOmazo', 'hilqdoletenSEX', NULL, '18:29:12', true);

ALTER TABLE `users`
MODIFY COLUMN `id` INT,
DROP PRIMARY KEY;

ALTER TABLE `users`
ADD PRIMARY KEY (`id`, `username`);

ALTER TABLE `users`
MODIFY COLUMN `id` INT AUTO_INCREMENT NOT NULL;

ALTER TABLE `users`
MODIFY `last_login_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE `users`
MODIFY COLUMN `id` INT,
DROP PRIMARY KEY;

ALTER TABLE `users`
ADD PRIMARY KEY(`id`),
MODIFY COLUMN `id` INT AUTO_INCREMENT;

ALTER TABLE `users`
ADD UNIQUE (`username`);