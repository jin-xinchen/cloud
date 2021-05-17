package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
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
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "-----testB";
    }
    @GetMapping("/testD")
    public String testD(){
        //try{TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
        //log.info("testD test RT");
        log.info("testD 异常比例");
        int age = 10/0;
        return "------testD";
    }
}
