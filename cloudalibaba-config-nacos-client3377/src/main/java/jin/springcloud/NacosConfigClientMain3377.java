package jin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
//@EnableDiscoveryClient
public class NacosConfigClientMain3377 {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigClientMain3377.class, args);
        while(true) {
            String userName = applicationContext.getEnvironment().getProperty("config.info");
            //获取当前部署的环境
//            String currentEnv = applicationContext.getEnvironment().getProperty("current.env");
//            System.err.println("in "+currentEnv+" enviroment; "+"user name :" + userName + "; age: " + userAge);
            System.err.println("----->:"+userName);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
