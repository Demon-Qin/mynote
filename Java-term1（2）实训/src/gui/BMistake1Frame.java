package gui;

import java.awt.Container;
import java.awt.Label;

import javax.swing.JFrame;

public class BMistake1Frame extends JFrame {

	
	public BMistake1Frame(String title) {
		
    Container con=this.getContentPane();
	con.setLayout(null);
	con.setSize(400,300);
	con.setLocation(300,500);
	con.setVisible(true);
	//����һ���ı���ʵ��label
	Label label=new Label();
	label.setText("��������������");
	label.setBounds(100,80,100,100);
	//��label��ӵ�frame��
	con.add(label);
	
	this.setSize(300, 300);		
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}

