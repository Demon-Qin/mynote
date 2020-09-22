
package entity;

public class Book {
   String id;
   String name;
   String author;
   int num;
   double price;
   String seat;

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}

}
