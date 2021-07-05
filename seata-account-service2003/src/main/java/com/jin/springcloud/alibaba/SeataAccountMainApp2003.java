package com.jin.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountMainApp2003 {
    public static void main(String[] args){
        //System.out.println(UUID.randomUUID().toString()); // 32
        SpringApplication.run(SeataAccountMainApp2003.class,args);
    }
}
