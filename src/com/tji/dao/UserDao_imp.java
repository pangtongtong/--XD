package com.tji.dao;
import com.tji.bean.User;
import test.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao_imp implements UserDao{
    public int login(User user){
        try{
            Connection connection = JDBCUtils.getconnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select type from user where uname = 'admin'");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("type"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    //增加学生的方法
    //user 包含要添加的对象和账号密码
    public boolean insert(User user){
        return false;
    }

    //删除学生的方法
    //
    public boolean delete(String uname ){
        return false;
    }
    //修改信息
    public boolean update(User user){
        return false;
    }

    //查询学生信息的方法
    public User select(String uname){
        return new User();
    }
}
