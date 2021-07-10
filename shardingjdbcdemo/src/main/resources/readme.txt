1) Database: course_db;
2) 2 tables: course_1 , course_2 in course_db database;
3) The course_1 table includes even number Id;
4) The course_2 table includes odd number Id;
CREATE SCHEMA `course_db` ;
ALTER SCHEMA `course_db`  DEFAULT CHARACTER SET utf8mb4  DEFAULT COLLATE utf8mb4_0900_ai_ci ;

CREATE SCHEMA `course_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;


use course_db;
CREATE TABLE course_1 (
  cid BIGINT(20) PRIMARY KEY,
  cname VARCHAR(50) NOT NULL,
  user_id BIGINT(20) NOT NULL,
  cstatus vARCHAR(10) NOT NULL
)
CREATE TABLE course_2 (
  cid BIGINT(20) PRIMARY KEY,
  cname VARCHAR(50) NOT NULL,
  user_id BIGINT(20) NOT NULL,
  cstatus vARCHAR(10) NOT NULL
)


