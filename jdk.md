# JDK部署

安装jdk参考网站：https://developer.aliyun.com/article/774993?spm=a2c6h.13813017.0.dArticle738638.4b3968d57D8Skq

## 一、下载JDK并上传

https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

![jdk选择.jpg](https://cdn.nlark.com/yuque/0/2020/jpeg/2645003/1601613354644-36f2f138-c767-49bb-a7ea-64163a499a80.jpeg)

根据自己服务器的操作系统选择自己的jdk，我的是CentOS，因此选择图中这个压缩包并下载。





下载完之后，直接在Termius中用SFTP连接服务器

![sftp1.jpg](https://cdn.nlark.com/yuque/0/2020/jpeg/2645003/1601613948974-df79b3f0-555f-4d37-baed-1717eeb47bac.jpeg)

找一个地方来存放压缩包，我在/opt下建了一个文件夹来存放压缩包和解压后的文件

![jdk1.jpg](https://cdn.nlark.com/yuque/0/2020/jpeg/2645003/1601614215727-5c27d00c-e1a8-4df6-9fb6-003ff50b6d4f.jpeg)

压缩包放好后用命令解压



 ***tar  -zxvf  jdk-8u261-linux-x64.tar.gz*** 



## 二、配置环境变量



1.  输入命令  ***vi ~/.bashrc***  进入文件后英文状态下按“i”开始编辑环境变量，配置变量时小心误删内容。
2.  vi /etc/profile

```
export JAVA_HOME=/opt/jdk/jdk1.8.0_261
export CLASSPATH=.:$JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$JAVA_HOME/bin:$PATH
```



输入完变量后按“esc”并输入 :wq 保存修改并退出

输入   **source ~/.bashrc**  使环境变量生效 

输入命令查看环境变量：

**echo $CLASSPATH**

**echo $PATH**

输入命令查看jdk的版本

 java -version

![jdk3.jpg](https://cdn.nlark.com/yuque/0/2020/jpeg/2645003/1601615047132-311f801c-1801-4603-bc2a-231657f66225.jpeg)

出现版本号即为配置成功



### Tomcat



1、下载链接：https://tomcat.apache.org/download-70.cgi，选择需要的版本下载（.tar.gz文件后缀）

2、通过Xshell、Xftp上传至CentosX的 某个目录下（如/home/temp/)

3、进入/home/temp目录下,解压tomcat安装包：

​    3.1 cd /home/temp

​    3.2 tar -xzvf apache-tomcat-7.0.86.tar.gz

4、将解压缩后的tomcat文件夹复制至/usr/local目录下，并重命名：

  4.1 cp /home/local/apache-tomcat-7.0.86 -R /usr/local 

  4.2 mv ./apache-tomcat-7.0.86 tomcat 

5、配置Tomcat用户信息(可不配置)：

  5.1  cd /usr/local/tomcat/conf

  5.2  vi tomcat-users.xml (末尾添加如下信息)　

```
<role rolename="tomcat"/>
<role rolename="manager-gui"/>
<role rolename="admin-gui"/>
<role rolename="manager-script"/>
<role rolename="admin-script"/>
<user username="tomcat" password="tomcat" roles="tomcat,manager-gui,admin-gui,admin-script,manager-script"/>
```


6、启动Tomcat服务：

  6.1  cd /usr/local/tomcat/bin

  6.2  ./startup.sh

7、通过网页访问Tomcat：浏览器地址栏输入：http://服务器ip:8080/（若无法访问，请关闭防火墙）

  ip是centos服务的IP地址；8080是tomcat默认端口

8、确定tomcat是否启动：

  ps -aux | tomcat

9、查看防火墙信息：

  9.1  service firewalld status

  9.2  停止防火墙： service firewalld stop

  9.3  关闭防火墙：service firewalld disabled

10、对于新买的一些云服务，上面操作都没问题还是无法访问，需要在购买的服务里加上安全规则，如图：

![img](https://img2018.cnblogs.com/blog/761230/201810/761230-20181017111150822-1025134987.png)

点击配置规则进行操作

![img](https://img2018.cnblogs.com/blog/761230/201810/761230-20181017111051994-1850670044.png)

 

# 错误信息：./startup.sh: Permission denied

执行./startup.sh,或者./shutdown.sh的时候，

报：Permission denied，因为是执行tomcat时，用户无权限，导致出现以上错误。需要用命令：chmod 修改一下bin目录下的.sh权限。

具体操作如下：chmod u+x *.文件扩展名

chmod命令用于改变文件权限。

u 这里指文件所有者

+x 添加可执行权限

./ 指当前目录

其他用户依然没有执行权限

命令：chmod u+x *.sh

附上截图

![img](https://img2018.cnblogs.com/blog/1312588/201904/1312588-20190430100022055-277877409.png)

这样就启动成功了

