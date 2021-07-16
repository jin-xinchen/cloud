package com.jin.shardingjdbcdemo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.shardingjdbcdemo.entity.User;
import com.jin.shardingjdbcdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisSearchTest {
    @Autowired
    private UserMapper userMapper;
    // 测试查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    // 测试批量查询！
    @Test
    public void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 按条件查询之一使用map操作
    @Test
    public void testSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        // 自定义要查询
        map.put("name","%");
        map.put("age",19);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    // 测试分页查询
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<User> page = new Page<>(1,8);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }
    @Test
    public void searchWhere() {
        // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于28
        //SELECT id,name,age,email,gmt_create AS gmt_create,gmt_modified AS gmt_modified,version,deleted FROM user
        // WHERE deleted=0 AND name IS NOT NULL AND email IS NOT NULL AND age >= ?
        // WHERE
        //        deleted=0
        //        AND name IS NOT NULL
        //        AND email IS NOT NULL
        //        AND age >= ?
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name") //不为空
                .isNotNull("email")
                .ge("age",28);
        userMapper.selectList(wrapper).forEach(System.out::println); // 和我们刚才学习的map对比一下
    }
    @Test
    public void test2(){
        // 查询名字kwhua
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Tom");
        User user = userMapper.selectOne(wrapper); // 查询一个数据用selectOne，查询多个结果使用List 或者 Map
        System.out.println(user);
    }
}
