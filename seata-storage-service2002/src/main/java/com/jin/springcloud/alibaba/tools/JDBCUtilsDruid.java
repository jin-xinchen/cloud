package com.jin.springcloud.alibaba.tools;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsDruid {
    //define DataSource
    private static DataSource ds;
    static{
        try {
            //1.Properties file
            Properties pro = new Properties();
            pro.load(JDBCUtilsDruid.class.getClassLoader().getResourceAsStream("durid.properties"));
            //2.get DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * get Connection
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    /**
     * release resource
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close(); // just go back to pool
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement stmt, Connection conn){
        close(null,stmt,conn);
    }
    /**
     * get Pool
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
