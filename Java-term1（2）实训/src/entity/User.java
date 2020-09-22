package entity;

public class User {
	String id;
	String name;
	int booknum;
	String bookstate;
	double deposit;
	public User() {}

	public User(String id, String name, int booknum, String bookstate, Double deposit) {
		this.id=id;
		this.name=name;
		this.booknum=booknum;
		this.bookstate= bookstate;
		this.deposit= deposit;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
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

	public int getBooknum() {
		return booknum;
	}

	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getBookstate() {
		return bookstate;
	}

	public void setBookstate(String bookstate) {
		this.bookstate = bookstate;
	}
@Override
public String toString() {
	return   "[id="+id+"+name="+name+"+booknum="+booknum+"+bookstate="+bookstate+"+deposit="+deposit+"]";
}
	
}