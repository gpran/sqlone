CREATE DATABASE IF NOT EXISTS studentdb;
SHOW DATABASES;
DROP DATABASE IF EXISTS studentdb;
SHOW DATABASES;

CREATE DATABASE IF NOT EXISTS studentdb;
SHOW DATABASES;
USE studentdb;

CREATE TABLE IF NOT EXISTS tbl_student_list (
    student_id INT AUTO_INCREMENT,
    student_name VARCHAR(255) NOT NULL,
    student_age INT NOT NULL,
    student_standard INT NOT NULL,
    student_section VARCHAR(255) NOT NULL,
    student_registration_date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    PRIMARY KEY (student_id)
)  ENGINE=INNODB;


ALTER TABLE `tbl_student_list` MODIFY `student_registration_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

