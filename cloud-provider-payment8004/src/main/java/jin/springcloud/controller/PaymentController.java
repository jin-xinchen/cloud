package jin.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class PaymentController {
    @Resource
//    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value="/payment/zk")
    public String paymentzk(){

        return "ok, serverPort:"+serverPort+"\t"+ UUID.randomUUID().toString();

    }
//    @GetMapping(value="/payment/discovery")
//    public Object discovery(){
//        List<String> services = discoveryClient.getServices();
//        for(String e:services)
//        {
//            log.info("******element:"+e);
//        }
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        for(ServiceInstance i: instances){
//            log.info(i.getServiceId()+"\t"+i.getHost()+"\t"+i.getPort()+"\t"+i.getUri());
//        }
////        var a = new Object(services,instances);
//        return this.discoveryClient;
//    }
}
