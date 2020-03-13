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
        //JDBCUtils.class��ö���
        //getclassloader()�������
        //getResourceAsStream������Դ�ļ�
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("bd.properties");//ctrl+alt+v;

        //����property���͵Ķ���
        Properties p = new Properties();
        //�������ļ�
        try{
            p.load(resourceAsStream);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");

            //��������
            Class.forName(driver);
            System.out.println("successful");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //������Ӷ���ķ���
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
