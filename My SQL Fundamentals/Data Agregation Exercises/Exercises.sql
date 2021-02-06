USE `gringotts`;

-- 01. Records’ Count
SELECT COUNT(`id`) AS `count`
FROM `wizzard_deposits`;

-- 02. Longest Magic Wand
SELECT MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits`;

-- 03. Longest Magic Wand per Deposit Groups
SELECT `deposit_group`,
MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand`,
`deposit_group`;

-- 04. Smallest Deposit Group per Magic Wand Size
SELECT `deposit_group`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY AVG(`magic_wand_size`)
LIMIT 1;

-- 05. Deposits Sum
SELECT `deposit_group`, 
SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;

-- 06. Deposits Sum for Ollivander Family
SELECT `deposit_group`,
SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group` ASC;

-- 07. Deposits Filter
SELECT `deposit_group`,
SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

-- 8. Deposit Charge
SELECT `deposit_group`,
`magic_wand_creator`,
MIN(`deposit_charge`) AS `min_deposit_charge`
FROM `wizzard_deposits`
GROUP BY `deposit_group`,
`magic_wand_creator`
ORDER BY `magic_wand_creator` ASC,
`deposit_group` ASC;

-- 09. Age Groups
SELECT 
CASE 
	WHEN `age` <= 10 THEN '[0-10]'
	WHEN `age` >= 11 && `age` <= 20 THEN '[11-20]'
	WHEN `age` >= 21 && `age` <= 30 THEN '[21-30]'
	WHEN `age` >= 31 && `age` <= 40 THEN '[31-40]'
	WHEN `age` >= 41 && `age` <= 50 THEN '[41-50]'
	WHEN `age` >= 51 && `age` <= 60 THEN '[51-60]'
	ELSE '[61+]'
END AS `age_group`,
COUNT(*) AS `wizzard_count`
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `wizzard_count` ASC;

-- 10. First Letter
SELECT SUBSTRING(`first_name`, 1, 1) AS `first_letter`
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter` ASC;

-- 11. Average Interest
SELECT `deposit_group`,
`is_deposit_expired`,
AVG(`deposit_interest`) AS `average_interest`
FROM `wizzard_deposits`
WHERE UNIX_TIMESTAMP(`deposit_start_date`) > UNIX_TIMESTAMP('1985-01-01')
GROUP BY `deposit_group`,
`is_deposit_expired`
ORDER BY `deposit_group` DESC,
`is_deposit_expired` ASC;

-- 12. Rich Wizard, Poor Wizard
SELECT SUM(`difference`.`next`) AS `sum_difference`
FROM 
	(SELECT `deposit_amount` - 
		(SELECT `deposit_amount`
		FROM `wizzard_deposits`
        WHERE `id` = `current`.`id` + 1) AS `next`
    FROM `wizzard_deposits` AS `current`) 
AS `difference`;


USE `soft_uni2`;

-- 13. Employees Minimum Salaries
SELECT `department_id`, 
MIN(`salary`) AS `minimum_salary`
FROM `employees`
WHERE UNIX_TIMESTAMP(`hire_date`) > UNIX_TIMESTAMP('2000-01-01')
	AND (`department_id` = 2 OR 
		`department_id` = 5 OR 
		`department_id` = 7)
GROUP BY `department_id`
ORDER BY `department_id` ASC;	

-- 14.Employees Average Salaries
DROP TABLE `departments_employees`;
CREATE TABLE `departments_employees`
AS SELECT * FROM employees
WHERE salary > 30000;

UPDATE `departments_employees`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

DELETE FROM `departments_employees`
WHERE `manager_id` = 42;

SELECT `department_id`, 
AVG(`salary`) AS `avg_salary` 
FROM `departments_employees`
GROUP BY `department_id`
ORDER BY `department_id` ASC;


-- 15. Employees Maximum Salaries
SELECT `department_id`, 
MAX(`salary`) AS `max_salary`
FROM `employees`
GROUP BY `department_id`
HAVING !(`max_salary` >= 30000 AND `max_salary` <= 70000)
ORDER BY `department_id`;

-- 16.Employees Count Salaries
SELECT COUNT(`employee_id`) AS `count`
FROM `employees`
WHERE `manager_id` IS NULL;

-- 17.3rd Highest Salary*
SELECT `department_id`,
(SELECT DISTINCT `salary`
	FROM `employees`
	WHERE `t1`.`department_id` = `department_id`
	ORDER BY `salary` DESC
	LIMIT 2, 1) `third_highest_salary`
FROM `employees` AS `t1`
GROUP BY `department_id`
HAVING `third_highest_salary` IS NOT NULL
ORDER BY `department_id`;

-- 18. Salary Challenge**
SELECT `first_name`, `last_name`, `department_id`
FROM `employees` AS `e`
WHERE `salary` > (SELECT AVG(`salary`)
					FROM `employees`
                    WHERE  `department_id` = `e`.`department_id`)
ORDER BY `department_id` ASC,
`employee_id` ASC
LIMIT 10;

-- 19.Departments Total Salaries
SELECT `department_id`,
SUM(`salary`) AS `total_salary`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;