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

public class search_student_course_ui extends JFrame implements  ActionListener{
	private JLabel label;
	private JTextField textField;
	private JButton select_button;
	private JButton back_button;
	private JTable table;
	private JPanel jp1;
	private JScrollPane jsPane;
	private DefaultTableModel defaultTableModel;
	
	public search_student_course_ui() {
		
		label = new JLabel("������Ҫ��ѯ��ѧ��ѧ��");
		textField = new JTextField(10);
		select_button = new JButton("��ѯ");
		back_button = new JButton("����");
		jp1 = new JPanel();
		
		jp1.add(label);
		jp1.add(textField);
		jp1.add(select_button);
		jp1.add(back_button);
		select_button.addActionListener(this);
		back_button.addActionListener(this);
		
		this.setLayout(new BorderLayout());  
        this.setTitle("��ѯѧ��ѡ����Ϣ");  
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
				search_student_course search_student_course = new search_student_course();
				Vector rows = search_student_course.getRows(textField.getText());
				Vector columnNames = search_student_course.getColumnNames(textField.getText());
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "������ѧ��","��ʾ",  JOptionPane.ERROR_MESSAGE); 
				}
				else if(!textField.getText().equals("")&&!search_student_course.check()) {
					JOptionPane.showMessageDialog(null, "��ѯ�޴���ѡ�μ�¼", "��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!(textField.getText().equals(""))&&search_student_course.check()) {
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
