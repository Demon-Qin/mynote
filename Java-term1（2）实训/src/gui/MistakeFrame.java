package gui;

import java.awt.Container;
import java.awt.Label;

import javax.swing.JFrame;

public class MistakeFrame extends JFrame {

	
	public MistakeFrame(String title) {
		
    Container con=this.getContentPane();
	con.setLayout(null);
	con.setSize(400,300);
	con.setLocation(300,500);
	con.setVisible(true);
	//����һ���ı���ʵ��label
	Label label=new Label();
	label.setText("�˺Ż������������������!");
	label.setBounds(60,30,200,100);
	//��label��ӵ�frame��
	con.add(label);
	
	this.setSize(300, 200);		
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	

	

	
}

