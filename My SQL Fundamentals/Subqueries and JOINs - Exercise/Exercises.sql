USE `soft_uni2`;

-- 01. Employee Address
SELECT `employee_id`, 
	`job_title`, 
	`e`.`address_id`, 
	`address_text`
	FROM `employees` AS `e`
INNER JOIN `addresses` AS `a`
	ON `e`.`address_id` = `a`.`address_id`
ORDER BY `e`.`address_id` ASC
LIMIT 5;

-- 02. Addresses with Towns
SELECT `e`.`first_name`,
	`e`.`last_name`,
	`t`.`name` AS `town`,
	`a`.`address_text`
	FROM `employees` AS `e`
INNER JOIN `addresses` AS `a`
	ON `e`.`address_id` = `a`.`address_id`
INNER JOIN `towns` AS `t`
	ON `a`.`town_id` = `t`.`town_id`
ORDER BY `first_name` ASC,
	`last_name` ASC
LIMIT 5;

-- 03. Sales Employee
SELECT `e`.`employee_id`,
	`e`.`first_name`,
	`e`.`last_name`,
	`d`.`name` AS `department_name`
	FROM `employees` AS `e`
INNER JOIN `departments` AS `d`
	ON `e`.`department_id` = `d`.`department_id`
HAVING LOWER(`department_name`) = 'sales'
ORDER BY `e`.`employee_id` DESC;

-- 04. Employee Departments
SELECT `e`.`employee_id`,
	`e`.`first_name`,
	`e`.`salary`,
	`d`.`name` AS `department_name`
	FROM `employees` AS `e`
INNER JOIN `departments` AS `d`
	ON `e`.`department_id` = `d`.`department_id`
HAVING `e`.`salary` > 15000
ORDER BY `d`.`department_id` DESC
LIMIT 5;

-- 05. Employees Without Project
SELECT `e`.`employee_id`,
	`e`.`first_name`
	FROM `employees` AS `e`
LEFT JOIN `employees_projects` AS `e_p`
	ON `e`.`employee_id` = `e_p`.`employee_id`
LEFT JOIN `projects` AS `p`
	ON `e_p`.`project_id` = `p`.`project_id`
WHERE `e_p`.`project_id` IS NULL
ORDER BY `e`.`employee_id` DESC
LIMIT 3;

-- 06. Employees Hired After
SELECT `e`.`first_name`,
	`e`.`last_name`,
	`e`.`hire_date`,
	`d`.`name` AS `dept_name`
	FROM `employees` AS `e`
INNER JOIN `departments` AS `d`
	ON `e`.`department_id` = `d`.`department_id`
HAVING `dept_name` IN ('Sales', 'Finance') 
	AND DATE(`e`.`hire_date`) > DATE('1999-01-01')
ORDER BY `hire_date` ASC;

-- 07. Employees with Project
SELECT `e`.`employee_id`,
	`e`.`first_name`,
	`p`.`name` AS `project_name`
	FROM `employees` AS `e`
INNER JOIN `employees_projects` AS `e_p`
	ON `e`.`employee_id` = `e_p`.`employee_id`
INNER JOIN `projects` AS `p`
	ON `e_p`.`project_id` = `p`.`project_id`
WHERE DATE(`p`.`start_date`) > DATE('2002-08-13')
	AND `p`.`end_date` IS NULL
ORDER BY `e`.`first_name` ASC,
	`project_name` ASC
LIMIT 5;

-- 08. Employee 24
SELECT `e`.`employee_id`,
	`e`.`first_name`,
    IF(`p`.`start_date` >= DATE('2005-01-01'), NULL, `p`.`name`) AS `project_name`
	FROM `employees` AS `e`
INNER JOIN `employees_projects` AS `e_p`
	ON `e`.`employee_id` = `e_p`.`employee_id`
INNER JOIN `projects` AS `p`
	ON `e_p`.`project_id` = `p`.`project_id`
WHERE `e`.`employee_id` = 24
ORDER BY `project_name`;

-- 09. Employee Manager
SELECT `e`.`employee_id`,
	`e`.`first_name`,
	`e`.`manager_id`,
	`e2`.`first_name` AS `manager_name`
	FROM `employees` AS `e`
INNER JOIN `employees` AS `e2`
	ON `e`.`manager_id` = `e2`.`employee_id`
WHERE `e`.`manager_id` IN (3, 7)
ORDER BY `e`.`first_name` ASC;

-- DA POPITAM KAKVO OZNACHAVA TAZI ON KLAUZA V KOQTO JOINVAM EDNA TABLICA SUS SEBE SI
-- 10. Employee Summary
SELECT `e`.`employee_id`,
	CONCAT(`e`.`first_name`, ' ', `e`.`last_name`) AS `employee_name`,
	CONCAT(`e2`.`first_name`, ' ', `e2`.`last_name`) AS `manager_name`,
	`d`.`name` AS `department_name`
    FROM `employees` AS `e`
INNER JOIN `employees` AS `e2`
	ON `e`.`manager_id` = `e2`.`employee_id`
INNER JOIN `departments` AS `d`
	ON `e`.`department_id` = `d`.`department_id`
ORDER BY `e`.`employee_id` ASC
LIMIT 5;

-- 11. Min Average Salary
SELECT MIN(`average_salaries`) AS `min_average_salary`
    FROM (SELECT AVG(`e`.`salary`) AS `average_salaries`
		FROM `employees` AS `e`
		GROUP BY `department_id`) AS `t`;


    
USE `geography`;
	
-- 12. Highest Peaks in Bulgaria
SELECT `c`.`country_code`,
	`m`.`mountain_range`,
	`p`.`peak_name`,
    `p`.`elevation`
	FROM `countries` AS `c`
INNER JOIN `mountains_countries` AS `m_c`
	ON `c`.`country_code` = `m_c`.`country_code`
INNER JOIN `mountains` AS `m`
	ON `m_c`.`mountain_id` = `m`.`id`
INNER JOIN `peaks` AS `p`
	ON `m`.`id` = `p`.`mountain_id`
WHERE LOWER(`c`.`country_code`) = 'bg'
	AND `p`.`elevation` > 2835
ORDER BY `p`.`elevation` DESC;

-- 13. Count Mountain Ranges
SELECT `c`.`country_code`,
	COUNT(`m`.`mountain_range`) AS `mountain_range_count`
    FROM `countries` AS `c`
INNER JOIN `mountains_countries` AS `m_c`
	ON `c`.`country_code` = `m_c`.`country_code`
INNER JOIN `mountains` AS `m`
	ON `m_c`.`mountain_id` = `m`.`id`
GROUP BY `c`.`country_code`
HAVING `c`.`country_code` IN ('BG', 'RU', 'US')
ORDER BY `mountain_range_count` DESC;

-- 14. Countries with Rivers
SELECT `c`.`country_name`,
	`r`.`river_name`
    FROM `countries` AS `c`
LEFT JOIN `countries_rivers` AS `c_r`
	ON `c`.`country_code` = `c_r`.`country_code`
LEFT JOIN `rivers` AS `r`
	ON `c_r`.`river_id` = `r`.`id`
WHERE LOWER(`c`.`continent_code`) = 'af'
ORDER BY `c`.`country_name` ASC
LIMIT 5;

-- 15. *Continents and Currencies
-- TODO

-- 16. Countries without any Mountains
SELECT COUNT(`countries`) AS `country_count`
	FROM (SELECT `c`.`country_code` AS `countries`
			FROM `countries` AS `c`
			LEFT JOIN `mountains_countries` AS `m_c`
				ON `c`.`country_code` = `m_c`.`country_code`
			LEFT JOIN `mountains` AS `m`
				ON `m_c`.`mountain_id` = `m`.`id`
			WHERE `m`.`id` IS NULL) AS `countries_without_mountains`;
            
-- 17. Highest Peak and Longest River by Country
-- TODO
SELECT `c`.`country_name`,
	(SELECT ) AS `highest_peak_elevation`,
	`longest_river_length`
    FROM ``