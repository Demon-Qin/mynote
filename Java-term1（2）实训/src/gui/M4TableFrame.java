package gui;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import entity.User;


public class M4TableFrame extends JFrame{
	     public M4TableFrame(List<User> list) {
	    	  Vector<Vector<Object>> vectordate = new Vector<>();
	  		for (User user : list) {
	  			Vector<Object> objs = new Vector<>();
	  			objs.add(new Integer(user.getId()));
	  			objs.add(user.getName());
	  			objs.add(new Integer(user.getBooknum()));
	  			objs.add(user.getBookstate());
	  			
	  			
	  			vectordate.add(objs);
	  		}
	  		String[] labels = { "卡号", "持卡人姓名", "书本数", "书本状态" };
	  		Vector<String> columNames = new Vector<>();
	  		for (String label : labels) {
	  			columNames.add(label);
	  		}

	  		JTable table = new JTable(vectordate, columNames);

	  		JScrollPane scrollPane = new JScrollPane(table);
	  		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	  		JPanel panel = new JPanel();

	  		panel.setLayout(null);
	  		panel.setBorder(new TitledBorder(null, "总面板", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	  		this.getContentPane().add(panel);
	  		panel.add(scrollPane);
	  		scrollPane.setBounds(15, 15, 300, 200);
	  		scrollPane.setBorder(new TitledBorder(null, "用户管理面板", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	  		this.setSize(420, 300);
	  		this.setLocationRelativeTo(null);
	  		this.setVisible(true);
	  	}

	}

