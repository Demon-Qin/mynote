package copyitem;

import java.util.Scanner;


public class Main {
	Shopping shopping = new Shopping();
	static Main main;
 
	public static void main(String[] args) {
		main = new Main();
		main.login();
	}
	
	public void login(){
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("请选择登录身份:1.管理员    2.收银");
			int option = sc.nextInt();
			if(option == 1){
				Admin admin = new Admin();
				admin.login();
			}else if(option == 2){
				Customer customer = new Customer();
				customer.yibo();
			}
			System.out.println("是否继续操作?1 是    2 否");
			option = sc.nextInt();
			if(option == 1){
				continue;
			}else if(option == 2){
				break;
			}
		}while(true);
		System.out.println("谢谢使用本系统!");
	}
	
	public void welcome() {
		System.out.println("*********************************");
		System.out.println("欢迎使用");
		System.out.println("*********************************");
		showAllFoods();
	}
	
	public void showAllFoods() {
		
		shopping.showAllFoods();
		buy();
	}
	
	public void buy(){
		shopping.buy();
	}
}


