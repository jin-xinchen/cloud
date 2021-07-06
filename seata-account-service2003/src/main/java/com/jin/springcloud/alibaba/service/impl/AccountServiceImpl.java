package com.jin.springcloud.alibaba.service.impl;

import com.jin.springcloud.alibaba.dao.AccountDao;
import com.jin.springcloud.alibaba.service.AccountService;
import com.jin.springcloud.alibaba.tools.IdGeneratorSnowflake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
//@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------>account service start to decrease account balance");
        //ToDo
        try{
            TimeUnit.SECONDS.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        accountDao.decrease(userId,money);
        LOGGER.info("------>account service end of account balance");
    }

    @Autowired
    private IdGeneratorSnowflake idGenerator;

    @Override
    public String getIDBySnowflake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            threadPool.submit(()->{
                System.out.println(idGenerator.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "snowflake";
    }
}
