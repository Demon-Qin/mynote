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