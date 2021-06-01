package springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
//import jin.springcloud.entities.CommonResult;
//import jin.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entities.CommonResult;
import springcloud.entities.Payment;
import springcloud.myhandler.CustomerBlockHandler;

@RestController
public class RateLimitController {
//    @GetMapping("/byResource")
//    @SentinelResource(value="byResource",blockHandler = "handleException")
//    public CommonResult byResource(){
//        return new CommonResult(200,"按资源名限流测试OK", new Payment(2020L,"serial001"));
//    }
//    public CommonResult handleException(BlockException exception){
//        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
//    }

    @GetMapping("/byResource")
    @SentinelResource(value="byResource",blockHandler = "handleException")
    public String byResource(){
        return new String("按资源名限流测试OK");
    }
    public String handleException(BlockException exception){
        return new String(exception.getClass().getCanonicalName()+"\t 服务不可用");
    }
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value="byUrl")
    public String byUrl(){
        return "------byUrl";
    }

    //CustomerBlockHandler
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value="customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult CustomerBlockHandler(){
        return new CommonResult(200,"客户自定义",new Payment(2020L,"serial003"));
    }

}
