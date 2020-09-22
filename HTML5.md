HX使用快捷键

语法提示库----------右下角
alt+数字--------代码选择
F1-----------光标放到某api处，就可跳转到这个api的官方手册
ctrl+鼠标左键------------就可增加一个光标
ctrl+鼠标右键 --------------------可取消一个光标或选区
ctrl+e---------------还可以选择相同词，批量操作
alt+鼠标拖选-----------列选择，或者用快捷键ctrl+alt+↑或↓。
选择编译器-------右下角（例UTF-8->UTF16)
ctrl+p------------在顶部工具栏直接搜索工程下的文件名并打开
alt+ctrl+F-------------查找字符串(当前目录)，可在该目录下所有文件中搜索字符串
F4-------切换错误处
Ctrl+k 格式化代码

# H5 笔记

charset  字符集  //HTML中文网页需要使用

```html
<meta charset="utf-8"/>  /*声明编码*/
```


在网页布局中，HTML是结构，CSS是表现，Javascript是行为。

### 超链接

<a> 标签来设置超文本链接 
        使用 href 属性在 <a> 标签中，来描述链接的目标地址。
<a>target属性，_blank新窗口打开、
                          _self默认，相同窗口、
                          _parent父框架集、
                          _top在整个窗口中打开、
                          framename指定框架中打开

```html
<br><a href="https://baike.baidu.com/item/他夏了夏天/29344?fr=aladdin">他夏了夏天</a><br>
```

### details标签（下拉选项）    

​      用于描述文档或文档某个部分的细节
​		配合summary标签使用
​		目前只有chrome支持
​		具有open属性=>打开网页自动打开下拉选项

```html
<body><form action="http://www.baidu.com/s"target="_blank">    
  <input type="text" name="word" list="datalistid"placeholder="输入搜索信息（不能为空）:"       required />    
    <datalist id="datalistid">        
        <option>HTML5</option>        
        <option>CSS3</option>        
        <option>Javascript</option>        
        <option>XML</option>    
    </datalist>    
   <input type="submit" value="百度一 下 "></form>
</body>
```

### 标签

time标签		datetime，用T隔开日期跟时间2020-3-10T08：30

<form>标签用于创建供用户输入的HTML表单
                       action="URL"规定当提交表单时向何处发送表单数据
                                    绝对URL-指向一个网站
                                    相对URL-指向网站内的 一个文件
                       method规定如何发送表单数据get(默认)或post
                                   get：以查询字符串形式提交，在地址栏中能看到，长度有限制，不安全。
                                   post：以表单数据组形式提交，在地址栏中看不到，长度无限制，安全。
<hgroup></hgroup>标签
	被用来对标题元素进行分组

<header></header>标签
定义文档或者文档的一部分区域的页眉
应该作为介绍内容或者导航链接栏的容器
在一个文档中，您可以定义多个 <header> 元素。	


<input>type=text(文本)、
                       password(密码，圆点显示)、
                       radio(单选框)、
                       checkbox(复选框)
                       submit 定义提交按钮


<source> 标签为媒体元素（比如 <video> 和 <audio>）定义媒体资源。
	允许您规定两个视频/音频文件共浏览器根据它对媒体类型或者编解码器的支持进行选择。

<figure> 标签规定独立的流内容（图像、图表、照片、代码等等）。
	元素的内容应该与主内容相关，同时元素的位置相对于主内容是独立的。
	如果被删除，则不应对文档流产生影响。

<font> 标签规定文本的字体、字体尺寸、字体颜色。
	HTML5 不支持 <font> 标签。请用 CSS 代替。
	在 HTML 4.01 中，<font> 元素 已废弃。

<meter> 标签定义度量衡。仅用于已知最大和最小值的度量。（百分比条显示）
	属性：high 	规定被界定为高的值的范围。
	low		规定被界定为低的值的范围。0
	max		规定范围的最大值。
	min		规定范围的最小值。
	value		必需。规定度量的当前值。
	optimum		规定度量的最优值。
	

下面是常用的 HTML 文本格式化标签。

#### 标签	描述

<b>	定义粗体文本
<em>	定义着重文字
<i>	定义斜体字
<small>	定义小号字
<strong>	定义重要的文本
<sub>	定义下标字
<sup>	定义上标字
<ins>	定义插入字
<del>	定义删除字