package copyitem;

import java.util.Scanner;

public class Admin {
	private String userName = "manage";
	private String psw = "456";
	Scanner sc = new Scanner(System.in);
	
	public Admin(){
		
	}
 
	public String getUserName() {
		return userName;
	}
 
	public String getPsw() {
		return psw;
	}
	
	public void login(){
		System.out.println("�������û���:");
		String user = sc.next();
		System.out.println("����������");
		String psw = sc.next();
		if(!"".equals(user) && !"".equals(psw)){
			if("manage".equals(user)&& "456".equals(psw)){
				System.out.println("��¼�ɹ�!");
				showAdminMenu();
			}else{
				System.out.println("�û�����������������������!");
				login();
			}
		}else{
			System.out.println("�û��������벻��Ϊ��!");
			login();
		}
	}
	
	public void showAdminMenu(){
		System.out.println("--------------------------");
		System.out.println("=======����Ա�����˵�=========");
		System.out.println("--------------------------");
		System.out.println("1.�����Ʒ");
		System.out.println("2.�¼���Ʒ");
		int option = sc.nextInt();
		if(option == 1){
			addCommodity();
		}else if(option == 2){
			deleteCommodity();
		}
	}
	
	public void addCommodity(){
		int currentFoodKinds = FoodData.foodKinds;
		if(currentFoodKinds < 10){
			System.out.println("������������Ʒ����:");
			String name = sc.next();
			System.out.println("������������Ʒ����:");
			double price = sc.nextDouble();
			System.out.println("������������Ʒ�������:");	
			int reserve = sc.nextInt();
			FoodData.names[currentFoodKinds] = name;
			FoodData.prices[currentFoodKinds] = price;
			FoodData.reserves[currentFoodKinds] = reserve;
			FoodData.foodKinds++;
			Shopping shopping = new Shopping();shopping.showAllFoods();
			System.out.println("����Ʒ��ӳɹ����������" + (10 - FoodData.foodKinds) + "����Ʒ");
		}else{
			System.out.println("��Ǹ������������޷�������Ʒ!");
		}
	}
	
	public void deleteCommodity(){
		showAllCommodity();
		System.out.println("������Ҫ�¼ܵ���Ʒ���:");
		int foodId = sc.nextInt();
		if(foodId >=1 && foodId<= FoodData.foodKinds){
			
				FoodData.names[foodId-1]=null;
				FoodData.prices[foodId-1]=0.0;
				FoodData.reserves [foodId-1]=0;
				Shopping shopping = new Shopping();shopping.showAllFoods();
				
			}
	}
	
	public void showAllCommodity(){
		System.out.println("��Ʒ���\t"+"��Ʒ����\t"+"��Ʒ����(Ԫ)\t"+"��Ʒ����(��)");
		for(int i=0; i< FoodData.foodKinds; i++) {
			if( FoodData.names[i] != null) {
				System.out.println((i+1)+"\t"+FoodData.names[i]+ "\t" 
						+ FoodData.prices[i] + "\t\t" + FoodData.reserves[i]);
			}
		}
	}
}
