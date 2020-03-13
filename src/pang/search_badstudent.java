package pang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


public class search_badstudent {
	private Connection connection;
	private Vector rows;
	private Vector columnNames;
	private boolean flag;
	
	public search_badstudent() {
		connect_sql utils = new connect_sql();
		connection = utils.connect();
		flag = false;
	}
	
	public Vector getRows() throws SQLException {
		String sql = "select distinct student.Sno,student.Sname\r\n" + 
				"from student,SC,MCC,course\r\n" + 
				"where student.Sno=SC.Sno and SC.Cno=MCC.COno and SC.Cno=course.COno and MCC.xingzhi='必修' and SC.grade<60 \r\n" + 
				"group by student.Sno,student.Sname\r\n" + 
				"having sum(course.COgrade)<15";
		String sql1 = "select distinct student.Sno,student.Sname\r\n" + 
				"from student,SC,MCC,course\r\n" + 
				"where student.Sno=SC.Sno and SC.Cno=MCC.COno and SC.Cno=course.COno and MCC.xingzhi='选修' and SC.grade<60 \r\n" + 
				"group by student.Sno,student.Sname\r\n" + 
				"having sum(course.COgrade)<20";
		Statement statement = connection.createStatement();
		Statement statement1 = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		ResultSet resultSet1 = statement1.executeQuery(sql1);
		ResultSetMetaData metaData = resultSet.getMetaData();
		ResultSetMetaData metaData1 = resultSet1.getMetaData();
		
		rows = new Vector();
		while(resultSet.next()) {
			rows.addElement(getNextRow(resultSet, metaData));
			flag = true;
		}
		while(resultSet1.next()) {
			rows.addElement(getNextRow(resultSet1,metaData1));
			flag = true;
		}
		
		//去重
		Set set = new HashSet(rows);
		Vector res = new Vector(set);
		return res;
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
