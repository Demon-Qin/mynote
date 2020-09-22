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
import dao.BorrowDao;
import dao.UserDao;
import daoimpl.BookDaoimpl;
import daoimpl.BorrowDaoimpl;
import daoimpl.UserDaoimpl;
import entity.Book;
import entity.Borrow;
import entity.User;

public class User3Frame extends JFrame implements ActionListener{
	private  User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	JLabel jId=new JLabel("用户：");//new JLabel("用户：");//+this.getUser().getName());
	JLabel jBookid=new JLabel("图书编码：");
	
	
	JTextField jtfBookid=new JTextField("",20);
	JTextField jtfBookseat=new JTextField("",5);
	
	JButton jButtonInsert=new JButton("借书");
	JButton jButtonDelete=new JButton("还书");
	JButton jButtonSearch=new JButton("查询图书");
	JButton jButtonSearchA=new JButton("查询?类书");
	
	
	
	public User3Frame(String title, User user){
		super(title);
		this.setUser(user);
		Container container=this.getContentPane();
		
		jId.setText(jId.getText()+this.getUser().getName());
		container.setLayout(null);
		jId.setBounds(10, 20, 120, 30);
		
		jBookid.setBounds(10, 60, 100, 30);
		jtfBookid.setBounds(80, 60, 100, 30);
		jtfBookseat.setBounds(320, 60, 50, 30);
		
		jButtonInsert.setBounds(10, 230, 100, 30);
		jButtonDelete.setBounds(150, 230, 100, 30);
		jButtonSearch.setBounds(290, 230, 100, 30);
		jButtonSearchA.setBounds(320, 90, 100, 30);
		
		
		
		container.add(jId);
	
		container.add(jBookid);
		container.add(jtfBookid);
		container.add(jtfBookseat);

		container.add(jButtonInsert);
		container.add(jButtonDelete);
		container.add(jButtonSearch);
		container.add(jButtonSearchA);
		
		jButtonInsert.addActionListener(this);
		jButtonDelete.addActionListener(this);
		jButtonSearch.addActionListener(this);
		jButtonSearchA.addActionListener(this);
		
		
		this.setSize(500, 400);
		this.setLocation(380, 150);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		BookDao bk=new BookDaoimpl();
		BorrowDao bd= new BorrowDaoimpl();
		UserDao ud  = new UserDaoimpl();
		String A;
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		
          if("借书".equals(e.getActionCommand())){
		    Borrow borrow = new Borrow();
		    if(bd.getById(this.getUser().getId()).size()<5) {
			      Book book=bk.getBook(jtfBookid.getText()).get(0);			
		          borrow.setId(this.getUser().getId());
		          if(book.getNum()>0) {
		          borrow.setBookid(book.getId());
		          borrow.setBookname(book.getName());
		          User user1 = new User();
		          user1.setId(this.getUser().getId());
		          int code1 = bk.bupdate(book);
			      int code=bd.add(borrow);
			      int code2 = ud.bupdate(user1);
			      System.out.println(code+code1+code2);
			      new BBookFrame("信息提示");
			      this.setVisible(true);	}
		       else {
		    	  new BMistakeFrame("信息提示！");
		    	  this.setVisible(true);
		          }
		      }
		      else {
		    	  new BMistake1Frame("信息提示！");
		    	  this.setVisible(true);
		    	  }
		      
		}else if("还书".equals(e.getActionCommand())){
			
			Book book=bk.getBook(jtfBookid.getText()).get(0);
			Borrow borrow = new Borrow();
			borrow.setBookid(book.getId());
			int code=bd.delete(borrow);
			User user1 = new User();
		    user1.setId(this.user.getId());
		    int code2 = ud.rupdate(user1);
			int code1 = bk.rupdate(book);
			System.out.println(code+code1+code2);
			new RBookFrame("信息提示");
			this.setVisible(true);
			
        }else if("查询图书".equals(e.getActionCommand())){
			
			List<Book> booklist=null;
			booklist=bk.getById(jtfBookid.getText());           
			new U3TableFrame(booklist);
        }else if("查询?类书".equals(e.getActionCommand())){
			
			List<Book> booklist=null;
			booklist=bk.getByA(jtfBookseat.getText());           
			new U3TableFrame(booklist);
       /* }else if("查询B类图书".equals(e.getActionCommand())){
			
			List<Book> booklist=null;
			booklist=bk.getByB(A);           
			new U3TableFrame(booklist);
        }else if("查询C类图书".equals(e.getActionCommand())){
			
			List<Book> booklist=null;
			booklist=bk.getByC(A);           
			new U3TableFrame(booklist);
        }*/
          
		}

	 }

	}
