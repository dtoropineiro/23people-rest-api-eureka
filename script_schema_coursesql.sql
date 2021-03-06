SET GLOBAL sql_mode='';

CREATE SCHEMA COURSES_DB;

DROP TABLE STUDENT;
DROP TABLE COURSE;
CREATE TABLE IF NOT EXISTS `COURSE`(ID INT, NAME VARCHAR(50),
PRIMARY KEY(ID));

CREATE TABLE IF NOT EXISTS `STUDENT`(ID INT, COURSEID INT, NAME VARCHAR(50),
 AGE INT, GENDER VARCHAR(1), PRIMARY KEY(ID), FOREIGN KEY (COURSEID) REFERENCES COURSE(ID));


ALTER TABLE COURSE MODIFY NAME VARCHAR(50) NOT NULL;
ALTER TABLE COURSE MODIFY ID INT AUTO_INCREMENT NOT NULL;
ALTER TABLE STUDENT MODIFY ID INT AUTO_INCREMENT  NOT NULL;
ALTER TABLE STUDENT ADD RUT VARCHAR(10) NOT NULL UNIQUE;
INSERT INTO `COURSE` (NAME) VALUES('ethics');
INSERT INTO `STUDENT` (ID, NAME, AGE, GENDER, COURSEID) VALUES(1,'pepito', 18, 'M', 2);
INSERT INTO `STUDENT` (ID, NAME, AGE, GENDER, COURSEID) VALUES(2,'maura', 21, 'F', 2);
INSERT INTO `STUDENT` (ID, NAME, AGE, GENDER, COURSEID) VALUES(3,'claudio', 24, 'M', 2);
INSERT INTO `STUDENT` (ID, NAME, AGE, GENDER, COURSEID) VALUES(4,'pepa', 20, 'F', 3);
SELECT * FROM `COURSE`;
SELECT * FROM `STUDENT`;
SELECT * FROM HIBERNATE_SEQUENCE;
SELECT * FROM COURSE_STUDENTS;
