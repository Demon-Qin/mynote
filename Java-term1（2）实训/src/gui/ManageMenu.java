package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import dao.BookDao;
import daoimpl.BookDaoimpl;


public class ManageMenu extends JFrame implements ActionListener{
	
	JTextArea txtDemo=new JTextArea("",10,30);
	JMenuBar jmb=new JMenuBar();
	
	JMenu managerMenu=new JMenu("管理员");
	JMenu helpMenu=new JMenu("帮助");
	
	JMenu uxMenu=new JMenu("用户信息管理");
	JMenu bxMenu=new JMenu("图书信息管理");
	
	JMenuItem exitItem=new JMenuItem("退出");
	JMenuItem returnItem =new JMenuItem("返回");
	JMenuItem aboutItem=new JMenuItem("关于系统");
	
	JCheckBoxMenuItem chaItem=new JCheckBoxMenuItem("删除");
	JCheckBoxMenuItem cha1Item=new JCheckBoxMenuItem("查询信息");
		
	JRadioButtonMenuItem insertItem=new JRadioButtonMenuItem("新增图书");
	JRadioButtonMenuItem deleteItem=new JRadioButtonMenuItem("删除图书");
	JRadioButtonMenuItem seachItem=new JRadioButtonMenuItem("查询图书");
	
	
	public ManageMenu(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container=this.getContentPane();
        
        container.add(new Label(""), BorderLayout.NORTH);
        
        container.add(txtDemo, BorderLayout.CENTER);
        
        this.setJMenuBar(jmb);
        jmb.add(managerMenu);
        jmb.add(helpMenu);
        
        managerMenu.setMnemonic(KeyEvent.VK_F);
        
        managerMenu.add(uxMenu);
        managerMenu.add(bxMenu);
        helpMenu.add(exitItem);
        helpMenu.add(returnItem);
        helpMenu.add(aboutItem);
        uxMenu.add(cha1Item);
        uxMenu.add(chaItem);
     
        ButtonGroup bg=new ButtonGroup();
        bg.add(insertItem);
        bg.add(deleteItem);
        bg.add(seachItem);
        
        bxMenu.add(insertItem);
        bxMenu.add(deleteItem);
        bxMenu.add(seachItem);
        
        exitItem.addActionListener(this);
        returnItem.addActionListener(this);
        insertItem.addActionListener(this);
        deleteItem.addActionListener(this);
        seachItem.addActionListener(this);
        chaItem.addActionListener(this);
        cha1Item.addActionListener(this);


        this.pack();
        this.setSize(500,400);
        this.setLocation(380, 150);
        //一定要设置成可见的
        this.setVisible(true);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*BookDao bk = new BookDaoimpl();
		// TODO Auto-generated method stub
		int selection = JOptionPane.showConfirmDialog(this,
				"是否退出? ","退出提示",JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE) ;
				if (selection == JOptionPane.OK_OPTION) {
				System. exit(0);
				}
		System.out.println(e.getActionCommand());*/
		
		if("退出".equals(e.getActionCommand())){
			System.exit(WindowConstants.EXIT_ON_CLOSE);
		}else if("关于系统".equals(e.getActionCommand())){
		}else if("返回".equals(e.getActionCommand())){
			new LoginFrame("登录");
			this.setVisible(false);	
		}else if("新增图书".equals(e.getActionCommand())){
			new Manage5Frame("图书管理");
			this.setVisible(true);
		}else if("删除图书".equals(e.getActionCommand())){
			new Manage5Frame("图书管理");
			this.setVisible(true);	
		}else if("查询图书".equals(e.getActionCommand())){
			new Manage5Frame("图书管理");
			this.setVisible(true);
		}else if("删除".equals(e.getActionCommand())){
			new Manage3Frame("用户管理");
			this.setVisible(true);
		}else if("查询信息".equals(e.getActionCommand())){
			new Manage3Frame("用户管理");
			this.setVisible(true);
		}
	}

}

