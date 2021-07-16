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
    // 测试乐观锁，Optimistic Concurrency Control，缩写“OCC”
    @Test
    public void testOptimisticLocker(){
        // 1、查询用户信息
        User user = userMapper.selectById(1L);
        // 2、修改用户信息
        user.setName("version");
        user.setEmail("123456@gmail.com");
        // 3、执行更新操作
        userMapper.updateById(user);
    }
    // 测试乐观锁失败！多线程下
    @Test
    public void testOptimisticLocker2(){

        // 线程 1
        User user = userMapper.selectById(1L);
        user.setAge(user.getAge()+1);
        user.setName("version01");
        user.setEmail("version01@gmail.com");

        // 模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setAge(user2.getAge()+1);
        user2.setName("version02");
        user2.setEmail("version02@gmail.com");
        userMapper.updateById(user2);

        // 自旋锁来多次尝试提交！
        userMapper.updateById(user); // 如果没有乐观锁就会覆盖插队线程的值！
    }
}
