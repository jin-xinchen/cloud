package org.jin.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.jin.mybatisplus.mapper")
public class MybatisplusApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplicationMain.class,args);
    }
}
