package copyitem;

public class Foods {
	private String name;
	private double price;
	private int number = 0;
	
	public Foods(String name,double price, int number) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
	}
	
	public double getPrice() {
		return price;
	}
 
	public void setPrice(double price) {
		this.price = price;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public int getNumber() {
		return number;
	}
 
	public void setNumber(int number) {
		this.number = number;
	}
 
}
