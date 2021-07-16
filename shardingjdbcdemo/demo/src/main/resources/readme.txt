1) Database: course_db;
2) 2 tables: course_1 , course_2 in course_db database;
3) The course_1 table includes even number Id;
4) The course_2 table includes odd number Id;
CREATE SCHEMA `course_db` ;
ALTER SCHEMA `course_db`  DEFAULT CHARACTER SET utf8mb4  DEFAULT COLLATE utf8mb4_0900_ai_ci ;

CREATE SCHEMA `course_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;


use course_db;

DROP TABLE IF EXISTS cid;
create table cid
(
  cid BIGINT(20) PRIMARY KEY,
  cname VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS course;
CREATE TABLE course
(
id BIGINT(20) NOT NULL COMMENT '主键ID',   //Here must be "id". Mybatis-plus generates error if column name is "cid".
cname VARCHAR(50) NOT NULL DEFAULT 'name' COMMENT '姓名',
user_id BIGINT(20) NOT NULL DEFAULT 100 COMMENT 'user Id',
cstatus vARCHAR(10) NOT NULL DEFAULT 'status' COMMENT 'status',
PRIMARY KEY (id)
);
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

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
id BIGINT(20) NOT NULL COMMENT '主键ID',
name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
age INT(11) NULL DEFAULT NULL COMMENT '年龄',
email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (id)
);
注意：-- 真实开发中往往都会有这四个字段，version（乐观锁）、deleted（逻辑删除）、gmt_create（创建时间）、gmt_modified（修改时间）
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

######
ALTER TABLE `course_db`.`user`
ADD COLUMN `gmt_create` DATETIME NULL DEFAULT NULL AFTER `email`,
ADD COLUMN `gmt_modified` DATETIME NULL DEFAULT NULL AFTER `gmt_create`;

######

#database
use course_db;
DELETE FROM course_1;

INSERT INTO course_1 (cid, cname, user_id, cstatus) VALUES
(1, 'Jone', 18, 'test1'),
(2, 'Jack', 20, 'test2'),
(3, 'Tom', 28, 'test3'),
(4, 'Sandy', 21, 'test4'),
(5, 'Billie', 24, 'test5');

select * from course_1;


## mysql 8
##https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
###/watch?v=gAEAWFn-RdA&list=PLC_XkuSUhlb9wNrq8MJYPuiFAejZ0tZ55  catong
###/watch?v=-E3-w4NRQ5w&list=PLjbISPgF5zwKkfuxIzXQetJa5Qh7cYmP_&index=9
###/watch?v=tpIctyqH29Q&list=PL8dPuuaLjXtNlUrzyH5r6jN9ulIgZBpdo

spring.shardingsphere.datasource.names=m1
spring.shardingsphere.datasource.m1.type=com.alibaba.druid.pool.DruidDataSource  # 连接池
spring.shardingsphere.datasource.m1.driver-class-name=com.mysql.cj.jdbc.Driver   # mysql8
spring.shardingsphere.datasource.m1.jdbc-url=jdbc:mysql://localhost:3306/course_db?serverTimezone=GMT%2B8 # for MySQL8
                                                                                   serverTimezone=GMT%2B8
https://jp.cybozu.help/general/zh/admin/list_systemadmin/list_localization/timezone.html
Eastern Daylight Time
Time zone in Ottawa, ON (GMT-4)  	America/Halifax

spring:
  datasource:
    url: jdbc:mysql://xxx.xxx.xxx.xxx:3306/seckill?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false


spring.shardingsphere.datasource.m1.username=root
spring.shardingsphere.datasource.m1.password=123456
# 配置真实数据源
spring.shardingsphere.datasource.names=ds0,ds1

# 配置第 1 个数据源
spring.shardingsphere.datasource.ds0.type=com.zaxxer.hikari.HikariDataSource
spring.shardingsphere.datasource.ds0.driver-class-name=com.mysql.jdbc.Driver
spring.shardingsphere.datasource.ds0.jdbc-url=jdbc:mysql://localhost:3306/ds0
spring.shardingsphere.datasource.ds0.username=root
spring.shardingsphere.datasource.ds0.password=

# error handle 一个实体类Course对应两个表course_0和course_1引起的错误，错误描述如下：
Description:
The bean 'dataSource', defined in class path resource [org/apache/shardingsphere/shardingjdbc/spring/boot/SpringBootConfiguration.class], could not be registered. A bean with that name has already been defined in class path resource [com/alibaba/druid/spring/boot/autoconfigure/DruidDataSourceAutoConfigure.class] and overriding is disabled.
Action:
Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true

https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent
