CREATE TABLE EMPLOYEE
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    FIRST_NAME VARCHAR(200) NOT NULL,
    LAST_NAME VARCHAR(200) NOT NULL,
    GENDER VARCHAR(1) NOT NULL,
    DOB DATE NOT NULL,
    SALARY DECIMAL(10,2) NOT NULL,
    NICK_NAME VARCHAR(200) NOT NULL,
    BEING_HIRED BOOLEAN NOT NULL
);