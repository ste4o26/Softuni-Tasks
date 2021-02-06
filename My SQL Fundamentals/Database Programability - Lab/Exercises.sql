USE `soft_uni2`;

-- 1. Count Employees by Town
DELIMITER $$
CREATE FUNCTION `ufn_count_employees_by_town`(`town_name` VARCHAR(45))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE `count` INT;
	  SET `count` = (SELECT COUNT(`employee_id`) AS `employee_count_by_town`
		FROM `employees` AS `e`
    INNER JOIN `addresses` AS `a`
		ON `e`.`address_id` = `a`.`address_id`
	INNER JOIN `towns` AS `t`
		ON `a`.`town_id` = `t`.`town_id`
	WHERE LOWER(`t`.`name`) = LOWER(`town_name`));
    RETURN (`count`);
END $$
DELIMITER ;

SELECT `ufn_count_employees_by_town`('Sofia') AS `count`;

-- 02. Employees Promotion
DELIMITER $$
CREATE PROCEDURE `usp_raise_salaries`(`department_name` VARCHAR(45))
BEGIN 
	UPDATE `employees` AS `e`
	INNER JOIN `departments` AS `d`
		ON `e`.`department_id` = `d`.`department_id`
	SET `e`.`salary` = `e`.`salary` * 1.05
    WHERE `d`.`name` = `department_name`;
END $$
DELIMITER ;

CALL `usp_raise_salaries`('Engineering');

# FOR TESTING
SELECT `employee_id`, `first_name`, `salary`
	FROM `employees` AS `e`
INNER JOIN `departments` AS `d`
	ON `e`.`department_id` = `d`.`department_id`
WHERE LOWER(`d`.`name`) = LOWER('Engineering')
ORDER BY `e`.`employee_id`;

-- 03. Employees Promotion by ID
DELIMITER $$
CREATE PROCEDURE `usp_raise_salary_by_id`(`id` INT)
BEGIN
	START TRANSACTION;
		IF((SELECT COUNT(`employee_id`) AS `count`
				FROM `employees` AS `e`
				WHERE `e`.`employee_id` = `id`) != 1)
		THEN ROLLBACK;
        ELSE
			UPDATE `employees` AS `e`
				SET `e`.`salary` = `e`.`salary` * 1.05
			WHERE `e`.`employee_id` = `id`;
		END IF;
	COMMIT;
END $$
DELIMITER ;

CALL `usp_raise_salary_by_id`(178);

# FOR TESTING 
SELECT * FROM `employees` AS `e`
WHERE `e`.`employee_id` = 178;

-- 04. Triggered
CREATE TABLE `deleted_employees`(
	`employee_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
    `first_name` VARCHAR(25) NOT NULL,
    `last_name` VARCHAR(25) NOT NULL,
    `middle_name` VARCHAR(25),
	`job_title` VARCHAR(45) NOT NULL,
    `department_id` INT,
    `salary` DECIMAL(9, 4)
);

DELIMITER $$
CREATE TRIGGER `on_deleted_employee`
	AFTER DELETE
	ON `employees` FOR EACH ROW
    BEGIN
		INSERT INTO `deleted_employees`(`first_name`, `last_name`, `middle_name`, `job_title`, `department_id`, `salary`)
		VALUES(OLD.`first_name`, OLD.`last_name`, OLD.`middle_name`, OLD.`job_title`, OLD.`department_id`, OLD.`salary`);
	END $$
DELIMITER ;

SELECT * FROM `deleted_employees`;
SELECT * FROM `employees`;

DELETE FROM `employees` AS `e`
	WHERE `e`.`employee_id` = 3;