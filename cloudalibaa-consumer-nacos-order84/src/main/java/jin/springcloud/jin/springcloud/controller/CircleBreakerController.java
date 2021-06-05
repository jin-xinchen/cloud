package jin.springcloud.jin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";
    //                                               nacos-payment-provider
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value="fallback")
//    @SentinelResource(value="fallback",fallback="handlerFallback")
//    @SentinelResource(value="fallback",blockHandler = "blockHandler")
//    @SentinelResource(value="fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
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

}
