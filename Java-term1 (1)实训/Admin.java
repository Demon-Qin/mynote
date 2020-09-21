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
		System.out.println("请输入用户名:");
		String user = sc.next();
		System.out.println("请输入密码");
		String psw = sc.next();
		if(!"".equals(user) && !"".equals(psw)){
			if("manage".equals(user)&& "456".equals(psw)){
				System.out.println("登录成功!");
				showAdminMenu();
			}else{
				System.out.println("用户名或密码有误，请重新输入!");
				login();
			}
		}else{
			System.out.println("用户名或密码不能为空!");
			login();
		}
	}
	
	public void showAdminMenu(){
		System.out.println("--------------------------");
		System.out.println("=======管理员操作菜单=========");
		System.out.println("--------------------------");
		System.out.println("1.添加商品");
		System.out.println("2.下架商品");
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
			System.out.println("请输入新增商品名称:");
			String name = sc.next();
			System.out.println("请输入新增商品单价:");
			double price = sc.nextDouble();
			System.out.println("请输入新增商品库存数量:");	
			int reserve = sc.nextInt();
			FoodData.names[currentFoodKinds] = name;
			FoodData.prices[currentFoodKinds] = price;
			FoodData.reserves[currentFoodKinds] = reserve;
			FoodData.foodKinds++;
			Shopping shopping = new Shopping();shopping.showAllFoods();
			System.out.println("新商品添加成功，还可添加" + (10 - FoodData.foodKinds) + "种商品");
		}else{
			System.out.println("抱歉，库存已满，无法新增商品!");
		}
	}
	
	public void deleteCommodity(){
		showAllCommodity();
		System.out.println("请输入要下架的商品编号:");
		int foodId = sc.nextInt();
		if(foodId >=1 && foodId<= FoodData.foodKinds){
			
				FoodData.names[foodId-1]=null;
				FoodData.prices[foodId-1]=0.0;
				FoodData.reserves [foodId-1]=0;
				Shopping shopping = new Shopping();shopping.showAllFoods();
				
			}
	}
	
	public void showAllCommodity(){
		System.out.println("商品编号\t"+"商品名称\t"+"商品单价(元)\t"+"商品数量(件)");
		for(int i=0; i< FoodData.foodKinds; i++) {
			if( FoodData.names[i] != null) {
				System.out.println((i+1)+"\t"+FoodData.names[i]+ "\t" 
						+ FoodData.prices[i] + "\t\t" + FoodData.reserves[i]);
			}
		}
	}
}
