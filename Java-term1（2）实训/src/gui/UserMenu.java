package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import dao.BookDao;
import dao.BorrowDao;
import dao.UserDao;
import daoimpl.BookDaoimpl;
import daoimpl.BorrowDaoimpl;
import daoimpl.UserDaoimpl;
import entity.Book;
import entity.Borrow;
import entity.User;
import gui.U2TableFrame;



public class UserMenu extends JFrame implements ActionListener{
	
	JTextArea txtDemo=new JTextArea("",10,30);
	JMenuBar jmb=new JMenuBar();
	
	JMenu userMenu=new JMenu("�û�");
	JMenu helpMenu=new JMenu("����");
	
	JMenu grMenu=new JMenu("������Ϣ��ѯ");
	JMenu jsMenu=new JMenu("��/����");
	
	JMenuItem exitItem=new JMenuItem("�˳�");
	JMenuItem returnItem =new JMenuItem("����");
	JMenuItem aboutItem=new JMenuItem("����ϵͳ");
	
	JCheckBoxMenuItem chaItem=new JCheckBoxMenuItem("��ѯ");
		
	JRadioButtonMenuItem jieItem=new JRadioButtonMenuItem("����");
	JRadioButtonMenuItem huanItem=new JRadioButtonMenuItem("����");
	JRadioButtonMenuItem cha2Item=new JRadioButtonMenuItem("��ѯ�鼮");
	private User user;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserMenu(String title,User user){
		
		super(title);
		this.user=user;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container=this.getContentPane();
        
        container.add(new Label(""), BorderLayout.NORTH);
        
        container.add(txtDemo, BorderLayout.CENTER);
        
        this.setJMenuBar(jmb);
        jmb.add(userMenu);
        jmb.add(helpMenu);
        
        userMenu.add(grMenu);
        userMenu.add(jsMenu);
        
        helpMenu.add(exitItem);
        helpMenu.add(returnItem);
        helpMenu.add(aboutItem);
        
        grMenu.add(chaItem);

     
       
 
        
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(jieItem);
        bg1.add(huanItem);
        bg1.add(cha2Item);
        
        jsMenu.add(jieItem);
        jsMenu.add(huanItem);
        jsMenu.add(cha2Item);
        
        
        exitItem.addActionListener(this);
        returnItem.addActionListener(this);
        chaItem.addActionListener(this);
        jieItem.addActionListener(this);
        huanItem.addActionListener(this);
        cha2Item.addActionListener(this);


        this.pack();
        this.setLocation(380, 150);
        this.setSize(500,500);
        //һ��Ҫ���óɿɼ���
        this.setVisible(true);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	   BookDao dao= new BookDaoimpl();
	   BorrowDao dao1 = new BorrowDaoimpl();
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		
		if("�˳�".equals(e.getActionCommand())){
			System.exit(WindowConstants.EXIT_ON_CLOSE);
		}else if("����ϵͳ".equals(e.getActionCommand())){
			
		}else if("����".equals(e.getActionCommand())){
			new LoginFrame("��¼");
			this.setVisible(false);	
		}else if("��ѯ".equals(e.getActionCommand())){
			   List<Borrow> borrowlist = dao1.getById(this.user.getId());	            
	           new U2TableFrame(borrowlist);
	           System.out.println(borrowlist);
			this.setVisible(true);	
		}else if("����".equals(e.getActionCommand())){
			new User3Frame("��/����",this.getUser());
			this.setVisible(true);
		}else if("����".equals(e.getActionCommand())){
			new User3Frame("��/����",this.getUser());
			this.setVisible(true);
		}else if("��ѯ�鼮".equals(e.getActionCommand())){
			new User3Frame("��/����",this.getUser());
     		this.setVisible(true);
		}	
	}


}
