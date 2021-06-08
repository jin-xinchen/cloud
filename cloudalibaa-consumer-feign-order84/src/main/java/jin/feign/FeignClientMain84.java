package jin.feign;

import jin.feign.controller.ITestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class
FeignClientMain84 {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientMain84.class,args);
    }
}
