package pang;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class insert_student_ui extends JFrame implements ActionListener{
	
	private JButton insert_button;
	private JButton back_button;
	private JPanel jp1;
	
	private DefaultTableModel defaultTableModel;
	private JTable table;
	private JScrollPane sPane;
	
	public insert_student_ui() {
		insert_button = new JButton("插入");
		back_button = new JButton("返回");
		String [] columnNames = {"学号","班号","姓名","年龄","性别"};
		String [][] rows = {{"","","","",""}};
		table = new JTable(rows,columnNames);
		sPane = new JScrollPane(table);
		jp1 = new JPanel();
		
		insert_button.addActionListener(this);
		back_button.addActionListener(this);
		jp1.add(insert_button);
		jp1.add(back_button);
		
		this.setLayout(new BorderLayout());
		this.setTitle("插入学生信息");
		this.setSize(600, 400);
		this.setLocation(200, 300);
		this.add(jp1,BorderLayout.WEST);
		this.add(sPane);
		this.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==insert_button) {
			String [] row = new String[5];
			for(int i=0;i<5;i++) {
				row[i] = (String) table.getValueAt(table.getSelectedRow(),i);
			}
			try {
				insert_student.insert(row[0], row[1], row[2],Integer.parseInt(row[3]), row[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "插入失败，该数据可能已在数据库中", "警告", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			}
		else if(event.getSource()==back_button) {
			dispose();
			new UI();
		}
	}

}
