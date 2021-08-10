package com.Test.apicustomeradmin.service.impl;

import com.Test.apicustomeradmin.controller.PageCustomers;
import com.Test.apicustomeradmin.entity.UserA;
import com.Test.apicustomeradmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public void setEnv(Environment pEnv){
        env = pEnv;
    }
    private Environment env;
    @Override
    public PageCustomers receiveUsersJDBC(int currPage, int pageSize) {
        int pagesize =pageSize;
        int pageNow = currPage;
        PageCustomers pageCustomers = new PageCustomers();
        pageCustomers.setCurrPage(pageNow);
        pageCustomers.setPageSize(pagesize);
//        UserA user1 = new UserA(1920024L, "2c99bb0a-b0ce-4057-9ef7-bbe415e1e1bc",
//                "tw1626604807000", "tw1626604807000",
//                "v2vdl1",
//                "avatarUrl");
//        users.add(user1);
        Connection Conn=null;
        try{

            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String conn="jdbc:sqlserver://localhost:1433;DatabaseName=TestSNAP";
            String username="Test_dev";
            String passW="%gM$VISyPjwhx%tMD2";
            String keyValue = env.getProperty("mssql.datasource.driver-class-name");
            if( keyValue!= null && !keyValue.isEmpty())
            {
                driver = keyValue;
            }
            keyValue = env.getProperty("mssql.datasource.url");
            if( keyValue!= null && !keyValue.isEmpty())
            {
                conn = keyValue;
            }
            username = env.getProperty("mssql.datasource.username");
            passW =  env.getProperty("mssql.datasource.password");
            Conn= DriverManager.getConnection(conn,username,passW);
            Statement stmt=Conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql1 = "select count(c.Id) from Customer as c inner join Store as s on s.Id = c.Store_Id and s.OwnerId = c.Id left join Download as d on d.id = c.ThumbnailAvatarDownloadId where CountryCallingCode is not null and PhoneNumber is not null and c.Deleted != 1";
            Conn.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stmt.executeQuery(sql1);
            if(rs.first()){
                int count = rs.getInt(1);
                pageCustomers.setTotalCount(count);
                //way 1
                int t = (count-1)/pageCustomers.getPageSize()+1;
                pageCustomers.setTotalPage(t);
                //way 2
//                double dl =(double) count/pageCustomers.getPageSize();
//                pageCustomers.setTotalPage((int) Math.ceil(dl));
            }
            rs.close();
            List<UserA> users = new ArrayList<UserA>();
            int pageIndex = pageNow+1;
            String sql = "select c.Id,ROW_NUMBER() over(order by c.CreatedOnUtc desc) as rn from Customer as c inner join Store as s on s.Id=c.Store_Id and s.OwnerId=c.Id left join Download as d on d.id = c.ThumbnailAvatarDownloadId where CountryCallingCode is not null and PhoneNumber is not null and c.Deleted != 1";
            String query = "select * from ("+sql+") p where rn>"+(pageIndex-1)*pagesize +" and rn<="+pageIndex*pagesize;
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                UserA userA = new UserA();
                userA.setUserId(rs.getLong("Id"));
                users.add(userA);
            }
            pageCustomers.setList(users);
            rs.close();
            stmt.close();
            Conn.close();
        }
        catch(Exception e){
            //e.printStackTrace();
        }
        finally {
            if(Conn!=null){
                try {
                    Conn.close();
                } catch (SQLException throwables) {
                    //throwables.printStackTrace();
                }
            }
        }
        return pageCustomers;
    }
}