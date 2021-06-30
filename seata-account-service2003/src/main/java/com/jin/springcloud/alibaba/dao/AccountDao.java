package com.jin.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    // decrease balance of account
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
