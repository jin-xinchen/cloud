package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value="/email/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id){
        return "nacos registry, serverPort: " + serverPort+"\t id: "+id;
    }
}