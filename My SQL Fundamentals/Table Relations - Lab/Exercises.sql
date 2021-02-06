USE `camp`;

-- 1.  Mountains and Peaks && 4. Delete Mountains 
DROP TABLE `mountains`;
CREATE TABLE `mountains`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR (25) NOT NULL
);

DROP TABLE `peaks`;
CREATE TABLE `peaks`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(25) NOT NULL,
    `mountain_id` INT,
    CONSTRAINT `fk_mountains_peaks`
	FOREIGN KEY (`mountain_id`)
	REFERENCES `mountains`(`id`)
	ON DELETE CASCADE
);


-- 2. Trip Organization
SELECT `driver_id`,
`vehicle_type`,
CONCAT(`first_name`, ' ', `last_name`) AS `driver_name`
FROM `vehicles` AS `v`
INNER JOIN `campers` AS `c`
ON `v`.`driver_id` = `c`.`id`;

-- 3. SoftUni Hiking
SELECT `starting_point` AS `route_starting_point `,
`end_point` AS `route_ending_point`,
`leader_id`, 
CONCAT(`first_name`, ' ', `last_name`) AS `leader_name`
FROM `routes` AS `r`
INNER JOIN `campers` AS `c`
ON `r`.`leader_id` = `c`.`id`;

-- 5.  Project Management DB*
CREATE TABLE `clients`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `client_name` VARCHAR(100) NOT NULL
);

CREATE TABLE `projects`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`client_id` INT,
    `project_lead_id` INT,
    CONSTRAINT `fk_projects_clients`
    FOREIGN KEY (`client_id`)
    REFERENCES `clients`(`id`)
    ON DELETE CASCADE
);

CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `project_id` INT,
    CONSTRAINT `fk_employees_projects`
    FOREIGN KEY (`project_id`)
    REFERENCES `projects`(`id`)
    ON DELETE CASCADE
);