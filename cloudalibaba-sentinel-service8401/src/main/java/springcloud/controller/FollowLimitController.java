package springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/testE")
    public String testE(){

        log.info("testE test Exception number");
        int age = 10/0;
        return "------testE Exception number";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value="testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value="p1",required=false) String p1,
                             @RequestParam(value="p2",required=false) String p2  ){
//        int n = 10/0;
        return "------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "------deal_testHotKey blockHandler "+exception.getClass().getCanonicalName() + " invalid.";
    }
    @GetMapping("/followLimit/byUrl")
    @SentinelResource(value="followLimitbyUrl")
    public String byUrl(){
        return "------followLimitbyUrl";
    }
}
