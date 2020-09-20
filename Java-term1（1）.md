# Java Basic

输出：  ```system.out.println("Hello JAVA");```

输入 ：``` import java.util.Scanner;```     

```java
public static void main(String args[]) {
Scanner reader=new Scanner(System.in);
		      System.out.print("请输入证件号：");
		sfz=reader.next();
}


```

![1600580735823](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600580735823.png)

## 选择语句

#### if 语句

选择符号  或者||   和&&   非 ！等于== 

if(  条件 ){

​    *************************

}

else( 条件  ){

​      ***************

}

```java
if(a<3) 
	     {System.out.println("y=：1");}
	else if(a<5) 
	     {System.out.println("y=："+a*2);}
	else 
	     {System.out.println("y=："+a*a+5*a+1);}

________________________________________________________
import java.util.Scanner;

public class zifu {
	public static void main(String args[]) {
		String sfz =null,a=null,b=null,c=null;
		Scanner reader=new Scanner(System.in);
		      System.out.print("请输入证件号：");
		sfz=reader.next();
		if(sfz.length()!=18) {
			System.out.println("请输入正确的身份证号");	

		     }
		else  {
	
	    a = sfz.substring(6, 10) ;
		b=sfz.substring(10, 12) ;
		c=sfz.substring(12, 14) ;
		}
	System.out.print("生日为："+a+"年"+b+"月"+c+"日");	
	   }
	
	}
______________________________________________________
 public static void main(String args[]) {
	   int i,sum=0;
	   for(i=1;i<=1000;i++) {
		   if(i%3!=0) {
			   continue;
		   }
		   sum+=i;if(sum>5000){
			   break;
			   }
	      }
		
	  System.out.println("和为"+sum); 
   }
```




#### switch选择结构

switch（a）{

case +条件（a的值）：

break；

case +条件 （a的值）：

break；

default：/*以上情况都没有*/

}

```java
import java.util.Scanner;
public class week {
	public static void main(String args[]) {
	Scanner reader=new Scanner(System.in);
    System.out.print("请输入查询编号");
	int a=reader.nextInt();
do {
	switch(a) {
	case 1:System.out.println("Monday,下一个编号");
	break ;
	case 2:System.out.println("Tuesday,下一个编号");
	break ;
	case 3:System.out.println("Wednesday,下一个编号");
	break ;
	case 4:System.out.println("Thursday,下一个编号");
	break ;
	case 5:System.out.println("Friday,下一个编号");
	break ;
	case 6:System.out.println("Stuarday,下一个编号");
	break ;
	case 7:System.out.println("Sunday,下一个编号");
	break ;
	default:System.out.println("请重新输入:");
	}	a=0; a=reader.nextInt();
		}while(a!=0)
```



## 循环语句

#### while 循环

while（条件）{



}

————————————

do{



}while（条件）

```java
public class seven {
		public static void main(String args[]) {
	int a=1,sum=0;
	while(a<=50) {
		if(a%7==0)
		sum=sum+a;
		a++;}
	System.out.println("小于50的7的倍数和为："+sum);
	}

}
```

#### for 循环

for（i=0;i<=35;i++）{

}

```java
	public static void main(String args[]) {
		int tousum=35,jiaosum=94,i=0;//i是鸡的数量
		for (i=0;i<=35;i++) {
          if(i*2+(tousum-i)*4==jiaosum)
        	  break;
			}
	System.out.println("鸡的数量为"+i+"兔子的数量为"+(tousum-i));		
}
```



#### 随机数

random（）；

```java 
		
	public static void main(String[] args) {
		int num=578;
		int bai=num/100%10;
		double rands=Math.random();
		int randint=(int)(rands*10);
	System.out.print(randint);
		if (bai==randint) {
			System.out.println("中奖");
		   }
		
		else {
			System.out.println("谢谢参与");
        }			
	} 
```



#### 数组

int a = new int[10];   int b = new int[12] [31];

int a = new int []{1,2,3,4,5};  

int a = {1,2,3,4,5};  int b= {{1,2,3},{1,2,3,4,5}};

###### 数组排序


			

```java
public static void main(String args[]) {
		double a[]=new double[]{23.0,46.0,1.75,14.0,21.0};
		int k=0;double t;
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					k=j;
				}
               t=a[i];
		       a[i]=a[k];
		       a[k]=t;
		         k=i;//k存储的是最大值的下标  这样一个循环之后  a【1】已经放了最大值了所以要找下一个最大值就要从1之后的下标开始找
		}
	}	
  
for(int i=0;i<a.length;i++) { 
		System.out.println(a[i]);		
    }	
}
————————————————————————————————————————————————————————

    /*逆数组*/
    
public static void main(String args[]) {
	double a[]=new double[] {12.0,25.0,34.0,190.0,10.0,13.0,};
	double b[]=new double[a.length];  
	for(int i=0;i<a.length;i++) {
		if(a[i]>0) {
			b[a.length-i-1]=a[i];
		}
		else{
		     b[a.length-i-1]=0;}
		  
	  }	
	for(int i=0;i<a.length;i++) {
	System.out.print(a[i]+",");
	    }
	System.out.print("     逆数组为：");
	for(int i=0;i<a.length;i++) {
		System.out.print(b[i]+",");
		}
  }
```
### 菜单

``` java
	public static void main(String args[]) {
	Scanner reader=new Scanner(System.in);
	System.out.print("登录系统or退出");
	String a=reader.next();
	switch(a) {
	case "登录系统":System.out.println("请输入密码：");
		   break; 
	default:System.out.println("再见！");
		   break;
	
	  }
   String i=reader.next();
   switch(i){
	   case"123456":
		 InfoManage(reader);
	   break;
	   default:System.out.println("密码错误");
   }
  }

  
public static void InfoManage(Scanner scan) {
	int secondNum = 1;
	do {
		System.out.println("------------------");
		System.out.println("\t 1.客户管理菜单");
		System.out.println("\t 2.商品管理");
		System.out.println("\t 3.真情回馈");
		
		System.out.println("请输入相关数字：");
		secondNum = scan.nextInt();
		switch (secondNum) {
		case 1:
			userManage(scan);
			break;
		case 2:
			secondManage(scan);
			break;
		case 3:
			System.out.println("真情回馈");
			break;
		
		default:
			System.out.println("请输入1-3之间的数");
		}
	} while (secondNum != 0);
}

public static void userManage(Scanner scan) {
	int thirdNum = 1;
	do {
		System.out.println("------------------");
		System.out.println("\t 1.增加用户");
		System.out.println("\t 2.删除用户");
		System.out.println("\t 3.查询用户");
		System.out.println("\t 0.返回上级菜单");
		System.out.println("请输入相关数字：");
		thirdNum = scan.nextInt();
		switch (thirdNum) {
		case 1:
			System.out.println("增加了客户");
			break;
		case 2:
			System.out.println("删除了客户");
			break;
		case 3:
			System.out.println("查询了客户");
			break;
		case 0:
			System.out.println("马上返回上一级菜单");
			break;
		default:
			System.out.println("请输入0-3之间的数");
		}
	} while (thirdNum != 0);
}
public static void secondManage(Scanner scan) {
	int fourthNum = 1;
	do {
		System.out.println("------------------");
		System.out.println("\t 1.新增商品");
		System.out.println("\t 2.删除商品");
		System.out.println("\t 3.修改商品");
		System.out.println("\t 4.查询商品");
		fourthNum = scan.nextInt();
		switch (fourthNum) {
		case 1:
			System.out.println("增加了商品");
			break;
		case 2:
			System.out.println("删除了商品");
			break;
		case 3:
			System.out.println("查询了商品");
			break;
		case 0:
			System.out.println("马上返回上一级菜单");
			break;
		default:
			System.out.println("请输入0-3之间的数");
		}	
	}while (fourthNum != 0);

}


}```
```





