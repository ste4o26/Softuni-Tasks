DROP DATABASE IF EXISTS gamebar;
CREATE DATABASE gamebar;

USE gamebar;

CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(45),
last_name VARCHAR(45)
);

INSERT INTO employees(first_name, last_name) VALUES ('Ste4o', 'Nepoklatimov');
INSERT INTO employees(first_name, last_name) VALUES ('Slavi', 'Trevozavisimov');
INSERT INTO employees(first_name, last_name) VALUES ('Mistin', 'Lyskobastunov');

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(45) NOT NULL
);

INSERT INTO categories(name) VALUES ('ZARIBEN KOMPIUTARDJIQ');
INSERT INTO categories(name) VALUES ('NARKOZAVISIM KOMPIUTARDJIQ');
INSERT INTO categories(name) VALUES ('ZAGORQL KOMPIUTARDJIQ');

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(45) NOT NULL,
category_id INT 
);

INSERT INTO products(name, category_id) VALUES('laptop', 26);
INSERT INTO products(name, category_id) VALUES('masur', 15);
INSERT INTO products(name, category_id) VALUES('toaletna hartiq', 1);

ALTER TABLE employees
ADD middle_name VARCHAR(45);

ALTER TABLE products
ADD CONSTRAINT category_id 
FOREIGN KEY (category_id) 
REFERENCES categories(id);

ALTER TABLE employees
MODIFY COLUMN middle_name VARCHAR(100);