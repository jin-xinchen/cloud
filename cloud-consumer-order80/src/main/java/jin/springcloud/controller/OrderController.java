package jin.springcloud.controller;

import jin.springcloud.entities.CommonResult;
import jin.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        String url = getURL_payment();
        return restTemplate.postForObject(url+"/payment",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPaymet(@PathVariable("id") Long id){
        String url = getURL_payment()+"/payment/"+id;
        return restTemplate.getForObject(url,CommonResult.class);
    }

    private String getURL_payment() {
    return PAYMENT_URL;
    }
}
