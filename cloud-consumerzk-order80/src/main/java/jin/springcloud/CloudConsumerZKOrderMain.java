package jin.springcloud;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerZKOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerZKOrderMain.class,args);
    }
}
