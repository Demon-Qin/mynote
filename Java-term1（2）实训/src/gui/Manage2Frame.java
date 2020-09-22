package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import gui.Manage2Frame;

public class Manage2Frame extends JFrame implements ActionListener{
	JButton jButtonUser = new JButton("用户管理");
	JButton jButtonManage = new JButton("图书管理");
	
	public Manage2Frame(String title) {
		super(title);
		Container container = this.getContentPane();

		container.setLayout(null);

	jButtonUser.setBounds(30, 60, 100, 30);
	jButtonManage.setBounds(150, 60, 100, 30);
	
	container.add(jButtonUser);
	container.add(jButtonManage);
	
	jButtonUser.addActionListener(this);
	jButtonManage.addActionListener(this);

	this.setSize(300, 220);
	this.setVisible(true);
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if("用户管理".equals(e.getActionCommand())) {
		new Manage3Frame(getTitle());
		 }
	if("图书管理".equals(e.getActionCommand())) {
		new Manage5Frame(getTitle());
	}
	}
	
	
	
}
