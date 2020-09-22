package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.DBUtils;

import dao.UserDao;
import daoimpl.UserDaoimpl;
import entity.Manage;
import entity.User;


public class User1Frame extends JFrame implements ActionListener{
	
	JLabel jId=new JLabel("���ţ�");
	JLabel jName= new JLabel("������");
	
	
	
	
	JTextField jtfId=new JTextField("",70);
	JTextField jtfName=new JTextField("",70);
	
	JButton jButtonInsert=new JButton("ע��");
	JButton jButtonLoad=new JButton("��¼");
	
	
	public User1Frame(String title) {
	
		super("�û���¼");
		Container con=this.getContentPane();
		con.setLayout(null);
		
		jId.setBounds(10,20,60,30);
		jtfId.setBounds(60,20,140,30);
		
		jName.setBounds(10,60,60,30);
		jtfName.setBounds(60,60,140,30);
		
		
		jButtonInsert.setBounds(10,150,70,30);
		jButtonLoad.setBounds(130,150,70,30);
		
		con.add(jId);
		con.add(jtfId);
		con.add(jName);
		con.add(jtfName);
		con.add(jButtonInsert);
		con.add(jButtonLoad);
		jButtonInsert.addActionListener(this);
		jButtonLoad.addActionListener(this);
		
		this.setSize(300, 300);	
		this.setLocation(420, 250);
		this.setVisible(true);	
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		UserDao dao = new UserDaoimpl();
		// TODO Auto-generated method stub
		
		if ("ע��".equals(e.getActionCommand())) {

			User user = new User();
			user.setId(jtfId.getText());

			user.setName(jtfName.getText());
			user.setBookstate("δ��");
			user.setDeposit(100.0);
			user.setBooknum(0);			
			int code = dao.add(user);

			System.out.println("ע��ɹ�");
		} else if ("ע��".equals(e.getActionCommand())) {
            String sql = "delete from people where id = ?";
            int code = DBUtils.update(sql, jtfId.getName());
		} else if ("��¼".equals(e.getActionCommand())) {


			List<User> userlist = null;
			User user = new User();
			user.setId(jtfId.getText());
			user.setName(jtfName.getText());
			userlist = dao.getUser(user);
			String ID = jtfId.getText();
			if (userlist.size() != 0) {
				new UserMenu("ѧ���û��˵�",userlist.get(0));
				this.setVisible(false);
			}else {
				new MistakeFrame("��ʾ");
				this.setVisible(true); 
			}

		}
	}

	
	
}
