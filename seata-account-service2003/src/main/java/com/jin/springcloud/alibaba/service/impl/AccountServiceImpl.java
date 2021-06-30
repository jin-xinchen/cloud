package com.jin.springcloud.alibaba.service.impl;

import com.jin.springcloud.alibaba.dao.AccountDao;
import com.jin.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
//@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------>account service start to decrease account balance");
        accountDao.decrease(userId,money);
        LOGGER.info("------>account service end of account balance");
    }
}