package jin.springcloud.jin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {

    //public static final String SERVICE_URL = "http://nacos-payment-provider";
    //                                               nacos-payment-provider
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value="fallback")
//    @SentinelResource(value="fallback",fallback="handlerFallback")     //fallback is only java running exceptions.
//    @SentinelResource(value="fallback",blockHandler = "blockHandler")  //blockHandler is only Sentinel Rules.
//    @SentinelResource(value="fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    @SentinelResource(value="fallback",fallback = "handlerFallback",blockHandler = "blockHandler"
                      ,exceptionsToIgnore = {IllegalArgumentException.class}) // fallback does not handle IllegalArgumentException Exception.
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+
                "/paymentSQL/"+id,CommonResult.class,id);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException,...");
        }else if(result.getData()==null){
            throw new NullPointerException("NullPointerException...");
        }
        return result;
    }
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"程序运行异常处理handlerFallback,exception:"+e.getMessage(),payment);
    }
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockE){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"Sentinel，触发熔断限流，异常处理blockHandler,,exception:"+blockE.getMessage(),payment);
    }

}
