package jin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class, args);
        System.out.printf("\033[1;31;40m 【%s】 \033[0m","OrderMain80 Start ...");
    }
}
