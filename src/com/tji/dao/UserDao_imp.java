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

    //����ѧ���ķ���
    //user ����Ҫ��ӵĶ�����˺�����
    public boolean insert(User user){
        return false;
    }

    //ɾ��ѧ���ķ���
    //
    public boolean delete(String uname ){
        return false;
    }
    //�޸���Ϣ
    public boolean update(User user){
        return false;
    }

    //��ѯѧ����Ϣ�ķ���
    public User select(String uname){
        return new User();
    }
}
