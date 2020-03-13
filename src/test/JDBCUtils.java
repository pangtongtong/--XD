package test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static{
        //JDBCUtils.class获得对象
        //getclassloader()类加载器
        //getResourceAsStream加载资源文件
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("bd.properties");//ctrl+alt+v;

        //创建property类型的对象
        Properties p = new Properties();
        //加载流文件
        try{
            p.load(resourceAsStream);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");

            //加载驱动
            Class.forName(driver);
            System.out.println("successful");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获得链接对象的方法
    public static Connection getconnection(){
        try{
            System.out.println("successful");
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("wrong");
        }
        return null;
    }

    public static void close(Connection connection, Statement statement, ResultSet result){
        try{
            if (result!=null){
                result.close();
                result = null;
            }
            if (statement!=null){
                statement.close();
                statement = null;
            }
            if (connection!=null){
                connection.close();
                connection = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
