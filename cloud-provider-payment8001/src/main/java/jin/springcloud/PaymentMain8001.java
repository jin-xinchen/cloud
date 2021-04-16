package jin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain8001.class, args);
        System.out.printf("\033[1;31;40m 【%s】 \033[0m","PaymentMain8001 Start ...");
        System.out.printf("\033[2;32;40m text \033[0m  \n");
        //Colors for text are represented by color codes, including, reset = 0, black = 30, red = 31, green = 32, yellow = 33, blue = 34, magenta = 35, cyan = 36, and white = 37.
        //https://www.oreilly.com/library/view/linux-shell-scripting/9781785881985/b0ddd805-aa79-441d-b5a7-380c66c7712d.xhtml
    }
}
