package copyitem;

import java.util.Scanner;

public class Shopping {
	private Cart cart;
	
	public Shopping() {
		cart = new Cart();
	}
	
	
	public void showAllFoods() {
		System.out.println("��Ʒ���\t"+"��Ʒ����\t"+"��Ʒ����(Ԫ)\t"+"��Ʒ����(��)");
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
			System.out.println("������Ҫ�������Ʒ���:");
			int foodId = sc.nextInt();
				if(foodId >=1 && foodId<= FoodData.foodKinds){
					while(true){
						System.out.println("������"+ FoodData.names[foodId - 1]+"�Ĺ�������:");
						number = sc.nextInt();
						if( !(number <= FoodData.reserves[foodId - 1])){
							System.out.println("������������ڸ���Ʒ�Ŀ������������������!");
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
						System.out.println("���ﳵ�ѷ������޷��ټ�������!");
						break;
					}
					break;
				}else{
					System.out.println("�������Ʒ�����������������!");
				}
			}
			for(int i=0; i <index; i++){
				System.out.println("Ŀǰ������:"+ cart.foodsInCart[i].getName()+ "\t����Ϊ:" + cart.foodsInCart[i].getNumber()+
						"\t��֧��: " + cart.foodsInCart[i].getNumber() * cart.foodsInCart[i].getPrice()+"Ԫ");
			}
			System.out.println("�Ƿ��������?(1.�� 2.��)");
			int option = sc.nextInt();
			if(option == 1){
				showAllFoods();
				flag = true;
			}else{
				flag = false;
				double total = 0;
				System.out.println("СƱ��ӡ��......");
				System.out.println("***************����СƱ***************");
				for(int i=0; i <index; i++){
					System.out.println("��Ʒ��:"+ cart.foodsInCart[i].getName()+ "\t����:" + cart.foodsInCart[i].getNumber()+
							"\t��֧��: " + cart.foodsInCart[i].getNumber() * cart.foodsInCart[i].getPrice()+"Ԫ");
					total = total + cart.foodsInCart[i].getNumber() * cart.foodsInCart[i].getPrice();
				}
				System.out.println("һ����֧��: "+ total + "Ԫ");
				System.out.println("-------------------------------------");
				System.out.println("лл����!");
			}
			
		}while(flag);
		
	}
}

