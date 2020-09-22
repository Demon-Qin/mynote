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
	
	JMenu managerMenu=new JMenu("����Ա");
	JMenu helpMenu=new JMenu("����");
	
	JMenu uxMenu=new JMenu("�û���Ϣ����");
	JMenu bxMenu=new JMenu("ͼ����Ϣ����");
	
	JMenuItem exitItem=new JMenuItem("�˳�");
	JMenuItem returnItem =new JMenuItem("����");
	JMenuItem aboutItem=new JMenuItem("����ϵͳ");
	
	JCheckBoxMenuItem chaItem=new JCheckBoxMenuItem("ɾ��");
	JCheckBoxMenuItem cha1Item=new JCheckBoxMenuItem("��ѯ��Ϣ");
		
	JRadioButtonMenuItem insertItem=new JRadioButtonMenuItem("����ͼ��");
	JRadioButtonMenuItem deleteItem=new JRadioButtonMenuItem("ɾ��ͼ��");
	JRadioButtonMenuItem seachItem=new JRadioButtonMenuItem("��ѯͼ��");
	
	
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
        //һ��Ҫ���óɿɼ���
        this.setVisible(true);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*BookDao bk = new BookDaoimpl();
		// TODO Auto-generated method stub
		int selection = JOptionPane.showConfirmDialog(this,
				"�Ƿ��˳�? ","�˳���ʾ",JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE) ;
				if (selection == JOptionPane.OK_OPTION) {
				System. exit(0);
				}
		System.out.println(e.getActionCommand());*/
		
		if("�˳�".equals(e.getActionCommand())){
			System.exit(WindowConstants.EXIT_ON_CLOSE);
		}else if("����ϵͳ".equals(e.getActionCommand())){
		}else if("����".equals(e.getActionCommand())){
			new LoginFrame("��¼");
			this.setVisible(false);	
		}else if("����ͼ��".equals(e.getActionCommand())){
			new Manage5Frame("ͼ�����");
			this.setVisible(true);
		}else if("ɾ��ͼ��".equals(e.getActionCommand())){
			new Manage5Frame("ͼ�����");
			this.setVisible(true);	
		}else if("��ѯͼ��".equals(e.getActionCommand())){
			new Manage5Frame("ͼ�����");
			this.setVisible(true);
		}else if("ɾ��".equals(e.getActionCommand())){
			new Manage3Frame("�û�����");
			this.setVisible(true);
		}else if("��ѯ��Ϣ".equals(e.getActionCommand())){
			new Manage3Frame("�û�����");
			this.setVisible(true);
		}
	}

}

