package copyitem;

import java.util.Scanner;

public class Shopping {
	private Cart cart;
	
	public Shopping() {
		cart = new Cart();
	}
	
	
	public void showAllFoods() {
		System.out.println("商品编号\t"+"商品名称\t"+"商品单价(元)\t"+"商品数量(件)");
		for(int i=0; i< FoodData.names.length; i++) {
			if( FoodData.names[i] != null) {
				System.out.println((i+1)+"\t"+FoodData.names[i]+ "\t" 
						+ FoodData.prices[i] + "\t\t" + FoodData.reserves[i]);
			}
		}
	}
	
	public void buy() {
		boolean flag = true;
		int index = 0;
		int number = 0;
		Scanner sc = new Scanner(System.in);
		do {
			while(true){
			System.out.println("请输入要购买的商品编号:");
			int foodId = sc.nextInt();
				if(foodId >=1 && foodId<= FoodData.foodKinds){
					while(true){
						System.out.println("请输入"+ FoodData.names[foodId - 1]+"的购买数量:");
						number = sc.nextInt();
						if( !(number <= FoodData.reserves[foodId - 1])){
							System.out.println("输入的数量大于该商品的库存数量，请重新输入!");
						}else{
							break;
						}
					}
					Foods food = new Foods(FoodData.names[foodId - 1], FoodData.prices[foodId - 1], number);
					FoodData.reserves[foodId - 1] = FoodData.reserves[foodId - 1] - number;
					if( index < 10){
						cart.foodsInCart[index] = food;
						index++;
					}else{
						System.out.println("购物车已放满，无法再继续购买!");
						break;
					}
					break;
				}else{
					System.out.println("输入的商品编号有误，请重新输入!");
				}
			}
			for(int i=0; i <index; i++){
				System.out.println("目前购买了:"+ cart.foodsInCart[i].getName()+ "\t数量为:" + cart.foodsInCart[i].getNumber()+
						"\t需支付: " + cart.foodsInCart[i].getNumber() * cart.foodsInCart[i].getPrice()+"元");
			}
			System.out.println("是否继续购物?(1.是 2.否)");
			int option = sc.nextInt();
			if(option == 1){
				showAllFoods();
				flag = true;
			}else{
				flag = false;
				double total = 0;
				System.out.println("小票打印中......");
				System.out.println("***************购物小票***************");
				for(int i=0; i <index; i++){
					System.out.println("商品名:"+ cart.foodsInCart[i].getName()+ "\t数量:" + cart.foodsInCart[i].getNumber()+
							"\t需支付: " + cart.foodsInCart[i].getNumber() * cart.foodsInCart[i].getPrice()+"元");
					total = total + cart.foodsInCart[i].getNumber() * cart.foodsInCart[i].getPrice();
				}
				System.out.println("一共请支付: "+ total + "元");
				System.out.println("-------------------------------------");
				System.out.println("谢谢光临!");
			}
			
		}while(flag);
		
	}
}

