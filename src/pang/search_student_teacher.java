package pang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;



public class search_student_teacher {
	private Connection connection;
	private Vector rows;
	private Vector columnNames;
	private boolean flag;
	
	public search_student_teacher() {
		connect_sql utils = new connect_sql();
		connection = utils.connect();
		flag = false;
	}
	
	public Vector getRows(String Sno) throws SQLException {
		String sql = "select distinct teacher.Tname from student,teacher,SC,course WHERE SC.Cno=course.COno and course.Tno=teacher.Tno and student.Sno=SC.Sno and student.Sno=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, Sno);
		ResultSet rSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = rSet.getMetaData();
		rows = new Vector();
		while(rSet.next()) {
			rows.addElement(getNextRow(rSet, metaData));
			flag = true;
		}
		return rows;
	}
	
	
	private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}
	
	public boolean check() {
		return flag;
	}
}
