package pang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class search_student_course {
	private Connection connection;
	private Vector rows;
	private Vector columnNames;
	private boolean flag;
	public search_student_course() {
		connect_sql utils = new connect_sql();
		connection = utils.connect();
		flag = true;
	}
	
	public Vector getRows(String Sno) throws SQLException {
		String sql = ("select Sno,COno,COname,COgrade,grade from SC,course where course.COno=SC.Cno and SC.Sno=?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, Sno);
		ResultSet resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		
		rows = new Vector();
		while(resultSet.next()) {
			rows.addElement(getNextRow(resultSet, metaData));
			flag = false;
		}
		return rows;
	}
	
	public Vector getColumnNames(String Sno) throws SQLException{
		String sql = ("select Sno,COno,COname,COgrade,grade from SC,course where course.COno=SC.Cno and SC.Sno=?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, Sno);
		ResultSet resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		flag = resultSet.next();
		columnNames = new Vector();
		for(int i=1;i<=metaData.getColumnCount();i++) {
			columnNames.addElement(metaData.getColumnName(i));
		}
		return columnNames;
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
