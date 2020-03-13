package pang;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class select_student_ui extends JFrame implements ActionListener{
	private JLabel label;
	private JTextField textField;
	private JButton select_button;
	private JButton back_button;
	private JTable table;
	private JPanel jp1;
	private JScrollPane jsPane;
	private DefaultTableModel defaultTableModel;
	
	public select_student_ui() {
		
		label = new JLabel("请输入要查询的学生学号");
		textField = new JTextField(10);
		select_button = new JButton("查询");
		back_button = new JButton("返回");
		jp1 = new JPanel();
		
		jp1.add(label);
		jp1.add(textField);
		jp1.add(select_button);
		jp1.add(back_button);
		select_button.addActionListener(this);
		back_button.addActionListener(this);
		
		this.setLayout(new BorderLayout());  
        this.setTitle("查询学生信息");  
        this.setSize(700,300);  
        this.setLocation(200, 200);       
        this.add(jp1,BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        this.setVisible(true); 
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==select_button) {
			try {
				select_student selectStuInfo = new select_student();
				Vector rows = selectStuInfo.getRows(textField.getText());
				Vector columnNames = selectStuInfo.getColumnNames(textField.getText());
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入学号","提示",  JOptionPane.ERROR_MESSAGE); 
				}
				else if(!textField.getText().equals("")&&!selectStuInfo.check()) {
					JOptionPane.showMessageDialog(null, "查询无此人", "提示", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!(textField.getText().equals(""))&&selectStuInfo.check()) {
					defaultTableModel = new DefaultTableModel(rows,columnNames);
					table = new JTable(defaultTableModel);
					jsPane = new JScrollPane(table); 
					this.add(jsPane);
					this.setVisible(true);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(event.getSource()==back_button) {
			dispose();
			new UI();
		}
		
	}
}
