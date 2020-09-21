package copyitem;

import java.util.Scanner;

import cashierItem.CashierMenu;

public class Customer {
	private boolean isMember = false;
	 
	public boolean isMember() {
		return isMember;
	}
 
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}


private String userName = "admin";
private String pw = "123";
Scanner reader = new Scanner(System.in);


public String getUserName() {
	return userName;
}

public String getPw() {
	return pw;
}

public void yibo(){
	System.out.println("请输入用户名:");
	String user = reader.next();
	System.out.println("请输入密码");
	String pw = reader.next();
	if(!"useName".equals(user) && !"pw".equals(pw)){
		if("admin".equals(user)&& "123".equals(pw)){
			System.out.println("登录成功!");Main main = new Main();main.welcome();
		}else{
			System.out.println("用户名或密码有误，请重新输入!");
			yibo();
		}
	}else{
		System.out.println("用户名或密码不能为空!");
	  yibo();
	}
}
}
