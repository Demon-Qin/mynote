# Web

### 实现页面跳转  

<jsp : forward page ="文件名"></jsp:forward>

```html
/*这里是scope02.jsp*/
<body>
<%
    request.setCharacterEncoding("utf-8");
    /*获取page属性范围的数据值*/
    String name=(String)request.getAttribute("name");
    Integer age=(Integer)request.getAttribute("age");
%>
<%--输出属性值--%>
<h2>姓名：<%=name%></h2>
<h2>年龄：<%=age%></h2>
    <%--<jsp:forward page="scope03.jsp"/>--%>
</body>
```

```html
/*这里是scope01.jsp*/
<body>
<%
    request.setCharacterEncoding("utf-8");
    /*设置page范围属性*/
    /*pageContext.setAttribute("name","李四");
    pageContext.setAttribute("age",12);*/
    request.setAttribute("name","李四");
    request.setAttribute("age",12);

%>
<a href="scope02.jsp">获取数据并显示数据</a>
<%--<jsp:forward page="scope02.jsp"/>--%>
</body>
```

```html
/*这里是scope03.jsp*/
<body>
<%
    request.setCharacterEncoding("utf-8");
    /*获取page属性范围的数据值*/
    String name=(String)request.getAttribute("name");
    Integer age=(Integer)request.getAttribute("age");
%>
<%--输出属性值--%>

<h2>姓名：<%=name%></h2>
<h2>年龄：<%=age%></h2>

</body>
```

1:page:(pageContext)

仅仅在一个页面中保存属性。跳转之后无效。

表示将一个属性设置在本页面上，跳转之后无效。

当通过<jsp:forward>server跳转（**地址栏不发生改变**）之后。属性无法取得！

 ![img](http://img.blog.csdn.net/20140616154701406?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2hpeWVxaWFuZ2xkaA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 

2:request:

server跳转（<jsp:forward>）之后有效；

通过超链接(<a href=""></a>)request设置的属性是无法取得的；

request属性在MVC设计模式中使用比較多。

 ![img](http://img.blog.csdn.net/20140616155322437?%3C/p%3E%3Cp%3Ewatermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2hpeWVxaWFuZ2xkaA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 

3:session:

再一次会话范围中，不管何种跳转都能够使用，可是新开的浏览器无法使用；

能够再不论什么一个与设置页面相关的页面中取得；

在超链接中属性也能够取得（超连接地址栏改变，属于client跳转）。

每个新的浏览器连接上server后就是一个新的session。所以新开的浏览器中是无法取得session属性的。

 ![img](http://img.blog.csdn.net/20140616155909937?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2hpeWVxaWFuZ2xkaA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 

4:application:

在整个server上保存，全部用户都能够使用；

无论新开多少浏览器application属性均可取得，可是一旦server又一次启动，则之前设置的属性将所有消失。

### request

requestDemo1

```html
<body><form action="requestDemo2.jsp" method="post">    
    姓名：<input type="text" name="name" placeholder="aaa"><br>    
    爱好：<input type="checkbox" name="inst" value="swimming">swimming    
    <input type="checkbox" name="inst" value="reading">reading    
    <input type="checkbox" name="inst" value="jogging">jogging    <br>    
    <input type="submit"  value="提交"></form></body>


```

requestDemo2

```html
<body><%    request.setCharacterEncoding("utf-8");    
         String name=request.getParameter("name");    
         String []inst=request.getParameterValues("inst");%>    
    姓名:<%=name%>    
    爱好:<%    if (inst!=null){    for(int i=0;i<inst.length;i++){  %>  
    <%=inst[i]%> &nbsp;&nbsp;
    <%    }    
       }else{    
       out.println("无");    
       }%>
     <%--Enumeration enu=request.getParameterNames();while (enu.hasMoreElements()){
                        out.println("参数名:"+(String)enu.nextElement());}--%>
</body>
```

requestDemo3

```html
<body>
    <%    Enumeration enu= request.getHeaderNames();    
       while (enu.hasMoreElements()){        
       String headName=(String)enu.nextElement();        
       String headValue=request.getHeader(headName);%><h4>
        <%=headName%>:<%=headName%></h4><%    }%>
</body>
```

requestDemo4

```html
<body>
    <%    
       //获取客户端提交的方法    
         String method=request.getMethod();   
       //获取客户端ip地址    
       String ip=request.getRemoteAddr();    
       //获取访问路径    
       String path1=request.getServletPath();    
       //获取上文名称    
       String path2=request.getContextPath();    
       //获取当前文件的绝对路径    
       String path3=pageContext.getServletContext().getRealPath("/");    
       //获取请求路径    
       String path4=request.getRequestURI();    
       String path5=request.getRequestURL().toString();
     %>
       <h3>method=<%=method%></h3>
       <h3>ip=<%=ip%></h3>
       <h3>访问路径：<%=path1%></h3>
       <h3>上文路径：<%=path2%></h3>
       <h3>下文路径：<%=path3%></h3>
       <h3>当前文件路径:<%=path4%></h3>
       <h3>请求路径:<%=path1%></h3>
       <h3><%=path5%></h3>
</body>
```

![1600842001959](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\1600842001959.png)



