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
	//声明一个文本框实例label
	Label label=new Label();
	label.setText("账号或密码错误！请重新输入!");
	label.setBounds(60,30,200,100);
	//把label添加到frame里
	con.add(label);
	
	this.setSize(300, 200);		
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	

	

	
}

