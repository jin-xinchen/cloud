package com.jin.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    DB2KeyGenerator
    H2KeyGenerator
    KingbaseKeyGenerator
    OracleKeyGenerator
    PostgreKeyGenerator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@KeySequence(value = "SEQ_ORACLE_STRING_KEY", clazz = String.class)
//@KeySequence(value = "PostgreKeyGenerator")
public class Cid {
//    @TableId(type = IdType.AUTO)
    //@TableId(value = "ID_STR", type = IdType.INPUT)
    @TableId( type = IdType.INPUT)
    private Long cid;
    private String cname;
}
