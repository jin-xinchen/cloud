package jin.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
/*
-- Under Unix, database names are case-sensitive (unlike SQL keywords).
-- This is also true for table names.
DROP DATABASE IF EXISTS db2021;
-- CREATE DATABASE tweebaadb CHARACTER SET utf8 COLLATE utf8_general_ci;
-- All new databases should use utf8mb4
CREATE DATABASE db2021 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- MySQL 5.7 used a different one - mysql_native_password.
-- CREATE USER 'tweebaa'@'%' IDENTIFIED BY 'Tweebaa123';
-- MySQL 8.0 uses a new default authentication plugin - caching_sha2_password
CREATE USER 'tweebaa'@'%' IDENTIFIED WITH mysql_native_password BY 'Tweebaa123';

GRANT SELECT,INSERT,DELETE,UPDATE ON tweebaadb.* TO 'tweebaa'@'%';

COMMIT;
CREATE TABLE test_payment(
id bigint(20) not null PRIMARY KEY auto_increment,
serial varchar(200) DEFAULT ''
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

*/