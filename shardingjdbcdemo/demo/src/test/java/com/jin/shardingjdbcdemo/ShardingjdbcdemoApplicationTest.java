package com.jin.shardingjdbcdemo;

import com.jin.shardingjdbcdemo.entity.Course;
import com.jin.shardingjdbcdemo.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcdemoApplicationTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void contextLoads(){
        List<Course> users = courseMapper.selectList(null);
        users.forEach(System.out::println);
    }
    // 测试插入
    @Test
    public void testInsert(){
        Course course = new Course();
        course.setCname("mybatis-plus_insertTest");
        course.setUserId(15L);
        course.setCstatus("Normal000");

        int result = courseMapper.insert(course); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(course); // 看到id会自动填充。
    }
    @Test
    public void addCourse(){
        Course course = new Course();
        //course.setCid(1L);
        course.setCname("java");
        course.setUserId(100L);
        course.setCstatus("Normal");
        courseMapper.insert(course);
    }

}
