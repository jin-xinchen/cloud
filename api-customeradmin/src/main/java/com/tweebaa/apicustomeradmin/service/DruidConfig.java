package com.tweebaa.apicustomeradmin.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description: Druid的配置文件  https://zhuanlan.zhihu.com/p/139354663
 * @version: v1.0.0
 * @author: fulsun
 * @createDate 2020/4/29 19:27
 * @updateUser
 * @updateDate
 */
@Configuration
public class DruidConfig {
    /**
     *spring:
     *   datasource:
     * #   数据源基本配置
     *     username: root
     *     password: 123456
     *     url: jdbc:mysql://192.168.61.45:3306/springbootStudy?characterEncoding=utf-8
     *     driver-class-name: com.mysql.cj.jdbc.Driver
     *     type: com.alibaba.druid.pool.DruidDataSource
     * #   数据源其他配置
     *     #初始化时建立物理连接的个数
     *     initial-size: 5
     *     #最小连接池数量
     *     min-idle: 5
     *     #最大连接池数量 maxIdle已经不再使用
     *     max-active: 20
     *     #获取连接时最大等待时间，单位毫秒
     *     max-wait: 60000
     *     #申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     *     test-while-idle: true
     *     #既作为检测的间隔时间又作为testWhileIdel执行的依据
     *     time-between-eviction-runs-millis: 60000
     *     #销毁线程时检测当前连接的最后活动时间和当前时间差大于该值时，关闭当前连接
     *     min-evictable-idle-time-millis: 30000
     *     #用来检测连接是否有效的sql 必须是一个查询语句
     *     #mysql中为 select 'x'
     *     #oracle中为 select 1 from dual
     *     validation-query: select 'x'
     *     #申请连接时会执行validationQuery检测连接是否有效,开启会降低性能,默认为true
     *     test-on-borrow: false
     *     #归还连接时会执行validationQuery检测连接是否有效,开启会降低性能,默认为true
     *     test-on-return: false
     *     # 是否缓存preparedStatement
     *     pool-prepared-statements: true
     * #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
     *     #配置监拉统计挡成的filters. stat: 监控统计、Log4j:日志记录、waLL: 防御sqL注入
     *     #如果启用日志记录时报错java.lang.ClassNotFoundException: org.apache.log4j.Priority
     *     #则导入Log4j 依赖即时，Maven 地址: https://mvnrepository. com/artifact/log4j/log4
     *     filters: stat,wall,1og4j
     *     max-pool-prepared-statement-per-connection-size: 20
     *     use-global-data-source-stat: true
     *     connect-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
     * @return
     */
    //@Bean
    //@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
    /**
     * 配置监控服务器
     * @return 返回监控注册的servlet对象
     * @author SimpleWu
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //ServletRegistrationBean reg = new ServletRegistrationBean();
        //reg.setServlet(new StatViewServlet());
        //reg.addUrlMappings("/druid/*");
        // 添加IP白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
        //servletRegistrationBean.addInitParameter("deny", "127.0.0.1");
        // 添加控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }
    /**
     * 配置服务过滤器
     *
     * @return 返回过滤器配置对象
     */
    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤格式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
        return filterRegistrationBean;
    }
}
