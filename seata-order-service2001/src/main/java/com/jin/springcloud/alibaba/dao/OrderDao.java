package com.jin.springcloud.alibaba.dao;

import com.jin.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void create(Order order);
    // modify Order status
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
