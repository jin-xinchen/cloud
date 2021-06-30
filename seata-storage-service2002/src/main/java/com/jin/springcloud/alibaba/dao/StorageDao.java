package com.jin.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    // decrease storage
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
