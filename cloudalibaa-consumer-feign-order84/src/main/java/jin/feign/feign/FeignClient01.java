package jin.feign.feign;

import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value="nacos-payment-provider")
public interface FeignClient01 {
    //    @GetMapping(value = "/paymentSQL/{id}")
    @RequestMapping(value="/paymentSQL/{id}",method= RequestMethod.GET)
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
