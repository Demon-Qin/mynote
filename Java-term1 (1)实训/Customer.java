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
	System.out.println("�������û���:");
	String user = reader.next();
	System.out.println("����������");
	String pw = reader.next();
	if(!"useName".equals(user) && !"pw".equals(pw)){
		if("admin".equals(user)&& "123".equals(pw)){
			System.out.println("��¼�ɹ�!");Main main = new Main();main.welcome();
		}else{
			System.out.println("�û�����������������������!");
			yibo();
		}
	}else{
		System.out.println("�û��������벻��Ϊ��!");
	  yibo();
	}
}
}
