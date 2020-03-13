package pang;

import java.awt.BorderLayout;
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
import javax.swing.table.TableModel;

public class search_student_grade_ui extends JFrame implements ActionListener{
	private JButton select_button;
	private JPanel jPanel;
	private JTextField textField;
	private JLabel jLabel;
	private JTable jTable;
	private JScrollPane jScrollPane;
	private JButton back_button;
	
	public search_student_grade_ui() {
		
		select_button = new JButton("查询");
		back_button = new JButton("返回");
		textField = new JTextField(10);
		jLabel = new JLabel("请输入学生学号");
		jPanel = new JPanel();
		jPanel.add(jLabel);
		jPanel.add(textField);
		jPanel.add(select_button);
		jPanel.add(back_button);
		select_button.addActionListener(this);
		back_button.addActionListener(this);
		
		this.setTitle("查询学生成绩");
		this.setLayout(new BorderLayout());
		this.setSize(700,300);  
	    this.setLocation(200, 200);       
		this.add(jPanel,BorderLayout.NORTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getSource()==select_button) {
			try {
				search_student_grade searchgrade = new search_student_grade();
				Vector rows = searchgrade.getRows(textField.getText());
				Vector columnNames = searchgrade.getColumnNames(textField.getText());
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入学号","提示",  JOptionPane.ERROR_MESSAGE); 
				}
				else if(!textField.getText().equals("")&&!searchgrade.check()) {
					JOptionPane.showMessageDialog(null, "查询无此人", "提示", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!(textField.getText().equals(""))&&searchgrade.check()) {
					TableModel defaultTableModel = new DefaultTableModel(rows,columnNames);
					jTable = new JTable(defaultTableModel);
					jScrollPane = new JScrollPane(jTable); 
					this.add(jScrollPane);
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
