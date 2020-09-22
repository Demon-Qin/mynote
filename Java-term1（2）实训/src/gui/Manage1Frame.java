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
import dao.ManageDao;
import dao.UserDao;
import daoimpl.ManageDaoimpl;

import entity.Manage;



public class Manage1Frame extends JFrame implements ActionListener {
	JLabel jId = new JLabel("�˺ţ�");
	JLabel jPassword = new JLabel("���룺");
	
	JTextField jtfId = new JTextField("", 40);
	JTextField jtfPassword = new JPasswordField("", 40);

	JButton jButtonInsert = new JButton("ע��");
	JButton jButtonSearch = new JButton("��¼");
    JButton jButtonDelete = new JButton("ע��");
	public Manage1Frame(String title) {
		super(title);
		Container container = this.getContentPane();

		container.setLayout(null);

		jId.setBounds(10, 20, 40, 30);
		jtfId.setBounds(60, 20, 100, 30);

		jPassword.setBounds(10, 60, 40, 30);
		jtfPassword.setBounds(60, 60, 100, 30);

		jButtonInsert.setBounds(10, 150, 80, 40);
		jButtonDelete.setBounds(100, 150, 80, 40);
		jButtonSearch.setBounds(190, 150, 80, 40);

		container.add(jId);
		container.add(jtfId);

		container.add(jPassword);
		container.add(jtfPassword);

		container.add(jButtonInsert);
		container.add(jButtonDelete);
		container.add(jButtonSearch);
		jButtonInsert.addActionListener(this);
		jButtonDelete.addActionListener(this);
		jButtonSearch.addActionListener(this);

		this.setSize(400, 300);
		this.setLocation(400, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ManageDao dao = new ManageDaoimpl();
		// TODO Auto-generated method stub
		
		if ("ע��".equals(e.getActionCommand())) {

			Manage manage = new Manage();
			manage.setId(jtfId.getText());

			manage.setPassword(jtfPassword.getText());

			int code = dao.add(manage);

			System.out.println("ע��ɹ�");
		} else if ("ע��".equals(e.getActionCommand())) {
            String sql = "delete from manages where id = ?";
            int code = DBUtils.update(sql, jtfId.getName());
		} else if ("��¼".equals(e.getActionCommand())) {

			List<Manage> managelist = null;
			Manage manage = new Manage();
			manage.setId(jtfId.getText());
			manage.setPassword(jtfPassword.getText());
			managelist = dao.getManage(manage);
			if (managelist.size() != 0) {
				new ManageMenu("�������");
				this.setVisible(false);
			}
			else {
				new MistakeFrame("��ʾ");
				this.setVisible(true);
			}

		}
	}

}
