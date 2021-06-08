package jin.springcloud.service;

import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
//import importorg.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//========= Does not work
//@FeignClient(value="nacos-payment-provider",fallback=PaymentFallbackService.class,fallbackFactory = PaymentFallbackService.class)
//@FeignClient("nacos-payment-provider")
//@FeignClient(name = "nacos-payment-provider",fallback=PaymentFallbackService.class)
public interface PaymentService {
//    @GetMapping(value = "/paymentSQL/{id}")
    @RequestMapping(value="/paymentSQL/{id}",method= RequestMethod.GET)
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
