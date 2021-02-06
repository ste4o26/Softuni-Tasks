DROP DATABASE IF EXISTS `colonial_blog_database`;
CREATE DATABASE `colonial_blog_database`;
USE `colonial_blog_database`;

-- Section 1 Data Definition Language 
-- TASK 01. Table Design 

CREATE TABLE `users`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `username` VARCHAR(30) NOT NULL UNIQUE,
    `password` VARCHAR(30) NOT NULL ,
    `email` VARCHAR(50) NOT NULL,
    
    index name(email)
);

CREATE TABLE `categories`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `category` VARCHAR(30) NOT NULL
);

CREATE TABLE `articles`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `content` TEXT,
    `category_id` INT,
    
    CONSTRAINT `fk_articles_categories`
    FOREIGN KEY(`category_id`) 
    REFERENCES `categories`(`id`)
);

CREATE TABLE `users_articles`(
	`user_id` INT,
    `article_id` INT,
    
    PRIMARY KEY(`user_id`, `article_id`),
    
    CONSTRAINT `fk_users_articles_users`
    FOREIGN KEY(`user_id`)
    REFERENCES `users`(`id`),
    
    CONSTRAINT `fk_users_articles_articles`
    FOREIGN KEY(`article_id`)
    REFERENCES `articles`(`id`)
);

CREATE TABLE `comments`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `comment` VARCHAR(255) NOT NULL,
    `article_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    
    CONSTRAINT `fk_comments_articles`
    FOREIGN KEY(`article_id`)
    REFERENCES `articles`(`id`),
    
    CONSTRAINT `fk_comments_users`
    FOREIGN KEY(`user_id`)
    REFERENCES `users`(`id`)
);

CREATE TABLE `likes`(
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `article_id` INT,
    `comment_id` INT,
    `user_id` INT NOT NULL,
    
    CONSTRAINT `fk_likes_articles`
    FOREIGN KEY (`article_id`)
    REFERENCES `articles`(`id`),
    
    CONSTRAINT `fk_likes_comments`
    FOREIGN KEY (`comment_id`)
    REFERENCES `comments`(`id`),
    
    CONSTRAINT `fk_likes_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `users`(`id`)
);

-- Section 2 Data Manipulation Language 
-- TASK 02. Data Insertion
INSERT INTO `likes`(`article_id`, `comment_id`, `user_id`)
SELECT IF(`u`.`id` % 2 = 0, 
		(SELECT LENGTH(`u`.`username`) AS `article_id`),
        NULL) AS `article_id`,
	IF(`u`.`id` % 2 = 0,
		NULL, 
        (SELECT LENGTH(`u`.`email`) AS `comment_id`)) AS `comment_id`,
	`u`.`id`
	FROM `users` AS `u` 
WHERE `u`.`id` BETWEEN 16 AND 20;

-- TASK 03. DATA UPDATE
UPDATE `comments` AS `c`
	SET `comment` = CASE
		WHEN `c`.`id` % 2 = 0 THEN 'Very good article.'
		WHEN `c`.`id` % 3 = 0 THEN 'This is interesting.'
		WHEN `c`.`id` % 5 = 0 THEN 'I definitely will read the article again.'
		WHEN `c`.`id` % 7 = 0 THEN 'The universe is such an amazing thing.'
        ELSE `c`.`comment`
    END
WHERE `c`.`id` BETWEEN 1 AND 15;

-- TASK 04. Data Deletion
DELETE FROM `articles` AS `a`
WHERE `a`.`category_id` IS NULL;

-- SECTION 3 QUERYING
-- 05. Extract 3 biggest articles
SELECT `a`.`title`,
	`a`.`summary`
FROM (SELECT `id`,
		`title`,
		CONCAT(SUBSTRING(`content`, 1, 20), '...') AS `summary` 
        FROM `articles`
		ORDER BY LENGTH(`content`) DESC
        LIMIT 3) AS `a`
ORDER BY `a`.`id` ASC;

-- 06. Golden articles
SELECT `a`.`id`,
	`a`.`title`
    FROM `articles` AS `a`
INNER JOIN `users_articles` AS `u_a`
	ON `a`.`id` = `u_a`.`article_id`
WHERE `a`.`id` = `u_a`.`user_id`
ORDER BY `a`.`id`;

-- 07. Extract categories
SELECT `c`.`category`,
	COUNT(`a`.`category_id`) AS `articles`,
	COUNT(`l`.`article_id`) AS `likes`
    FROM `categories` AS `c`
INNER JOIN `articles` AS `a`
	ON `c`.`id` = `a`.`category_id`
INNER JOIN `likes` AS `l`
	ON `a`.`id` = `l`.`article_id`
GROUP BY `c`.`category`
ORDER BY `likes` DESC;

-- 08. Extract the most commented social articla
SELECT `a`.`title`,
	COUNT(`c`.`article_id`) AS `comments`
    FROM `articles` AS `a`
INNER JOIN `comments` AS `c`
	ON `a`.`id` = `c`.`article_id`
WHERE `a`.`category_id` = 5 -- SOCIAL CATEGORY ARTICLES!
GROUP BY `a`.`title`
ORDER BY `comments` DESC
LIMIT 1;

-- 09. Extract the less liked comments
SELECT CONCAT(SUBSTRING(`c`.`comment`, 1, 20), '...') AS `summary`
    FROM `comments` AS `c`
LEFT JOIN `likes` AS `l`
	ON `c`.`id` = `l`.`comment_id`
WHERE `l`.`comment_id` IS NULL
ORDER BY `c`.`id` DESC;

-- 10. Get users articles count
DROP FUNCTION `udf_users_articles_count`;

DELIMITER $$

CREATE FUNCTION udf_users_articles_count(username VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE `written_articles_count` INT;
    
    SET `written_articles_count` = (SELECT COUNT(`u_a`.`article_id`) AS `count`
			FROM `users` AS `u`
		INNER JOIN `users_articles` AS `u_a`
			ON `u`.`id` = `u_a`.`user_id`
		WHERE `u`.`username` = `username`);
            
	RETURN `written_articles_count`;
END $$

DELIMITER ;

SELECT udf_users_articles_count('UnderSinduxrein');


-- 11. Like article
DROP PROCEDURE `udp_like_article`;
DELIMITER $$

CREATE PROCEDURE `udp_like_article`(username VARCHAR(30), title VARCHAR(30))
BEGIN
	START TRANSACTION;
		IF((SELECT `u`.`username` 
				FROM `users` AS `u`
				WHERE `u`.`username` = `username`) is null)
			THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent user.';
            ROLLBACK;
        END IF;
        
        IF((SELECT `a`.`title`
				FROM `articles` AS `a`
				WHERE `a`.`title` = `title`) is null)
			THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent article.';
             ROLLBACK;
		END IF;
        
		INSERT INTO `likes`(`article_id`, `user_id`)
			SELECT (SELECT `id` FROM `articles` AS `a` WHERE `a`.`title` = `title`) AS `article_id`,
				(SELECT `id` FROM `users` AS `u` WHERE `u`.`username` = `username`) AS `user_id`;
				
	COMMIT;
END $$

DELIMITER ;

-- FOR TESTING
CALL udp_like_article('Pesho123', 'Donnybrook, Victoria');
CALL udp_like_article('BlaAntigadsa', 'Donnybrook, Victoria'); 
SELECT a.title, u.username  
FROM articles a  
JOIN likes l 
ON a.id = l.article_id 
JOIN users u 
ON l.user_id = u.id 
WHERE u.username = 'BlaAntigadsa' AND a.title = 'Donnybrook, Victoria';