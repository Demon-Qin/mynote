# Web

实现页面跳转  <jsp : forward page ="文件名"></jsp:forward>

```java
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
</body>
```

```java
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

