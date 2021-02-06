DROP DATABASE IF EXISTS `football_scout_database`;
CREATE DATABASE `football_scout_database`;
USE `football_scout_database`;

-- =================
-- 1st SECTION Data Definition Language 
-- =================

-- 01. Table Design
CREATE TABLE `countries`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `country_id` INT NOT NULL,
    
    FOREIGN KEY(`country_id`)
    REFERENCES `countries`(`id`)
);

CREATE TABLE `stadiums`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	`name` VARCHAR(45) NOT NULL,
	`capacity` INT NOT NULL,
	`town_id` INT NOT NULL,
    
    FOREIGN KEY(`town_id`)
    REFERENCES `towns`(`id`)
);

CREATE TABLE `teams`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	`name` VARCHAR(45) NOT NULL,
	`established` DATE NOT NULL,
	`fan_base` BIGINT NOT NULL,
	`stadium_id` INT NOT NULL,
    
    FOREIGN KEY(`stadium_id`)
    REFERENCES `stadiums`(`id`)
);

CREATE TABLE `coaches`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	`first_name` VARCHAR(10) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
	`salary` DECIMAL(10, 2) DEFAULT 0 NOT NULL,
	`coach_level` INT DEFAULT 0 NOT NULL
);


CREATE TABLE `skills_data`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	`dribbling` INT DEFAULT 0,
	`pace` INT DEFAULT 0,
	`passing` INT DEFAULT 0,
	`shooting` INT DEFAULT 0,
	`speed` INT DEFAULT 0,
	`strength` INT DEFAULT 0
);

CREATE TABLE `players`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	`first_name` VARCHAR(10) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
	`age` INT DEFAULT 0 NOT NULL,
	`position` CHAR(1) NOT NULL,
	`salary` DECIMAL(10, 2) DEFAULT 0,
	`hire_date` DATETIME,
	`skills_data_id` INT NOT NULL,
	`team_id` INT,
    
    FOREIGN KEY(`skills_data_id`)
    REFERENCES `skills_data`(`id`),
    
    FOREIGN KEY(`team_id`)
    REFERENCES `teams`(`id`)
);

CREATE TABLE `players_coaches`(
	`player_id` INT,
    `coach_id` INT,
    
    PRIMARY KEY(`player_id`, `coach_id`),
    
    FOREIGN KEY(`player_id`)
    REFERENCES `players`(`id`),
    
    FOREIGN KEY(`coach_id`)
    REFERENCES `coaches`(`id`)
);

-- =================
-- 2nd SECTION DATA MANIPULATION LANGUAGE
-- =================

-- 02. Insert
INSERT INTO `coaches`(`first_name`, `last_name`, `salary`, `coach_level`)
SELECT `first_name`, 
 	`last_name`, 
     `p`.`salary` * 2 AS `salary`, 
     LENGTH(`p`.`first_name`) AS `coach_level`
     FROM `players` AS `p`
WHERE `p`.`age` >= 45;


-- 03. Update
UPDATE `coaches` AS `c`
INNER JOIN `players_coaches` AS `p_c`
	ON `c`.`id` = `p_c`.`coach_id`
SET `coach_level` = `coach_level` + 1
WHERE (SELECT COUNT(*) 
		FROM `players_coaches`
		) >= 1
	AND `c`.`first_name` LIKE 'A%';

-- TO HAVE A LOOK OF UPDATES THAT I MADE
SELECT *
	FROM `coaches` AS `c`
INNER JOIN `players_coaches` AS `p_c`
	ON `c`.`id` = `p_c`.`coach_id`
GROUP BY `id`;

-- 04. Delete
DELETE FROM `players` AS `p`
WHERE `p`.`age` >= 45;


-- =================
-- 3rd SECTION QUERYING
-- =================

-- 05. Players
SELECT `first_name`,
	`age`,
    `salary`
	FROM `players`
ORDER BY `salary` DESC;

-- 06. Young offense players without contract
SELECT `p`.`id`,
	CONCAT(`p`.`first_name`, ' ', `p`.`last_name`) AS `full_name`,
	`p`.`age`,
	`p`.`position`,
	`p`.`hire_date`
    FROM `players` AS `p`
INNER JOIN `skills_data` AS `s_d`
	ON `p`.`skills_data_id` = `s_d`.`id`
WHERE `p`.`age` < 23
	AND `p`.`position` = 'A'
    AND `p`.`hire_date` IS NULL
    AND `s_d`.`strength` > 50
ORDER BY `p`.`salary` ASC,
	`p`.`age` ASC;
    
-- 07. Detail info for all teams
SELECT `name` AS `team_name`,
	`established`,
	`fan_base`,
	COUNT(`p`.`id`) AS `players_count`
	FROM `teams` AS `t`
LEFT JOIN `players` AS `p`
	ON `t`.`id` = `p`.`team_id`
GROUP BY `established`
ORDER BY `players_count` DESC,
	`fan_base` DESC;

-- MAY NEED TO PUT LEFT JOIN ON ALL OF THE JONS!!!
-- 08. The fastest player by towns
SELECT MAX(`s_d`.`speed`) AS `max_speed`,
	`t`.`name` AS `town_name`
	FROM `towns` AS `t`
LEFT JOIN `stadiums` AS `s`
	ON `s`.`town_id` = `t`.`id`
LEFT JOIN `teams`
	ON `teams`.`stadium_id` = `s`.`id`
LEFT JOIN `players` AS `p`
	ON	`p`.`team_id` =  `teams`.`id`
LEFT JOIN `skills_data` AS `s_d`
	ON `p`.`skills_data_id` = `s_d`.`id`
WHERE `teams`.`name` != 'Devify'
GROUP BY `town_name`
ORDER BY `max_speed` DESC,
	`town_name`;

-- 09. Total salaries and players by country
SELECT `c`.`name`, 
	COUNT(`p`.`id`) AS `total_count_of_players`,
	SUM(`p`.`salary`) AS `total_sum_of_salaries`
    FROM `countries` AS `c`
LEFT JOIN `towns` AS `to`
	ON `c`.`id` = `to`.`country_id`
LEFT JOIN `stadiums` AS `s`
	ON `to`.`id` = `s`.`town_id`
LEFT JOIN `teams` AS `te`
	ON `s`.`id` = `te`.`stadium_id`
LEFT JOIN `players` AS `p`
	ON `te`.`id` = `p`.`team_id`
GROUP BY `c`.`name`
ORDER BY `total_count_of_players` DESC,
	`c`.`name` ASC;


-- 10. Find all players that play on stadium
DROP FUNCTION `udf_stadium_players_count`;
 
DELIMITER $$
CREATE FUNCTION `udf_stadium_players_count`(`stadium_name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE `result` INT;
    
	SET `result` = (SELECT COUNT(p.id) AS `count`
		FROM `stadiums` AS `s`
	INNER JOIN `teams` AS `t`
		ON `s`.`id` = `t`.`stadium_id`
	INNER JOIN `players` AS `p`
		ON `t`.`id` = `p`.`team_id`
	WHERE `s`.`name` = `stadium_name`);
    
    RETURN result;
END $$
DELIMITER ;

SELECT `udf_stadium_players_count`('Linklinks') AS `count`;


-- 11. Find good playmaker by teams
DROP PROCEDURE `udp_find_playmaker`;

DELIMITER $$
CREATE PROCEDURE `udp_find_playmaker`(`min_dribble_points` INT, `team_name` VARCHAR(45))
BEGIN

	SELECT CONCAT(`p`.`first_name`, ' ', `p`.`last_name`) AS `full_name`,
		`p`.`age`,
        `p`.`salary`,
        `s_d`.`dribbling`,
        `s_d`.`speed`,
        `t`.`name` AS `team_name`
        FROM `teams` AS `t`
	INNER JOIN `players` AS `p`
		ON `t`.`id` = `p`.`team_id`
	INNER JOIN `skills_data` AS `s_d`
		ON `p`.`skills_data_id` = `s_d`.`id`
	WHERE `t`.`name` = `team_name`
		AND `s_d`.`dribbling` > `min_dribble_points`
        AND `s_d`.`speed` > (SELECT AVG(`speed`) FROM `skills_data`)
	ORDER BY `s_d`.`speed` DESC
    LIMIT 1;

END $$
DELIMITER ;

CALL `udp_find_playmaker`(20, 'Skyble');