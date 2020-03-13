package pang;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class insert_student_grade_ui extends JFrame implements ActionListener{
	private JButton insert_button;
	private JButton back_button;
	private JTable table;
	private JScrollPane jsp1;;
	private JPanel jp1;
	
	public insert_student_grade_ui() {
		
		insert_button = new JButton("插入");
		back_button = new JButton("返回");
		
		String [] columnNames = {"学号","课程号","成绩"};
		String [][] rows = {{"","",""}};
		table = new JTable(rows,columnNames);
		jsp1 = new JScrollPane(table);
		jp1 = new JPanel();
		
		insert_button.addActionListener(this);
		back_button.addActionListener(this);
		jp1.add(insert_button);
		jp1.add(back_button);
		
		this.setLayout(new BorderLayout());
		this.setTitle("录入成绩");
		this.setSize(600, 400);
		this.setLocation(200, 300);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jsp1);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==insert_button) {
			String [] row = new String[3];
			for(int i=0;i<3;i++) {
				row[i] = table.getValueAt(table.getSelectedRow(),i).toString();
				System.out.println(row[i]);
			}
			
			try {
					
				insert_student_grade.insert(row[0], row[1], Integer.parseInt(row[2]));
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
