package com.jin.springcloud.alibaba.controller;

import com.jin.springcloud.alibaba.domain.CommonResult;
import com.jin.springcloud.alibaba.domain.Order;
import com.jin.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"created an order");
    }
}
