package pang;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.xml.transform.*;


public class UI extends JFrame implements ActionListener{
	
	private JButton insert_student_button;              //添加学生按钮
	private JButton select_student_button;              //查询学生按钮
	private JButton insert_student_grade_button;        //插入学生成绩
	private JButton search_student_course_button;       //查询学生课程
	private JButton search_student_grade_button;        //查询学生成绩
	private JButton search_student_teacher_button;      //查询学生代课教师
	private JButton search_badstudent_button;           //查询快被开除学生
	private JButton select_studentname_button;
	private JButton select_sdept_button;
	private JPanel jp1,jp2,jp3,jp4,jp5;
	
	public UI() {
		insert_student_button = new JButton("添加学生信息");
		select_student_button = new JButton("按学号查询学生信息");
		select_studentname_button = new JButton("按姓名查询学生信息");
		select_sdept_button = new JButton("按系别查询学生信息");
		insert_student_grade_button = new JButton("插入学生成绩");
		search_student_course_button = new JButton("查询学生课程");
		search_student_grade_button = new JButton("查询学生成绩");
		search_student_teacher_button = new JButton("查询学生代课老师");
		search_badstudent_button = new JButton("查询快被开除学生");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();	
		jp4 = new JPanel();	
		jp5 = new JPanel();	
		
		jp1.add(insert_student_button);
		jp2.add(select_student_button);
		jp2.add(select_studentname_button);
		jp2.add(select_sdept_button);
		jp3.add(insert_student_grade_button);
		jp4.add(search_student_course_button);
		jp5.add(search_student_grade_button);
		jp5.add(search_student_teacher_button);
		jp5.add(search_badstudent_button);
		
		//把JPanel加入到JFrame
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.EAST);
		this.add(jp4,BorderLayout.WEST);
		this.add(jp5,BorderLayout.SOUTH);
		
		//设置窗口属性
		this.setSize(500,230);
		this.setLocation(700,500);
		this.setTitle("学籍管理系统"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setVisible(true);
		
		insert_student_button.addActionListener(this);
		select_student_button.addActionListener(this);
		select_studentname_button.addActionListener(this);
		select_sdept_button.addActionListener(this);
		insert_student_grade_button.addActionListener(this);
		search_student_course_button.addActionListener(this);
		search_student_grade_button.addActionListener(this);
		search_student_teacher_button.addActionListener(this);
		search_badstudent_button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source==insert_student_button) {
			dispose();
			new insert_student_ui();
		}
		else if(source==select_student_button) {
			dispose();
			new select_student_ui();
		}
		else if(source == select_studentname_button) {
			dispose();
			new SelectStuInfoNameUI();
		}
		else if(source == select_sdept_button) {
			dispose();
			new SelectStuInfoSdeptUI();
		}
		else if(source == insert_student_grade_button) {
			dispose();
			new insert_student_grade_ui();
		}
		else if(source == search_student_course_button) {
			dispose();
			new search_student_course_ui();
		}
		else if(source == search_student_grade_button) {
			dispose();
			new search_student_grade_ui();
		}
		else if(source == search_student_teacher_button) {
			dispose();
			new search_student_teacher_ui();
		}
		else if(source == search_badstudent_button){
			dispose();
			new search_badstudent_ui();
		}
	}

	public static void main(String[] args) {
		UI appui = new UI();
	}
	
}

/*    Connection connection;
static {
try {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    System.out.println("数据库加载成功！");
} catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}

Connection getConn(){
String url="jdbc:sqlserver://localhost:1434;DatabaseName=Class";
String userName="sa";
String passWord="123456";
try {
    connection=DriverManager.getConnection(url,userName,passWord);
    if (connection!=null) {
        System.out.println("链接成功！");
    }
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
return connection;
}
public static void main(String[] args) {
UI test=new UI();
Connection con=test.getConn();
try {
    System.out.println(con.getCatalog());
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}
*/