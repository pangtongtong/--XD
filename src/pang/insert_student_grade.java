package pang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insert_student_grade {
	public static boolean insert(String Sno,String Cno,int grade) throws SQLException {
		connect_sql dbUtils = new connect_sql();
		Connection connection = dbUtils.connect();
		
		String sql = "" + "insert into SC values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, Sno);
		preparedStatement.setString(2, Cno);
		preparedStatement.setInt(3, grade);
		
		return preparedStatement.execute();
		
	}
}
