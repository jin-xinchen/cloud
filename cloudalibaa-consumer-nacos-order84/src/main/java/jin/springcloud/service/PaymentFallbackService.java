package jin.springcloud.service;

import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

//========= Does not work
//@Component
//public class PaymentFallbackService implements PaymentService{
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id){
        return new CommonResult<>(44444,"服务降级返回，--PaymentFallbackService"
        ,new Payment(id,"error serial"));
    }

//    @Override
//    public CommonResult<Payment> paymentSQL(Long id) {
//        return null;
//    }
}
