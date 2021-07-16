package com.jin.shardingjdbcdemo;

import com.jin.shardingjdbcdemo.entity.Cid;
import com.jin.shardingjdbcdemo.entity.User;
import com.jin.shardingjdbcdemo.mapper.CidMapper;
import com.jin.shardingjdbcdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidTest {
    @Autowired
    private CidMapper cidMapper;
    @Test
    public void contextLoads() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先设置条件为空，查询所有。
        List<Cid> users = cidMapper.selectList(null);
        users.forEach(System.out::println);
    }
    // 测试插入
    @Test
    public void testInsert(){
        Cid cid = new Cid();
        cid.setCname("cid_mybatis-plus_insertTest");

        int result = cidMapper.insert(cid); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(cid); // 看到id会自动填充。
    }
}
