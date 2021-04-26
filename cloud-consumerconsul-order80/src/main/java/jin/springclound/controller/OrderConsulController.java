package jin.springclound.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class OrderConsulController {

    public static final String INVOKE_URL="http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value="/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
    // provider
//    @Value("${server.port}")
//    private String serverPort;
//    @RequestMapping(value="/payment/consul")
//    public String paymentConsul(){
//        return "Cloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
//    }
}
