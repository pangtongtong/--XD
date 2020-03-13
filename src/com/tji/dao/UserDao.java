package com.tji.dao;
import com.tji.bean.User;

public interface UserDao {
    //登录结果：-1代表失败，1代表管理员成功，2代表学生成功
    int login(User user);

    //增加学生的方法
    //user 包含要添加的对象和账号密码
    boolean insert(User user);

    //删除学生的方法
    //
    boolean delete(String uname );
    //修改信息
    boolean update(User user);

    //查询学生信息的方法
    User select(String uname);
}
