-- 01.  Departments Info
SELECT `department_id`, COUNT(`e`.`id`)
FROM `employees` AS `e`
GROUP BY `department_id`
ORDER BY `department_id`;

-- 02. Average Salary
SELECT `department_id`, ROUND(AVG(`salary`), 2)
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

-- 3. Minimum Salary
SELECT `department_id`, MIN(`salary`) AS `Min Salary`
FROM `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800;

-- 04. Appetizers Count
SELECT COUNT(`name`) AS `count`
FROM `products`
WHERE `category_id` = 2 AND `price` > 8;

-- 05. Menu Prices
SELECT `category_id`,
	ROUND(AVG(`price`), 2) AS `Average Price`,
	ROUND(MIN(`price`), 2) AS `Cheapest Product`, 
	ROUND(MAX(`price`), 2) AS `Most Expensive Product`
FROM `products`
GROUP BY `category_id`;