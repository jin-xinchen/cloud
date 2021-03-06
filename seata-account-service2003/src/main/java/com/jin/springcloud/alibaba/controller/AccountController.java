package com.jin.springcloud.alibaba.controller;

import com.jin.springcloud.alibaba.domain.CommonResult;
import com.jin.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @GetMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"account decrease successfully");
    }
    @RequestMapping("/snowflake")
    public String snowflake(){
        return accountService.getIDBySnowflake();
    }
}
