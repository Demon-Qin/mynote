package gui;

import java.awt.Container;
import java.awt.Label;

import javax.swing.JFrame;

public class BMistakeFrame extends JFrame {

	
	public BMistakeFrame(String title) {
		
    Container con=this.getContentPane();
	con.setLayout(null);
	con.setSize(400,300);
	con.setLocation(300,500);
	con.setVisible(true);
	//声明一个文本框实例label
	Label label=new Label();
	label.setText("库存不足！");
	label.setBounds(100,80,100,100);
	//把label添加到frame里
	con.add(label);
	
	this.setSize(300, 300);		
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
