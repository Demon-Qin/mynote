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

import dao.BookDao;
import daoimpl.BookDaoimpl;
import entity.Book;
import gui.U3TableFrame;


public class Manage5Frame extends JFrame implements ActionListener{
	JLabel jId=new JLabel("图书编号：");
	JLabel jBookname=new JLabel("书名：");
	JLabel jName=new JLabel("作者：");
	JLabel jPrice=new JLabel("价格：");
	JLabel jNum=new JLabel("数量：");
	
	JTextField jtfId=new JTextField("",20);
	JTextField jtfBookname=new JTextField("",20);
	JTextField jtfName=new JTextField("",20);
	JTextField jtfPrice=new JTextField("",20);
	JTextField jtfNum=new JTextField("",20);
	
	
	JButton jButtonInsert=new JButton("新增图书");
	JButton jButtonDelete=new JButton("删除图书");
	JButton jButtonSearch=new JButton("书本查询");
	
	public Manage5Frame(String title){
		super(title);
		Container container=this.getContentPane();
		
		container.setLayout(null);
		jId.setBounds(10, 20, 80, 30);
		jtfId.setBounds(100, 20, 100, 30);
		
		jBookname.setBounds(10, 60, 40, 30);
		jtfBookname.setBounds(100, 60, 100, 30);
		
		jName.setBounds(10, 100, 40, 30);
		jtfName.setBounds(100, 100, 100, 30);
		
		jNum.setBounds(10, 180, 40, 30);
		jtfNum.setBounds(100, 180, 100, 30);
		
		jPrice.setBounds(10, 140, 40, 30);
		jtfPrice.setBounds(100, 140, 100, 30);
		
		jButtonInsert.setBounds(10, 230, 100, 30);
		jButtonDelete.setBounds(150, 230, 100, 30);
		jButtonSearch.setBounds(290, 230, 140, 30);
		
		
		
		container.add(jId);
		container.add(jtfId);
		
		container.add(jBookname);
		container.add(jtfBookname);
		
		container.add(jName);
		container.add(jtfName);
		
		container.add(jNum);
		container.add(jtfNum);

		container.add(jPrice);
		container.add(jtfPrice);
		
		container.add(jButtonInsert);
		container.add(jButtonDelete);
		container.add(jButtonSearch);
		jButtonInsert.addActionListener(this);
		jButtonDelete.addActionListener(this);
		jButtonSearch.addActionListener(this);
		
		this.setSize(500, 400);
		this.setLocation(380, 150);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
        BookDao dao = new BookDaoimpl();
        if ("新增图书".equals(e.getActionCommand())) {
            Book book = new Book(); 
            book.setId(jtfId.getText());
            book.setName(jtfBookname.getText());            
            book.setAuthor(jtfName.getText());
            book.setNum(Integer.parseInt(jtfNum.getText()));
            book.setPrice(Double.parseDouble(jtfPrice.getText()));

            
            int code = dao.add(book);
            System.out.println("已成功添加图书"+book.getName());
        }else if("删除图书".equals(e.getActionCommand())){
        	Book book = new Book();
            book.setId(jtfId.getText());
            int code=dao.delete(book);
            System.out.println("已删除图书"+book.getName());

        } else if ("书本查询".equals(e.getActionCommand())) {
           List<Book> booklist = null ;
           booklist = dao.getAll();
           new U3TableFrame(booklist);
           
        }
    }
		
		
}