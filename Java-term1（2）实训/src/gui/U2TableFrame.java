package gui;


import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import entity.Borrow;
public class U2TableFrame extends JFrame{
	public U2TableFrame(List<Borrow> list) {
  	  Vector<Vector<Object>> vectordate = new Vector<>();
		for (Borrow borrow : list) {
			Vector<Object> objs = new Vector<>();
			objs.add(borrow.getId());
			objs.add(borrow.getBookid());
			objs.add(borrow.getBookname()); 
			objs.add(borrow.getBookdate());
			
			
			vectordate.add(objs);
		}
		String[] labels = {"����", "�鱾���", "����", "�鱾����" };
		Vector<String> columNames = new Vector<>();
		for (String label : labels) {
			columNames.add(label);
		}

		JTable table = new JTable(vectordate, columNames);

		JScrollPane scrollPane = new JScrollPane(table);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "�����", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.getContentPane().add(panel);
		panel.add(scrollPane);
		scrollPane.setBounds(15, 15, 300, 200);
		scrollPane.setBorder(new TitledBorder(null, "���Ľ���", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setSize(420, 300);
		this.setLocationRelativeTo(null);
		this.setLocation(880, 150);
		this.setVisible(true);
	}

	private String getID() {
		// TODO Auto-generated method stub
		return null;
	}

}