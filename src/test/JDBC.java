package test;

import java.sql.*;

public class JDBC {
    public static void main(String[] args){
        try{
            //��������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("successful");

            //�������ݿ�,������Ӷ���
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
            System.out.println("���ӳɹ�");

            //����ִ�л���
            Statement statement = conn.createStatement();

            //ִ��SQL���
            ResultSet result = statement.executeQuery("select * from a");
            while(result.next()){
                System.out.println(result.getInt("id")+ " ");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("wrong");
            System.out.println("����ʧ��");
        }catch (SQLException S){
            S.printStackTrace();
        }

    }
}
