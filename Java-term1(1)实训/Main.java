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
			System.out.println("��ѡ���¼���:1.����Ա    2.����");
			int option = sc.nextInt();
			if(option == 1){
				Admin admin = new Admin();
				admin.login();
			}else if(option == 2){
				Customer customer = new Customer();
				customer.yibo();
			}
			System.out.println("�Ƿ��������?1 ��    2 ��");
			option = sc.nextInt();
			if(option == 1){
				continue;
			}else if(option == 2){
				break;
			}
		}while(true);
		System.out.println("ллʹ�ñ�ϵͳ!");
	}
	
	public void welcome() {
		System.out.println("*********************************");
		System.out.println("��ӭʹ��");
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


