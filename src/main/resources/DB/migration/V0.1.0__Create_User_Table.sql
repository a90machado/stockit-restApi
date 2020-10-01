CREATE TABLE users(
	ID BIGSERIAL PRIMARY KEY,
    FIRST_NAME VARCHAR(28) NOT NULL,
    LAST_NAME VARCHAR(28) NOT NULL,
    EMPLOYEE_NUMBER VARCHAR(28) NOT NULL UNIQUE,
    POSITION VARCHAR(50) NOT NULL,
    LOCALIZATION VARCHAR(30) NOT NULL,
    START_DATE DATE NOT NULL,
    END_DATE DATE,
    PASSWORD VARCHAR(255) NOT NULL
);