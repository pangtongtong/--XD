package pang;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class search_badstudent_ui extends JFrame implements  ActionListener{
	private JButton select_button;
	private JPanel jPanel;
	private JTable jTable;
	private JScrollPane jScrollPane;
	private JButton back_button;
	
	public search_badstudent_ui() {
		
		select_button = new JButton("��ѯ��Ҫ��������ѧ��");
		back_button = new JButton("����");
		jPanel = new JPanel();
		jPanel.add(select_button);
		jPanel.add(back_button);
		select_button.addActionListener(this);
		back_button.addActionListener(this);
		
		this.setTitle("��ѯ��Ҫ��������ѧ��");
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
				search_badstudent selectBadStu = new search_badstudent();
				Vector rows =  selectBadStu.getRows();
				Vector columnNames = new Vector<>();
				columnNames.addElement("ѧ��");
				columnNames.addElement("����");
				if(!selectBadStu.check()) {
					JOptionPane.showMessageDialog(null, "��ѯ�޴��˻��߸���δ��������Ե", "��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				else {
					jTable = new JTable(rows,columnNames);
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
