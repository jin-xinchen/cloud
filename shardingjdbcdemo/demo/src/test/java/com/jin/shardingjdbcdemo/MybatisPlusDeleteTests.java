package com.jin.shardingjdbcdemo;

import com.jin.shardingjdbcdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDeleteTests {
    @Autowired
    private UserMapper userMapper;
    // 测试删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1416034839333216257L);
    }
    @Test
    public void testDeleteById02(){
        userMapper.deleteById(1L);
    }
    // 通过id批量删除
    @Test
    public void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(1415874365476171777L,1415887153980346369L));
    }

    // 通过map删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Billie");
        userMapper.deleteByMap(map);
    }
}
