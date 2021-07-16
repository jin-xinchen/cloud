package com.jin.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date gmt_create;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmt_modified;
}
