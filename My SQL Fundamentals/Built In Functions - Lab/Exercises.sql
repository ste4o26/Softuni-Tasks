USE `book_library`;

-- 01. Find Book Titles
SELECT `title`
FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id` ASC;

-- 02. Replace Titles
SELECT REPLACE(`title`, 'The', '***')
FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id` ASC;

-- 03. Sum Cost of All Books
SELECT FORMAT(SUM(`cost`), 2) AS `total_cost`
FROM `books`;

-- 04. Days Lived
SELECT CONCAT(`first_name`, ' ', `last_name`) AS `Full Name`,
ABS(DATEDIFF(`born`, `died`)) AS `Days Lived`
FROM `authors`;

-- 05. Harry Potter Books
SELECT `title`
FROM `books`
WHERE LOWER(`title`) LIKE '%harry potter%'
ORDER BY `id` ASC;