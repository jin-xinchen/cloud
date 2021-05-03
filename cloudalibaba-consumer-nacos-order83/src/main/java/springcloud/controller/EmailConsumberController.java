package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class EmailConsumberController {
    @Value("${service-url.nacos-user-service}")
    private String INVOKE_URL;
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value="/consumer/email/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        String result = restTemplate.getForObject(INVOKE_URL+"/email/nacos/"+id,String.class);
        return result;
    }
}