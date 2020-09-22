package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.UserDao;
import daoimpl.UserDaoimpl;
import entity.User;

public class Manage3Frame extends JFrame implements ActionListener {

	
	JLabel jId=new JLabel("�û����ţ�");
	JTextField jtfId=new JTextField("",70);

	
	JButton jButtonInsert=new JButton("ɾ��");
	JButton jButtonLoad=new JButton("��ѯ");
	
	
	public Manage3Frame(String title) {
		
		super("�û�����");
		Container con=this.getContentPane();
		con.setLayout(null);
		
		jId.setBounds(10,20,80,30);
		jtfId.setBounds(70,20,140,30);
		
		
		jButtonInsert.setBounds(10,150,70,30);
		jButtonLoad.setBounds(130,150,70,30);
		
		
		con.add(jId);
		con.add(jtfId);
		
		con.add(jButtonInsert);
		con.add(jButtonLoad);
		
		
		jButtonInsert.addActionListener(this);
		jButtonLoad.addActionListener(this);
		
		this.setSize(300, 300);		
		this.setLocation(380, 350);
		this.setVisible(true);	
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDaoimpl();
		if("ɾ��".equals(e.getActionCommand())){
        	User user = new User();
            user.setId(jtfId.getText());
            int code=dao.delete(user);
            System.out.println("��ɾ���û�"+user.getName());

        } else if ("��ѯ".equals(e.getActionCommand())) {
           List<User> userlist = null ;
           userlist = dao.getById(jtfId.getText());
           new M3TableFrame(userlist);
           System.out.println(userlist);
        }
		
	}
}