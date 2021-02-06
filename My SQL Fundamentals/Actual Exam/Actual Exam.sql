DROP DATABASE IF EXISTS `softuni_store_system_db`;
CREATE DATABASE `softuni_store_system_db`;
USE `softuni_store_system_db`;

CREATE TABLE `pictures`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `url` VARCHAR(100) NOT NULL,
    `added_on` DATETIME NOT NULL
);

CREATE TABLE `categories`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE `products`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(40) UNIQUE NOT NULL,
	`best_before` DATE,
	`price` DECIMAL(10, 2) NOT NULL,
	`description` TEXT,
	`category_id` INT NOT NULL,
	`picture_id` INT NOT NULL,
    
    CONSTRAINT `fk_products_categories`
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`),
    
    CONSTRAINT `fk_products_pictures`
    FOREIGN KEY (`picture_id`)
    REFERENCES `pictures`(`id`)
);

CREATE TABLE `towns`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE `addresses`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(50) UNIQUE NOT NULL,
    `town_id` INT NOT NULL,
    
    CONSTRAINT `fk_addresses_towns`
    FOREIGN KEY (`town_id`)
    REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`name` VARCHAR(20) UNIQUE NOT NULL,
	`rating` FLOAT NOT NULL,
	`has_parking` TINYINT(1) DEFAULT FALSE,
	`address_id` INT NOT NULL,
    
    CONSTRAINT `fk_stores_addresses`
    FOREIGN KEY (`address_id`)
    REFERENCES `addresses`(`id`)
);

CREATE TABLE `products_stores`(
	`product_id` INT NOT NULL,
	`store_id` INT NOT NULL,
    
    PRIMARY KEY(`product_id`, `store_id`),
    
    CONSTRAINT `fk_products_stores_products`
    FOREIGN KEY (`product_id`)
    REFERENCES `products`(`id`),
    
	CONSTRAINT `fk_products_stores_stores`
    FOREIGN KEY (`store_id`)
    REFERENCES `stores`(`id`)
);

CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`first_name` VARCHAR(15) NOT NULL,
	`middle_name` CHAR(1),
	`last_name` VARCHAR(20) NOT NULL,
	`salary` DECIMAL(19, 2) DEFAULT 0 NOT NULL,
	`hire_date` DATE NOT NULL,
	`manager_id` INT,
	`store_id` INT NOT NULL,
    
    CONSTRAINT `fk_employees_employees`
    FOREIGN KEY (`manager_id`)
    REFERENCES `employees`(`id`),
    
    CONSTRAINT `fk_employees_stores`
    FOREIGN KEY (`store_id`)
    REFERENCES `stores`(`id`)
);

-- Judje Tests for first task
-- 1.1
SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS 
WHERE TABLE_SCHEMA = 'softuni_store_system_db' 
ORDER BY COLUMN_NAME, TABLE_NAME;

-- 1.2
SELECT COLUMN_TYPE FROM INFORMATION_SCHEMA.COLUMNS 
WHERE TABLE_SCHEMA = 'softuni_store_system_db' 
ORDER BY COLUMN_NAME, TABLE_NAME; 

-- 1.3
SELECT COLUMN_KEY FROM INFORMATION_SCHEMA.COLUMNS 
WHERE TABLE_SCHEMA = 'softuni_stores_system' 
  AND COLUMN_NAME IN ('id','product_id','store_id', 
                      'town_id', 'address_id',
					'category_id', 'picture_id','manager_id') 
ORDER BY COLUMN_NAME, TABLE_NAME DESC, COLUMN_KEY DESC; 

-- Task 02. INSERT
-- insert into `products_stores`
-- select `p`.`id` as `product_id`,
-- 	1 as `store_id`
-- 	from `products` as `p`
-- where `p`.`id` not in(select `product_id` from `products_stores`);

-- judge test
-- SELECT store_id, s.name, p.name, product_id FROM products_stores 
-- JOIN products p ON p.id = products_stores.product_id 
-- JOIN stores s ON products_stores.store_id = s.id 
-- ORDER BY product_id, store_id;

-- Task 03. UPDATE
-- update `employees` as `e`
-- set `e`.`manager_id` = 3,
-- 	`e`.`salary` = `e`.`salary` - 500
-- where year(`e`.`hire_date`) > 2003 
-- 		and `e`.`store_id` not in(5, 14);
        
-- judge test
-- SELECT first_name, salary, hire_date, id
-- FROM employees  
-- WHERE manager_id = 3;

-- Task 04. DELETE
-- delete from `employees`
-- where `manager_id` is not null
-- 	and `salary` >= 6000
--     and `manager_id` != id;
    
-- judge test
-- SELECT first_name, salary, hire_date, id
-- FROM employees;

-- Section 3 QUERYING
-- Task 05. Employees
-- select `first_name`,
-- 	`middle_name`,
-- 	`last_name`,
-- 	`salary`,
-- 	`hire_date`
--     from `employees`
-- order by date(`hire_date`) desc;

-- Task 06. Products with old pictures
-- select `p`.`name`,
-- 	`p`.`price`,
-- 	`p`.`best_before`,
-- 	concat(substring(`p`.`description`, 1, 10), '...') as `short_description`,
-- 	`pi`.`url`
--     from `products` as `p`
-- inner join `pictures` as `pi`
-- 	on `p`.`picture_id` = `pi`.`id`
-- where char_length(`p`.`description`) > 100
-- 	and date(`pi`.`added_on`) < '2019-01-01'
--     and `p`.`price` > 20
-- order by `p`.`price` desc;

-- Task 07. Count of products in stores and their average
-- select `s`.`name`,
-- 	count(`p_s`.`product_id`) as `product_count`,
-- 	round(avg(`p`.`price`), 2) as `avg`
-- 	from `stores` as `s`
-- left join `products_stores` as `p_s`
-- 	on `s`.`id` = `p_s`.`store_id`
-- left join `products` as `p`
-- 	on `p_s`.`product_id` = `p`.`id`
-- group by `s`.`name`
-- order by `product_count` desc,
-- 	`avg` desc,
--     `s`.`id` asc;
    
-- Task 08. Specific employees
-- select concat(`e`.`first_name`, ' ', `e`.`last_name`) as `full_name`,
-- 	`s`.`name` as `store`,
-- 	`a`.`name` as `address`,
-- 	`e`.`salary`
--     from `employees` as `e`
-- inner join `stores` as `s`
-- 	on `e`.`store_id` = `s`.`id`
-- inner join `addresses` as `a`
-- 	on `s`.`address_id` = `a`.`id`
-- where `e`.`salary` < 7000
-- 	and locate('a', `a`.`name`) != 0
--     and char_length(`s`.`name`) > 5;

-- 09. Find all information about stores
-- select reverse(`s`.`name`) as `reversed_name`,
-- 	concat(upper(`t`.`name`), '-', `a`.`name`) as `full_address`,
-- 	count(`e`.`id`) as `employees_count`,
-- 	min(`p`.`price`) as `min_price`,
-- 	count(`p`.`id`) as `products_count`,
-- 	date_format(`pi`.`added_on`, '%D-%b-%Y') as `newest_pic`
--     from `stores` as `s`
-- inner join `products_stores` as `p_s`
-- 	on `s`.`id` = `p_s`.`store_id`
-- inner join `products` as `p`
-- 	on `p_s`.`product_id` = `p`.`id`
-- inner join `pictures` as `pi`
-- 	on `p`.`picture_id` = `pi`.`id`
-- left join `employees` as `e`
-- 	on `s`.`id` = `e`.`store_id`
-- inner join `addresses` as `a`
-- 	on `s`.`address_id` = `a`.`id`
-- inner join `towns` as `t`
-- 	on `a`.`town_id` = `t`.`id`
-- group by `reversed_name`
-- order by `reversed_name` asc,
-- 	`min_price` asc;
-- TODO opravi si q

-- 10. Find Full name of top paid employee by store
-- DROP FUNCTION `udf_top_paid_employee_by_store`;
-- DELIMITER $$
-- CREATE FUNCTION `udf_top_paid_employee_by_store`(`store_name` VARCHAR(50))
-- RETURNS VARCHAR(100)
-- DETERMINISTIC
-- BEGIN
--     
--     DECLARE result VARCHAR(50);
--     set result = (select concat_ws(' ', `t`.`full_name`, 'works in store for', floor(`t`.`years_of_experience`), 'years')
-- 		from(select concat(`e`.`first_name`, ' ', `e`.`middle_name`, '. ', `e`.`last_name`) as `full_name`,
-- 			if(datediff('2020-10-18', `e`.`hire_date`) < 365, 0, datediff('2020-10-18', `e`.`hire_date`) / 365) as `years_of_experience`
--             from `employees` as `e`
--             inner join `stores` as `s`
-- 				on `e`.`store_id` = `s`.`id`
--             where `s`.`name` = `store_name`
--             order by `e`.`salary` desc
--             limit 1) as `t`);
-- 	return result;  
--     
-- END; $$
-- DELIMITER ;

-- some tests
-- SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';
-- SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info'; 

-- Task 11. Update product price by address
DROP PROCEDURE `udp_update_product_price`;
DELIMITER $$
CREATE PROCEDURE udp_update_product_price(address_name VARCHAR(50))
BEGIN
	UPDATE products as p
    JOIN products_stores as ps
    ON p.id = ps.product_id
    JOIN stores as s
    ON s.id = ps.store_id
    JOIN addresses as a
    ON s.address_id = a.id
    SET p.`price` = IF (a.`name` LIKE '0%', p.`price`+ 100, p.`price` + 200)
    WHERE a.name = address_name;
END; $$
DELIMITER ;

-- judge tests
CALL udp_update_product_price('07 Armistice Parkway'); 
SELECT name, price FROM products WHERE id = 15; 

CALL udp_update_product_price('1 Cody Pass'); 
SELECT name, price FROM products WHERE id = 17; 
