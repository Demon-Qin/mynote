### 网络爬虫

#### 配置好环境

log4j.properties

日志

```java
log4j.rootLogger=DEBUG,A1
log4j.logger.cn.itcast = DEBUG
log4j.appender.A1=org.apache.log4j.ConsoleAppender
log4j.appender.A1.layout=org.apache.log4j.PatternLayout
log4j.appender.A1.layout.ConversionPattern=%-d{yyyy-MM-dd HH:mm:ss,SSS} [%t] [%c]-[%p] %m%n
```

抓取数据HTTP client

日志slf4j

#### 步骤

```Java
//打开浏览器
CloseableHttpClient httpClient = HttpClients.createDefault();
//输入网址
HttpGet httpGet = new HttpGet("http://www.itcast.cn");
httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
       F12查看network
//发起请求 返回响应httpclient对象发起请求
CloseableHttpResponse response = httpClient.execute(httpGet);
//解析响应
//判断状态码
if(response.getStatusLine().getStatusCode()==200){    
    HttpEntity httpEntity = response.getEntity();    
    String content = EntityUtils.toString(httpEntity,"utf-8");    
    System.out.println(content);
```