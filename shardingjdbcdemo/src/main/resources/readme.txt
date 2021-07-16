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


