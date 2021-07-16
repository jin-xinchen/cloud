package com.jin.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

// 代码自动生成器
public class generateCode {
    public void generatorCodes() {
        // Step1：代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // Step2：全局配置。指定代码输出路径，以及包名、作者等信息。
        GlobalConfig gc = new GlobalConfig();
// 填写代码生成的目录(需要修改)
        String projectPath = "d:\\myProject\\test\\test_mybatis_plus";
// 拼接出代码最终输出的目录
        gc.setOutputDir(projectPath + "/src/main/java");
// 配置开发者信息（可选）（需要修改）
        gc.setAuthor("test");
// 配置是否打开目录，false 为不打开（可选）
        gc.setOpen(false);
// 实体属性 Swagger2 注解，添加 Swagger 依赖，开启 Swagger2 模式（可选）
//gc.setSwagger2(true);
// 重新生成文件时是否覆盖，false 表示不覆盖（可选）
        gc.setFileOverride(false);
// 配置主键生成策略，此处为 ASSIGN_ID（可选）
       // gc.setIdType(IdType.ASSIGN_ID);
        gc.setIdType(IdType.ID_WORKER);
// 配置日期类型，此处为 ONLY_DATE（可选）
        gc.setDateType(DateType.ONLY_DATE);
// 默认生成的 service 会有 I 前缀
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // Step3：数据源配置（需要修改）配置数据源信息。用于指定 需要生成代码的 数据仓库、数据表。
        //setUrl、setDriverName、setUsername、setPassword 均需修改。
        DataSourceConfig dsc = new DataSourceConfig();
// 配置数据库 url 地址
        dsc.setUrl("jdbc:mysql://localhost:3306/testMyBatisPlus?useUnicode=true&characterEncoding=utf8&serverTimezone=America/Halifax");
// dsc.setSchemaName("testMyBatisPlus"); // 可以直接在 url 中指定数据库名
// 配置数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
// 配置数据库连接用户名
        dsc.setUsername("root");
// 配置数据库连接密码
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // Step:4：配置包信息。setParent、setModuleName 均需修改。其余按需求修改.
        PackageConfig pc = new PackageConfig();
// 配置父包名（需要修改）
        pc.setParent("com.test");
// 配置模块名（需要修改）
        pc.setModuleName("test_mybatis_plus");
// 配置 entity 包名
        pc.setEntity("entity");
// 配置 mapper 包名
        pc.setMapper("mapper");
// 配置 service 包名
        pc.setService("service");
// 配置 controller 包名
        pc.setController("controller");
        mpg.setPackageInfo(pc);

// Step5：策略配置（数据库表配置）
        //配置数据表映射信息。setInclude 需要修改，其余按实际开发修改。
        StrategyConfig strategy = new StrategyConfig();
// 指定表名（可以同时操作多个表，使用 , 隔开）（需要修改）
        strategy.setInclude("user");
// 配置数据表与实体类名之间映射的策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
// 配置数据表的字段与实体类的属性名之间映射的策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
// 配置 lombok 模式
        strategy.setEntityLombokModel(true);
// 配置 rest 风格的控制器（@RestController）
        strategy.setRestControllerStyle(true);
// 配置驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
// 配置表前缀，生成实体时去除表前缀
// 此处的表名为 test_mybatis_plus_user，模块名为 test_mybatis_plus，去除前缀后剩下为 user。
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // Step6：执行代码生成操作
        mpg.execute();
    }

    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src001/main/java");
        gc.setAuthor("test");//作者名称
        gc.setOpen(false);
        gc.setFileOverride(false); // 是否覆盖
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);//实体属性 Swagger2 注解
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setServiceName("%sService");
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");

        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        //dsc.setUrl("jdbc:mysql://localhost:3306/mybatisplus_test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        //America/Halifax
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatisplus_test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=America/Halifax");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // dsc.setDriverName("com.mysql.jdbc.Driver"); //mysql5.6以下的驱动
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.test"); //包名
        pc.setModuleName("model"); //模块名
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setInclude("user","course"); // 设置要映射的表名
        strategy.setInclude("user");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok；
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        //根据你的表名来建对应的类名，如果你的表名没有下划线，比如test，那么你就可以取消这一步
        //strategy.setTablePrefix("t_");
        strategy.setRestControllerStyle(true); //rest请求
        //自动转下划线，比如localhost:8080/hello_id_2
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }
}
