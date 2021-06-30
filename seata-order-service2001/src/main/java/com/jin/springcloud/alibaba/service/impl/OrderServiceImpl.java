package com.jin.springcloud.alibaba.service.impl;

import com.jin.springcloud.alibaba.dao.OrderDao;
import com.jin.springcloud.alibaba.domain.Order;
import com.jin.springcloud.alibaba.service.AccountService;
import com.jin.springcloud.alibaba.service.OrderService;
import com.jin.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * Create Order , decrease storage and account, update status of order.
     * @param order
     */
    @Override
    //@GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        //1
        log.info("------>start to create order");
        orderDao.create(order);
        //2
        log.info("------>start of invoke storage");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->end of storage decrease");
        //3
        log.info("------>start of invoke account decrease");
        accountService.decrease(order.getUserId(),order.getMoney());
        //4
        log.info("----->update status of the order");
        orderDao.update(order.getUserId(),0);

        log.info("------>end of creating order");
    }
}
