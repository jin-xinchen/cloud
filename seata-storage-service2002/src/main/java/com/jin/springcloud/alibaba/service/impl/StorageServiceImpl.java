package com.jin.springcloud.alibaba.service.impl;

import com.jin.springcloud.alibaba.dao.StorageDao;
import com.jin.springcloud.alibaba.service.StorageService;
//import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//@Slf4j
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Resource
    private StorageDao storageDao;

    /**
     * decrease Storage
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------>storage-service start to decrease;");
        storageDao.decrease(productId,count);
        LOGGER.info("------>storage-service end of decrease;");
    }
}
