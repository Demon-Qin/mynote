package copyitem;

public class FoodData {
	public static String[] names = new String[10];
	public static double[] prices = new double[10];
	public static int []reserves = new int[10];
	public static int foodKinds = 6;
	
	static{
		for(int i=0; i<names.length;i++) {
			switch(i) {
			case 0:
				names[i] = "����";
				prices[i] = 2.5;
				reserves[i] = 10;
				break;
			case 1:
				names[i] = "���";
				prices[i] = 10;
				reserves[i] = 8;
				break;
			case 2:
				names[i] = "ţ��";
				prices[i] = 6;
				reserves[i] = 20;
				break;
			case 3:
				names[i] = "ѩ��";
				prices[i] = 3;
				reserves[i] = 20;
				break;
			case 4:
				names[i] = "����";
				prices[i] = 6;
				reserves[i] = 13;
				break;
			case 5:
				names[i] = "�����";
				prices[i] = 4;
				reserves[i] = 20;
				break;
			}
		}
	}
}