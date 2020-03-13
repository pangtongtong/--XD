package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils_test {

    public void Jdbcconnection() throws Exception{
        Connection connection = JDBCUtils.getconnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test");
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id"));
        }
    }
}
