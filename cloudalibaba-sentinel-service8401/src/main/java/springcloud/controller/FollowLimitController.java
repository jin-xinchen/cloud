package springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FollowLimitController {
    @GetMapping("/testA")
    public String testA(){
        try{
            TimeUnit.MILLISECONDS.sleep(800);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "-----testA";
    }
    @GetMapping("/testB")
    public  String testB(){
        return "-----testB";
    }
}
