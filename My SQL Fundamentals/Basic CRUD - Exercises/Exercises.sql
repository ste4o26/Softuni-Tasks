-- Part I – Queries for SoftUni Database 
USE `soft_uni2`;
-- 1. Find Names of All Employees by First Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id` ASC;

-- 2. Find Names of All Employees by Last Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE LOWER(`last_name`) LIKE '%ei%'
ORDER BY `employee_id` ASC;

-- 3. Find First Names of All Employees
SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10)
AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id` ASC;

-- 4. Find All Employees Except Engineers
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id` ASC;

-- 5. Find Towns with Name Length
SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5, 6)
ORDER BY `name` ASC;

-- 6.  Find Towns Starting With
SELECT `town_id`, `name`
FROM `towns`
WHERE UPPER(`name`) REGEXP '^([M, K, B, E])+'
ORDER BY `name` ASC;

-- 07. Find Towns Not Starting With
SELECT `town_id`, `name`
FROM `towns`
WHERE UPPER(`name`) NOT REGEXP '^([R, B, D])+'
ORDER BY `name` ASC;

-- 08. Create View Employees Hired After
CREATE VIEW `v_employees_hired_after_2000` AS 
SELECT `first_name`, `last_name`
FROM `employees`
WHERE YEAR(`hire_date`) > 2000
ORDER BY YEAR(`hire_date`) ASC;

SELECT * FROM `v_employees_hired_after_2000`;

-- 09. Length of Last Name
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;


-- Part II – Queries for Geography Database  
USE `geography`;

-- 10. Countries Holding ‘A’ 3 or More Times
SELECT `country_name`, `iso_code`
FROM `countries`
WHERE LOWER(`country_name`) LIKE '%a%a%a%'
ORDER BY `iso_code` ASC;

-- 11. Mix of Peak and River Names
SELECT `peak_name`, `river_name`,
LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2, CHAR_LENGTH(`river_name`) - 1))) AS `mix`
FROM `peaks`, `rivers`
WHERE SUBSTRING(`peak_name`, CHAR_LENGTH(`peak_name`), 1) = SUBSTRING(`river_name`, 1, 1)
ORDER BY `mix` ASC;

-- Part III – Queries for Diablo Database
USE `diablo`;

-- 12. Games From 2011 and 2012 Year
SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS `start`
FROM `games`
WHERE YEAR(`start`) IN (2011, 2012)
ORDER BY DATE(`start`) ASC,
`name` ASC
LIMIT 50;

-- 13. User Email Providers
SELECT `user_name`,
SUBSTRING_INDEX(`email`, '@', -1) AS `Email Provider`
FROM `users`
ORDER BY `Email Provider` ASC,
`user_name` ASC;

-- 14. Get Users with IP Address Like Pattern
SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name` ASC;

-- 15. Show All Games with Duration
SELECT `name` AS `game`,
CASE
	WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12
		THEN 'Morning'
	WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18
		THEN 'Afternoon'
	ELSE 'Evening'
END AS `Part of the Day`,
CASE 
	WHEN `duration` <= 3
		THEN 'Extra Short'
	WHEN `duration` BETWEEN 3 AND 6
		THEN 'Short'
	WHEN `duration` BETWEEN 6 AND 10
		THEN 'Long'
	ELSE 'Extra Long'
END AS `duration`
FROM `games`;


-- Part IV – Date Functions Queries 

 -- 16. Orders Table 
