DROP DATABASE IF EXISTS testMyBatisPlus;

CREATE DATABASE testMyBatisPlus;

USE testMyBatisPlus;

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
Ref: https://www.cnblogs.com/l-y-h/p/12859477.html
https://baomidou.com/guide/generator.html#%E7%BC%96%E5%86%99%E9%85%8D%E7%BD%AE

# 常用注解
  复制代码

  【@TableName 】
      @TableName               用于定义表名
  注：
      常用属性：
          value                用于定义表名

  【@TableId】
      @TableId                 用于定义表的主键
  注：
      常用属性：
          value           用于定义主键字段名
          type            用于定义主键类型（主键策略 IdType）

     主键策略：
        IdType.AUTO          主键自增，系统分配，不需要手动输入
        IdType.NONE          未设置主键
        IdType.INPUT         需要自己输入 主键值。
        IdType.ASSIGN_ID     系统分配 ID，用于数值型数据（Long，对应 mysql 中 BIGINT 类型）。
        IdType.ASSIGN_UUID   系统分配 UUID，用于字符串型数据（String，对应 mysql 中 varchar(32) 类型）。

  【@TableField】
      @TableField            用于定义表的非主键字段。
  注：
      常用属性：
          value                用于定义非主键字段名
          exist                用于指明是否为数据表的字段， true 表示是，false 为不是。
          fill                 用于指定字段填充策略（FieldFill）。

      字段填充策略：（一般用于填充 创建时间、修改时间等字段）
          FieldFill.DEFAULT         默认不填充
          FieldFill.INSERT          插入时填充
          FieldFill.UPDATE          更新时填充
          FieldFill.INSERT_UPDATE   插入、更新时填充。

  【@TableLogic】
      @TableLogic           用于定义表的字段进行逻辑删除（非物理删除）
  注：
      常用属性：
          value            用于定义未删除时字段的值
          delval           用于定义删除时字段的值

  【@Version】
      @Version             用于字段实现乐观锁

# 代码生成器

  （1）AutoGenerator 简介
  　　AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率。
  　　与 mybatis 中的 mybatis-generator-core 类似。

  （2）添加依赖
  复制代码

  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-generator</artifactId>
      <version>3.3.1.tmp</version>
  </dependency>
  <!-- 添加 模板引擎 依赖 -->
  <dependency>
      <groupId>org.apache.velocity</groupId>
      <artifactId>velocity-engine-core</artifactId>
      <version>2.2</version>
  </dependency>

# issues
## 1 java.lang.Exception: No runnable methods exception in running JUnits
https://stackoverflow.com/questions/24319697/java-lang-exception-no-runnable-methods-exception-in-running-junits
instead of using "import org.junit.Test;", here must be "import org.junit.Test;".
https://baomidou.com/guide/generator.html#%E7%BC%96%E5%86%99%E9%85%8D%E7%BD%AE