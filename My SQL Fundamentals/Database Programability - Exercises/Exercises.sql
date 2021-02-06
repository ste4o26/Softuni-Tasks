USE `soft_uni2`;

-- 01. Employees with Salary Above 35000
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above_35000`()
BEGIN 
	SELECT `first_name`,
		`last_name`
        FROM `employees` AS `e`
        WHERE `e`.`salary` > 35000
        ORDER BY `e`.`first_name` ASC,
			`e`.`last_name` ASC,
            `e`.`employee_id` ASC;
END $$
DELIMITER ;

#FOR TESTING
CALL `usp_get_employees_salary_above_35000`();

-- 02. Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above`(`given_salary` DECIMAL(9,4))
BEGIN
	SELECT `first_name`,
		`last_name`
        FROM `employees` AS `e`
        WHERE `e`.`salary` >= `given_salary`
        ORDER BY `e`.`first_name` ASC,
			`e`.`last_name` ASC,
			`e`.`employee_id` ASC;
END $$
DELIMITER ;

#FOR TESTING
CALL `usp_get_employees_salary_above`(48100);

-- 03. Town Names Starting With
DELIMITER $$
CREATE PROCEDURE `usp_get_towns_starting_with`(`town_prefix` VARCHAR(20))
BEGIN
	SELECT `name` AS `town_name`
		FROM `towns` AS `t`
	HAVING LOWER(`town_name`) LIKE CONCAT(LOWER(`town_prefix`), '%')
    ORDER BY `town_name` ASC;
END $$
DELIMITER ;

# FOR TESTING
CALL `usp_get_towns_starting_with`('b');

-- 04. Employees from Town
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_from_town`(`town_name` VARCHAR(25))
BEGIN 
	SELECT `e`.`first_name`,
		`e`.`last_name`
        FROM `employees` AS `e`
	INNER JOIN `addresses` AS `a`
		ON `e`.`address_id` = `a`.`address_id`
	INNER JOIN `towns` AS `t`
		ON `a`.`town_id` = `t`.`town_id`
	WHERE LOWER(`t`.`name`) = LOWER(`town_name`)
    ORDER BY `e`.`first_name` ASC,
		`e`.`last_name` ASC;
END $$
DELIMITER ;

# FOR TESTING
CALL `usp_get_employees_from_town`('Sofia');

-- 05. Salary Level Function
DELIMITER $$
CREATE FUNCTION `ufn_get_salary_level`(`employee_salary` DECIMAL(10,4))
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	DECLARE `result` VARCHAR(20);
	SET `result` = 
		(CASE 
			WHEN `employee_salary` < 30000 THEN 'Low'
			WHEN `employee_salary` BETWEEN 30000 AND 50000 THEN 'Average'
			WHEN `employee_salary` > 50000 THEN 'High'
		END);
	RETURN `result`;
END $$
DELIMITER ;

SELECT `ufn_get_salary_level`(588500) AS `salary_level`;

-- 06. Employees by Salary Level
DROP PROCEDURE `usp_get_employees_by_salary_level`;
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`salary_level` VARCHAR(20))
BEGIN
	SELECT `e`.`first_name`, 
		`e`.`last_name`
		FROM`employees` AS `e`
	WHERE (SELECT LOWER(`ufn_get_salary_level`(`e`.`salary`))) = LOWER(`salary_level`)
    ORDER BY `first_name` DESC,
		`last_name` DESC;
END $$
DELIMITER ;

CALL `usp_get_employees_by_salary_level`('high');

-- 07. Define Function TODO
DELIMITER $$
CREATE FUNCTION  `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	DECLARE `result` BOOLEAN;
    
END $$
DELIMITER ;