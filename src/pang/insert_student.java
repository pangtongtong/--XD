package pang;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class insert_student {
	public static boolean insert(String Sno,String Cno,String Sname,int Sage,String Ssex)throws Exception{
		connect_sql dbUtils = new connect_sql();
		Connection connection = dbUtils.connect();
		
		String sql = "INSERT INTO student values (?,?,?,?,?)";
		//‘§±‡“Î”Ôæ‰
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, Sno);
		preparedStatement.setString(2, Sname);
		preparedStatement.setString(3, Ssex);
		preparedStatement.setInt(4, Sage);
		preparedStatement.setString(5, Ssex);
		if(preparedStatement.execute()) {
			return true;
		}
		return false;
		
	}
}
