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
	
	JMenu userMenu=new JMenu("用户");
	JMenu helpMenu=new JMenu("帮助");
	
	JMenu grMenu=new JMenu("借书信息查询");
	JMenu jsMenu=new JMenu("借/还书");
	
	JMenuItem exitItem=new JMenuItem("退出");
	JMenuItem returnItem =new JMenuItem("返回");
	JMenuItem aboutItem=new JMenuItem("关于系统");
	
	JCheckBoxMenuItem chaItem=new JCheckBoxMenuItem("查询");
		
	JRadioButtonMenuItem jieItem=new JRadioButtonMenuItem("借书");
	JRadioButtonMenuItem huanItem=new JRadioButtonMenuItem("还书");
	JRadioButtonMenuItem cha2Item=new JRadioButtonMenuItem("查询书籍");
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
        //一定要设置成可见的
        this.setVisible(true);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	   BookDao dao= new BookDaoimpl();
	   BorrowDao dao1 = new BorrowDaoimpl();
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		
		if("退出".equals(e.getActionCommand())){
			System.exit(WindowConstants.EXIT_ON_CLOSE);
		}else if("关于系统".equals(e.getActionCommand())){
			
		}else if("返回".equals(e.getActionCommand())){
			new LoginFrame("登录");
			this.setVisible(false);	
		}else if("查询".equals(e.getActionCommand())){
			   List<Borrow> borrowlist = dao1.getById(this.user.getId());	            
	           new U2TableFrame(borrowlist);
	           System.out.println(borrowlist);
			this.setVisible(true);	
		}else if("借书".equals(e.getActionCommand())){
			new User3Frame("借/还书",this.getUser());
			this.setVisible(true);
		}else if("还书".equals(e.getActionCommand())){
			new User3Frame("借/还书",this.getUser());
			this.setVisible(true);
		}else if("查询书籍".equals(e.getActionCommand())){
			new User3Frame("借/还书",this.getUser());
     		this.setVisible(true);
		}	
	}


}
