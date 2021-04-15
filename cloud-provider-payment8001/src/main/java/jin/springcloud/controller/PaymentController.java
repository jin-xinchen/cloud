package jin.springcloud.controller;

import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
import jin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping(value="/payment")//http://localhost:8081/payment?serial=test3
    public CommonResult creat(Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果："+ result);
        if(result > 0){
            return new CommonResult(200,"ok",result);
        }else{
            return new CommonResult(444,"error",null);
        }
    }
    @GetMapping(value="/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果"+payment);
        if(payment!=null){
            return new CommonResult(200,"ok",payment);
        }else{
            return new CommonResult(444,"no record by id"+id,null);
        }
    }
}
