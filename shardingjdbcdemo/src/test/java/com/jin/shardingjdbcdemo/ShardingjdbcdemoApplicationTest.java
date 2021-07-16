package com.jin.shardingjdbcdemo;

import com.jin.shardingjdbcdemo.entity.Course;
import com.jin.shardingjdbcdemo.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcdemoApplicationTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void contextLoads(){

    }
    @Test
    public void addCourse(){
        Course course = new Course();
        course.setCname("java");
        course.setUserId(100L);
        course.setCstatus("Normal");
        courseMapper.insert(course);
    }

}
