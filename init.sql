CREATE DATABASE IF NOT EXISTS todo;

USE todo;

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    status ENUM('TODO', 'WIP', 'DONE') DEFAULT 'TODO',
    start_date DATE NOT NULL,
    target_date DATE NOT NULL
);