### 显示时间


```java
 public class DateTest {
    public static void main(String[] args)  {
       Date date1 =new Date();
       SimpleDateFormat df1 =new SimpleDateFormat("2019/03/13,a,HH:mm:ss #E",Locale.US);
       String str =df1.format(date1);
       System.out.println(str);
       
   String str2 ="2019/03/13,PM,21:29:10 #Wed";
   Date date3=null;
     try{
      date3 =df1.parse(str2);
     }catch(ParseException e){
         e.getStackTrace();
     }
    System.out.println(date3);
}
```



### 自定义方法


```java
 public void feed(Pet pet, String food) {
	   
   //System.out.println("-----------");
   System.out.println(this.getName()+"喂给");
   pet.eatSomething(food);
   pet.print();
      }
```


### Java 子类继承父类


​	
```java
public class BatteryDim {
	String brand;
public String chargey() {
	String battery = brand + "正在放电";
	   return battery;
}
    }

public class BatteryUse {
  public static void main(String args[]) {
	  BatteryDim battery1 = new BatteryDim() ;
	  battery1.brand = "白象";
	  System.out.println(battery1.chargey());
  }
}
```



![1600665918257](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600665918257.png)

### 类的封装



```java
 public class Car {
 private String name;
 private int seat;
 private String tyep;
 
 public Car(){
 	System.out.println("Car的无参构造方法");
 }
 public Car(String name,int seat,String tyep){
 	this.name = name;
 	this.seat = seat;
 	this.tyep = tyep;
 }
 
 public String getName() {
	 return name;
 }
 public void setName(String name) {
	 this.name = name ;
 }
 public int getSeat() {
	 return seat;
 }
 public void setSeat(int seat) {
	this.seat =seat ; 
 }
 public int getTyep() {
	 return seat;
 }
 public void setTyep(String tyep) {
	this.tyep =tyep ; 
 }
 
 public void print() {
	 System.out.println("------------");
	 System.out.println("品牌:"+this.name); 
	 System.out.println("可载人数:"+this.seat); 
	 System.out.println("能源类型:"+this.tyep);
 }
}
```

Bus继承Car

```java
	public class BusCar extends Car{
	private int few ;
	public BusCar(){
	 	System.out.println("BusCar的无参构造方法");
	 }
    public BusCar(int few) {
    	this.few = few ;
     }
    public int getFew() {
    	return few;
    }
    public void setFew(int few) {
    	this.few = few ;
    }
   public BusCar(String name, int seat, String tyep,int few){
    	super(name,seat,tyep);
    	this.few = few ;
    }
    public void print() {
    	super.print();
    	System.out.println("线路："+few+"路");
    }
    public void run() {
    	System.out.println(few+"路即将进站");
    }
}
```

实例

```java
	public class CarTest {
	public static void main(String[] args) {
		BusCar bus1 = new BusCar("公交车",20,"燃料",2);
		bus1.print();
		bus1.run();
		Car car1 = new Car("汽车",5,"新能源");
		car1.print();
		}
	
}
```





### 接口

接口
```java
public interface Graphics {
	 
void show();
}
```

```java
public class Triangle implements Graphics{
      public void show() {
    	  System.out.println("这是三角形");
      }
}
```

```java
public class TestInterface {
	public static void main(String[] args) {
        Graphics triangle =new Triangle();
        triangle.show();
    }

}
```





### Dao

![1600750583878](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600750583878.png)

Dao  接口       Daoimpl具体写接口  entity用接口



### 连接数据库


```java
public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
   Class.forName("com.mysql.jdbc.Driver");
	
	String url="jdbc:mysql://localhost:3306/myjava";
	
	Connection connection=null;
	PreparedStatement statement=null;
	connection=DriverManager.getConnection(url, "root", "123456");
	/*System.out.println(connection);*/
	
	return connection;
}

public static void closeResource(Connection connection,Statement statement){
	if (statement != null) {
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	if (connection != null) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

```


###  dao中的  add（） delete（） getbyId（）

```java
@Override
public int add(StudentManage student) {
		// TODO Auto-generated method stub
		
		int code = 0;
		String sql = "insert into students (id,name,age,mark) values(?,?,?,?)";
        code = DBUtils.update(sql, student.getId(),
        		                 student.getName(),
        		                 student.getAge(),
        		                 student.getMark());
		System.out.println(code);
		return code;
	}

	@Override
	public int delete(StudentManage student) {
		// TODO Auto-generated method stub
		 int code=0;
	        String sql="delete from students where id=?";
	        code=DBUtils.update(sql,student.getId());
		return code;
	}

	@Override
	public List<StudentManage> getById(int age) {
		// TODO Auto-generated method stub
		String sql="select*from students where age=?";
        List<StudentManage> studentList= new ArrayList<>();
        List<Map<String,Object>> mapList=DBUtils.query(sql,new Integer(age));
        for (Map<String,Object>map:mapList){
            StudentManage student=new StudentManage();
            student.setId((Integer)(map.get("id")));
            student.setName((String) (map.get("name")));
            student.setMark((Integer) (map.get("mark")));
            student.setAge((Integer)(map.get("age")));
            studentList.add(student);
        }
        return studentList;
    }
```

### 异常处理

try{

   可能会出错的代码

   }catch(捕捉异常){

​     提示错误

   }finally{

​        无论怎样最后都要执行的语句

​    }

```java
public class Exception {	
    public static void main(String[] args) {

         try{
             String A= "fang";
             A.charAt(5);
             
         System.out.println(A);
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("检测到字符串越界访问，并捕捉到异常");
        }finally{
            System.out.println("结束！");
        }
         System.out.println("感谢使用！");
    }
}
```

##### 自定义异常

```	java
public class AException extends Exception{
       public AException(String msg) {
			super(msg);
		}
	}
```

抛出异常

```java
public void soldway() throws AException{
		if((Astock-sellAstock)/Astock*100>10) {
			AException ste = new AException("自定义异常，股票卖出不得超过涨停幅度(A股为10%)");
			throw ste;
		}else {
			this.sellAstock = sellAstock;
			System.out.println("今日股价为"+this.sellAstock+"元/股");
		}
```



### 本地创建文件

```java
public class Demo01_File {	
	public void TestFile() {
	 //File dir1 = new File("D:\\case\\myDir");
	  //dir1.mkdirs();
	
	  File file1 = new File("D:\\case\\myDir\\我的青春我做主.txt");
	   if(!file1.exists()) {
		   System.out.print("文件不存在，创建新文件");
	     try {	
    		 file1.createNewFile();
    		 System.out.println("绝对路径："+file1.getAbsolutePath());
    		 System.out.println("文件名："+file1.getName());
    		 System.out.println("路径："+file1.getParent());	
	     }catch(IOException e) {
	    	 e.printStackTrace();
	     }
	   }
	     if(file1.exists()) {
	    	 System.out.print("文件以创建，删除文件");
	    	 file1.delete();
	     }
	  }
     public static void main(String args[]) {
	Demo01_File file = new Demo01_File();
	file.TestFile();
 }
   
}
```

### 基础页面制作

​       标签    private  JLabel jl1 =  new JLabel(" ");
​	   文本框   private JTextField jtf1 = new JTextField(5);
​	   按钮     private JButton jb1 = new JButton(" ");
​	   
​	   

```java
public class CalculationFrame extends JFrame implements ActionListener{
	    private JLabel jl1=  new JLabel("请输入任意一个数：");
	    private JTextField jtf1 = new JTextField(5);
	    private JButton jb1 = new JButton("计算");
	    private  JLabel jl2 = new JLabel("它的三次方为：");
	    public CalculationFrame() throws HeadlessException {
	        super();
    }
    public CalculationFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container=this.getContentPane();
        container.setLayout(new FlowLayout());
        
        jb1.addActionListener(this);
        container.add(jl1);
        container.add(jtf1);
        container.add(jb1);
        container.add(jl2);
        this.setSize(300,200);
        this.setLocation(200, 200);
        this.setVisible(true);
}
   
    public void actionPerformed(ActionEvent e) {
        String total=jtf1.getText();
        double num=Double.parseDouble(total);
        double result=num*num*num;
        jl2.setText(num+"结果为"+result);
              }
public static void main(String[] args) {
   
        new CalculationFrame("计算器");
        }
```


![1600674616094](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600674616094.png)

###  ArrayList

1.定义一个类

2.



```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class PenguinsArrayList {
	  public static void main(String[] args) {
	       
        List<Penguin> penguinslist = new ArrayList<>();
        Penguin penguin1 = new Penguin("企鹅1", 6, "帝企鹅");
        Penguin penguin2 = new Penguin("企鹅2", 7, "阿德利企鹅");
        Penguin penguin3 = new Penguin("企鹅3", 8, "金图企鹅");
        penguinslist.add(penguin1);
        penguinslist.add(penguin2);
        penguinslist.add(penguin3);
        Iterator <Penguin>iterator = penguinslist.iterator();
            
            while (iterator.hasNext()) {
                Penguin pentemp = iterator.next();
                System.out.println(pentemp);
                }
            if(penguinslist.contains(penguin1)){
                System.out.println("企鹅1在list中了，我已经将其删掉");
                penguinslist.remove(0);
            }else{
                System.out.println("企鹅1已经不在list中了");
            
            }
            System.out.println(penguinslist.size());
            for(int i=0;i<penguinslist.size();i++){
                System.out.println(penguinslist.get(i));
            }
        }
    }
```



### Hashmap



![img](file:///C:\Users\admin\Documents\Tencent Files\1792357514\Image\C2C\311FFC65BE800FE22507645F4FF74207.jpg)



###  线程

```java
class Thread1 extends Thread{
	public void run() {
		System.out.println("1到100中的偶数：");
		for(int i =2; i<=100 ;i+=2) {
			System.out.println(i);
		}
	}
	
}
class Thread2 extends Thread{
	public void run() {
		System.out.println("1到100中的奇数：");
		for(int i =1; i<=100 ;i+=2) {
			System.out.println(i);
		}
	}
	
}

public class TestThread {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}

}
```



```java
class Run implements Runnable {
@Override
public void run() {
	System.out.println("1到100中的偶数：");
	for(int i =2; i<=100 ;i+=2) {
		System.out.println(i);
	}
}
}
public class TestRun{
	public static void main(String[] args) {
		Run run1 = new Run();
		Thread th1 = new Thread(run1,"子线程");
		th1.start();
		System.out.println("1到100中的奇数：");
		for(int i =1; i<=100 ;i+=2) {
			System.out.println(i);
			}
			}
		}
```


```java
class ExpertRegistration {
	private int count = 1;
public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public void register() {
	while (true) {
		synchronized (this) {
			if (count > 40) {
				System.out.println("专家号已挂完！");
				break;
			} else {
				System.out.println(Thread.currentThread().getName() + "挂出的第 " + (count++) + " 个专家号");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
    }

class RegisteredWindow extends Thread {
	private ExpertRegistration er;
public RegisteredWindow(String name, ExpertRegistration er) {
	super(name);
	this.er = er;
}

@Override
public void run() {
	super.run();
	er.register();
}
}
public class HospitalRun {
public static void main(String[] args) {
	// TODO Auto-generated method stub
	ExpertRegistration er = new ExpertRegistration();

	RegisteredWindow rw1 = new RegisteredWindow("窗口1", er);
	RegisteredWindow rw2 = new RegisteredWindow("窗口2", er);
	RegisteredWindow rw3 = new RegisteredWindow("窗口3", er);

	rw1.start();
	rw2.start();
	rw3.start();
}
}
```

### woker小作业

```java
public abstract class Woker {
String name ;
     int age ;
     String sex ;
     int salary ;
     
     public  Woker() {
    	 System.out.println("无参");
     }
     public Woker(String name , int age, String sex, int salary) {
    	 this.name = name ;
    	 this.age = age ;
    	 this.sex = sex ;
    	 this.salary = salary ;
    	 
     }
     public String getName() {
    	 return name ;
     }
     public void setName(String name ) {
    	 this.name = name ;
     }
     public int getAge() {
    	 return age ;
     }
     public void setAge(int age) {
    	 this.age = age ;
     }
     public String getSex() {
    	 return sex ;
     }
     public void setSex(String sex) {
    	 this.sex = sex ;
     }
     public int getSalary() {
    	 return salary ;
     }
     public void setSalary(int salary) {
    	 this.salary = salary ;
     }
     public void print() {
    	 System.out.println("-----------");
    	 System.out.println("姓名： "+name);
    	 System.out.println("年龄： "+age);
    	 System.out.println("性别： "+sex);
    	 System.out.println("基本薪资："+salary);
     }
     public abstract void printIncomeFullYear(double shares );
}
```

```java
public abstract class Executives extends Woker{
    private int subsidies ;
	private String position ;
	public  Executives(){
	 	System.out.println("Executives的无参构造方法");
	 	}
	public Executives(int subsidies,String position){
		this.subsidies = subsidies ;
		this.position = position ;
	}
	public int getSubsidies() {
		return subsidies ;
	}
	public void setSubsidies(int subsidies) {
		this.subsidies = subsidies ;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position ;
	}
	Executives(String name, int age ,String sex ,int salary,int subsidies,String position){
		super(name,age,sex,salary);
		this.position = position ;
		this.subsidies = subsidies ;
	}
	 public void print() {
		 
		 System.out.println("-----------");
    	 System.out.println("职位：  "+position);
    	 System.out.println("姓名： "+name);
    	 System.out.println("年龄： "+age);
    	 System.out.println("性别： "+sex);
    	 System.out.println("基本薪资："+salary);
    	 System.out.println("行政补贴："+subsidies);
    	 
	 }
	 public void printIncomebyMonth() {
		 int Money = (salary+subsidies) ;
		System.out.println("本月薪资为： "+Money+"元");
		
	 }
}
```

```java
public class Manager extends Woker{
    private int shares ;
	public  Manager(){
	 	System.out.println("无参构造方法");
	}
	Manager(String name, int age ,String sex ,int salary){
		super(name,age,sex,salary);       
        }
	  public void printIncomeFullYear(double shares ){		
		    System.out.println("每月分红："+shares*2500+"(占股"+shares+"%)");	
		    double Money = salary+shares*2500 ;
			System.out.println("年薪为： "+Money*12+"元");
			}
}
```

```java
public class WokerTest {
    public static void main(String[] args) {
		
		Manager manager1 = new Manager("xxx",23,"女",3000);
		manager1.print();
		manager1.printIncomeFullYear(5);
	}
	
}
```