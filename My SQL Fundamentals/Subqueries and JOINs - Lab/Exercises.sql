USE `soft_uni2`;

-- 01. Managers
SELECT `employee_id`,
CONCAT(`first_name`, ' ', `last_name`) AS `full_name`,
`d`.`department_id`,
`d`.`name` AS `department_name`
FROM `employees` AS `e`
INNER JOIN `departments` AS `d`
ON `e`.`employee_id` = `d`.`manager_id`
ORDER BY `e`.`employee_id`
LIMIT 5;

-- 02. Towns and Addresses
SELECT `t`.`town_id`,
`name` AS `town_name`,
`address_text`
FROM `towns` AS `t`
INNER JOIN `addresses` AS `a`
ON `t`.`town_id` = `a`.`town_id`
HAVING `town_name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY `town_id`,
`address_id`;

-- 03. Employees Without Managers
SELECT `employee_id`, 
`first_name`, 
`last_name`, 
`department_id`, 
`salary`
FROM `employees` AS `e`
WHERE `e`.`manager_id` IS NULL;

-- 04. High Salary
SELECT COUNT(`employee_id`) AS `count`
FROM `employees` AS `e`
WHERE `e`.`salary` > (SELECT AVG(`salary`) 
        FROM `employees`);