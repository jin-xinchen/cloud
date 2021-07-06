package com.jin.springcloud.alibaba.service;

import com.jin.springcloud.alibaba.tools.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {


    /**
     * decrease balance of Account
     * @param userId
     * @param money
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);


    String getIDBySnowflake();
}
