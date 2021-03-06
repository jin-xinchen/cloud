package com.jin.springcloud.alibaba.controller;

import com.jin.springcloud.alibaba.dao.StorageDao;
import com.jin.springcloud.alibaba.domain.CommonResult;
import com.jin.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"decrease storage capacity successfully");
    }
}
