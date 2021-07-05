--mysql数据库的replace into实现的；
-- ：replace into 首先尝试插入数据列表中，如果发现表中已经有此行数据（根据主键和唯一索引判断），则先删除，而后插入，否则直接插入新记录。
create table t_test(
  id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  stub CHAR(1) NOT NULL DEFAULT '',
  UNIQUE KEY stub(stub)
)
select * from t_test;
REPLACE INTO t_test (stub) VALUES ('b');
SELECT LAST_INSERT_ID();
