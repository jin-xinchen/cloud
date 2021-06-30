package com.jin.springcloud.alibaba.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.jin.springcloud.alibaba.dao"})
@Slf4j
public class MyBatisConfig {
//    @Profile("dev")
//    @Bean
//    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
//        return new PerformanceMonitorInterceptor();
//    }

    /**
     * MP 自带分页插件
     *
     * @return
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setCountSqlParser(new JsqlParserCountOptimize(true));
//
//        return page;
//    }
    /**
     * @param sqlSessionFactory SqlSessionFactory
     * @return SqlSessionTemplate
     */
//    @Autowired(required = true)
//    private DataSourceProperties dataSourceProperties;
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

    /**
     * 从配置文件获取属性构造datasource，注意前缀，这里用的是druid，根据自己情况配置,
     * 原生datasource前缀取"spring.datasource"
     *
     * @return
     */
//    @Bean(name = "datasource")
//    @Primary
//    public DataSourceProxy druidDataSource() {
//
//        DruidDataSource druidDataSource = new DruidDataSource();
//        log.info("dataSourceProperties.getUrl():{}", dataSourceProperties);
//        druidDataSource.setUrl(dataSourceProperties.getUrl());
//        druidDataSource.setUsername(dataSourceProperties.getUsername());
//        druidDataSource.setPassword(dataSourceProperties.getPassword());
//        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
//        druidDataSource.setInitialSize(1);
//        druidDataSource.setMaxActive(120);
//        druidDataSource.setMaxWait(60000);
//        druidDataSource.setMinIdle(1);
//        druidDataSource.setValidationQuery("Select 1 from DUAL");
//        druidDataSource.setTestOnBorrow(false);
//        druidDataSource.setTestOnReturn(false);
//        druidDataSource.setTestWhileIdle(true);
//        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
//        druidDataSource.setMinEvictableIdleTimeMillis(25200000);
//        druidDataSource.setRemoveAbandoned(true);
//        druidDataSource.setRemoveAbandonedTimeout(1800);
//        druidDataSource.setLogAbandoned(true);
//        log.info("装载dataSource........");
//        return new DataSourceProxy(druidDataSource);
//    }


//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
////         DataSource dataSourceProxy = new DataSourceProxy(druidDataSource);
//
//        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
//        bean.setDataSource(dataSourceProxy);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        // bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
//        bean.setMapperLocations(resolver.getResources("classpath*:/com.mycompany.alicloudapp.mapper/**/*.xml"));
//        SqlSessionFactory factory = null;
//        try {
//            factory = bean.getObject();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return factory;
//    }

}
