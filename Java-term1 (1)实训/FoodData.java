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
				names[i] = "¿ÉÀÖ";
				prices[i] = 2.5;
				reserves[i] = 10;
				break;
			case 1:
				names[i] = "Ãæ°ü";
				prices[i] = 10;
				reserves[i] = 8;
				break;
			case 2:
				names[i] = "Å£ÄÌ";
				prices[i] = 6;
				reserves[i] = 20;
				break;
			case 3:
				names[i] = "Ñ©±Ì";
				prices[i] = 3;
				reserves[i] = 20;
				break;
			case 4:
				names[i] = "¿§·È";
				prices[i] = 6;
				reserves[i] = 13;
				break;
			case 5:
				names[i] = "±ùºì²è";
				prices[i] = 4;
				reserves[i] = 20;
				break;
			}
		}
	}
}