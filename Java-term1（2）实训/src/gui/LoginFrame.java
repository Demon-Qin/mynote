package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
	
	public class LoginFrame extends JFrame implements ActionListener{
		JButton jButtonUser = new JButton("用户登录");
		JButton jButtonManage = new JButton("管理员登录");
		
		public LoginFrame(String title) {
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
		this.setLocation(400, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		if("管理员登录".equals(e.getActionCommand())) {
			new Manage1Frame(getTitle());
			 }
		if("用户登录".equals(e.getActionCommand())) {
			new User1Frame(getTitle());
		}
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new LoginFrame("登录");

		}
		
	}
