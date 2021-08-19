package com.jin.springcloud.alibaba.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt=null;
        try {
            //1.
            conn = JDBCUtilsDruid.getConnection();
            //2.
            String sql = "insert into account values(null,?,?)";
            //3.
            pstmt= conn.prepareStatement(sql);
            //4.
            pstmt.setString(1,"Jack王");
            pstmt.setDouble(2,3000);
            //5
            int count=pstmt.executeUpdate();
//            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtilsDruid.close(pstmt,conn);
        }
    }
}
