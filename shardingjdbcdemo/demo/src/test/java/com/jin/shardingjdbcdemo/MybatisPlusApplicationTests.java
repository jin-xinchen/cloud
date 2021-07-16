package com.jin.shardingjdbcdemo;

import com.jin.shardingjdbcdemo.entity.User;
import com.jin.shardingjdbcdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先设置条件为空，查询所有。
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    // 测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("kwhua_mybatis-plus_insertTest");
        user.setAge(15);
        user.setEmail("310697723@qq.com");

        int result = userMapper.insert(user); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 看到id会自动填充。
    }
    @Test
    public void testUpdate(){
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setId(1416034839333216257L);
        user.setName("MetaObjectHandler-");
        user.setAge(21);
        // 注意：updateById 但是参数是一个对象！
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
}
