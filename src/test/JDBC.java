package test;

import java.sql.*;

public class JDBC {
    public static void main(String[] args){
        try{
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("successful");

            //连接数据库,获得连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
            System.out.println("连接成功");

            //创建执行环境
            Statement statement = conn.createStatement();

            //执行SQL语句
            ResultSet result = statement.executeQuery("select * from a");
            while(result.next()){
                System.out.println(result.getInt("id")+ " ");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("wrong");
            System.out.println("连接失败");
        }catch (SQLException S){
            S.printStackTrace();
        }

    }
}
