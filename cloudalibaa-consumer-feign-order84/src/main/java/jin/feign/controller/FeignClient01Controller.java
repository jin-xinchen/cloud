package jin.feign.controller;

import jin.feign.feign.FeignClient01;
import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignClient01Controller {
    @Autowired
    FeignClient01 feignClient01;
    @GetMapping(value="/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        //========= Does not work, Error is here.
        return feignClient01.paymentSQL(id);
    }
//    @Autowired
//    ITestController client;

}
