DROP DATABASE IF EXISTS `ruk_database`;
CREATE DATABASE `ruk_database`;
USE `ruk_database`;

-- Section 1: Data Definition Language
-- TASK 01. Table Design
CREATE TABLE `branches`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`first_name` VARCHAR(20) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
	`salary` DECIMAL(10, 2) NOT NULL,
	`started_on` DATE NOT NULL,
	`branch_id` INT NOT NULL,

	CONSTRAINT `fk_employees_branches`
    FOREIGN KEY(`branch_id`)
    REFERENCES `branches`(`id`)
);

CREATE TABLE `clients`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`full_name` VARCHAR(50) NOT NULL,
	`age` INT NOT NULL
);

CREATE TABLE `employees_clients`(	
	`employee_id` INT,
	`client_id` INT,
    
    PRIMARY KEY(`employee_id`, `client_id`),
    
    CONSTRAINT `fk_employees_clients_employees`
    FOREIGN KEY(`employee_id`)
    REFERENCES `employees`(`id`),
    
	CONSTRAINT `fk_employees_clients_clients`
    FOREIGN KEY(`client_id`)
    REFERENCES `clients`(`id`)
);

CREATE TABLE `bank_accounts`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`account_number` VARCHAR(10) NOT NULL,
	`balance` DECIMAL(10, 2) NOT NULL,
	`client_id` INT NOT NULL UNIQUE,
    
    CONSTRAINT `fk_bank_accounts_clients`
    FOREIGN KEY(`client_id`)
    REFERENCES `clients`(`id`)
);

CREATE TABLE `cards`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `card_number` VARCHAR(19) NOT NULL,
	`card_status` VARCHAR(7) NOT NULL,
	`bank_account_id` INT NOT NULL,
    
    CONSTRAINT `fk_cards_bank_accounts`
    FOREIGN KEY(`bank_account_id`)
    REFERENCES `bank_accounts`(`id`)
);

-- Section 2: Data Manipulation Language
-- TASK 02. Insert 
INSERT INTO `cards`(`card_number`, `card_status`, `bank_account_id`)
SELECT REVERSE(`c`.`full_name`) AS `card_number`,
	'Active' AS `card_status`,
    `c`.`id` as `bank_account_id`
	FROM `clients` AS `c`
WHERE `c`.`id` BETWEEN 191 AND 200;

-- TASK 03. Update
UPDATE `employees_clients` AS `e_c`
SET `e_c`.`employee_id` = 
	(SELECT `t`.`employee_id`
		FROM(SELECT `employee_id`,
			count(`client_id`) AS `count`
			FROM `employees_clients`
            GROUP BY `employee_id`) AS `t`
            order by `t`.`count` asc
            limit 1)
WHERE `e_c`.`employee_id` = `e_c`.`client_id`;

-- ANOTHER SOLUTION SAME RESULT!!!
SET SQL_SAFE_UPDATES = 0;

UPDATE employees_clients as ec
JOIN
(SELECT ec1.employee_id, 
		COUNT(ec1.client_id) AS 'count'
		FROM employees_clients as ec1 
		GROUP BY ec1.employee_id
		ORDER BY `count`, ec1.employee_id) AS s
SET ec.employee_id = s.employee_id
WHERE ec.employee_id = ec.client_id;

    
    

-- TASK 04. Delete
DELETE `e`
FROM `employees` AS `e`
LEFT JOIN `employees_clients` AS `e_c`
	ON `e`.`id` = `e_c`.`employee_id`
WHERE `e_c`.`employee_id` IS NULL;

-- Section 3: Querying 
-- TASK 05. 05. Clients

SELECT `c`.`id`,
	`c`.`full_name`
    FROM `clients` AS `c`
ORDER BY `c`.`id` ASC;

-- TASK 06. Newbies
SELECT `e`.`id`, 
	CONCAT(`e`.`first_name`, ' ', `e`.`last_name`) AS `full_name`, 
	CONCAT('$', `e`.`salary`) AS `salary`, 
	`e`.`started_on`
	FROM `employees` AS `e`
WHERE `e`.`salary` >= 100000
	AND DATE(`e`.`started_on`) >= '2018-01-01'
ORDER BY `e`.`salary` DESC,
	`e`.`id` ASC;
    
-- 07. Cards against Humanity
SELECT `ca`.`id`,
	concat(`ca`.`card_number`, ' : ', `c`.`full_name`) AS `card_token`
	FROM `cards` AS `ca`
INNER JOIN `bank_accounts` AS `b_a`
	ON `ca`.`bank_account_id` = `b_a`.`id`
INNER JOIN `clients` AS `c`
	ON `b_a`.`client_id` = `c`.`id`
ORDER BY `ca`.`id` DESC;

-- 08. Top 5 Employees
SELECT concat(`e`.`first_name`, ' ', `e`.`last_name`) AS `name`,
	`e`.`started_on`,
    count(`e_c`.`client_id`) AS `count_of_clients`
    FROM `employees` AS `e`
INNER JOIN `employees_clients` AS `e_c`
	ON `e`.`id` = `e_c`.`employee_id`
GROUP BY `e_c`.`employee_id`
ORDER BY `count_of_clients` DESC,
	`e`.`id`
LIMIT 5;


-- 09. Branch cards
SELECT `b`.`name`,
	COUNT(`ca`.`id`) AS `count_of_cards`
	FROM `branches` AS `b`
INNER JOIN `employees` AS `e`
	ON `b`.`id` = `e`.`branch_id`
inner join `employees_clients` AS `e_c`
	ON `e`.`id` = `e_c`.`employee_id`
INNER JOIN `clients` AS `c`
	ON `e_c`.`client_id` = `c`.`id`
INNER JOIN `bank_accounts` AS `b_a`
	ON `c`.`id` = `b_a`.`client_id`
INNER JOIN `cards` AS `ca`
	ON `b_a`.`id` = `ca`.`bank_account_id`
GROUP BY `b`.`name`
ORDER BY `count_of_cards` DESC,
	`b`.`name` ASC;
    

-- TASK 10 Extract client cards count
DROP FUNCTION `udf_client_cards_count`;

DELIMITER $$
CREATE FUNCTION `udf_client_cards_count`(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE `cards_count` INT;
    
    SET `cards_count` = (SELECT COUNT(`ca`.`id`)
			FROM `clients` AS c
		INNER JOIN `bank_accounts` AS `b_a`
			ON `c`.`id` = `b_a`.`client_id`
		INNER JOIN `cards` AS `ca`
			ON `b_a`.`id` = `ca`.`bank_account_id`
		WHERE `c`.`full_name` = `name`);
	
    RETURN `cards_count`;
END $$
DELIMITER ;

SELECT `udf_client_cards_count`('Baxy David');

-- TASK 11. Client Info
DROP PROCEDURE `udp_client_info`;

DELIMITER $$
CREATE PROCEDURE `udp_client_info`(`full_name` VARCHAR(50))
BEGIN
	SELECT `c`.`full_name`,
		`c`.`age`,
		`b_a`.`account_number`,
        CONCAT('$', `b_a`.`balance`) AS `balance`
        FROM `clients` AS `c`
	INNER JOIN `bank_accounts` AS `b_a`
		ON `c`.`id` = `b_a`.`client_id`
	WHERE `c`.`full_name` = `full_name`;
END $$
DELIMITER ;

CALL `udp_client_info`('Hunter Wesgate');