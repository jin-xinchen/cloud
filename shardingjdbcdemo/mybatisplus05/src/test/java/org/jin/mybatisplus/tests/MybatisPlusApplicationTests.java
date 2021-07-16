package org.jin.mybatisplus.tests;

import org.jin.mybatisplus.entity.User;
import org.jin.mybatisplus.mapper.UserMapper;
//import org.junit.jupiter.api.Test;
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
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        for(User user:userList) {
//            System.out.println(user);
//        }
        userList.forEach(System.out::println);
    }
}
