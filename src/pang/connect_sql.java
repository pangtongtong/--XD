package pang;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect_sql {
	private static  String url_connect;
	private static  String user;
	private static  String password;
	
	public connect_sql() {
		this.url_connect = "jdbc:sqlserver://127.0.0.1:1433;databaseName=pang";
		this.user = "sa";
		this.password = "1998117bai";
	}
	public connect_sql(String user,String password) {
		this.url_connect = "jdbc:sqlserver://127.0.0.1:1433;databaseName=pang";
		this.user = user;
		this.password = password;
	}
	
	public Connection connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(this.url_connect,this.user,this.password);
			System.out.println("���ݿ����ӳɹ�");
			return con;
		}
		catch(Exception e) {
			System.out.println("���ݿ�����ʧ��\n" + e.toString());
			return null;
		}
	}
}
