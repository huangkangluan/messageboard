<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/13
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>我的留言板</title>
  <style type="text/css">
  #dada {
	width: 700px;
	margin-right: auto;
	margin-left: auto;
	background-color: #015B92;
	opacity: 0.85;
	border: 1px solid #CCC;
}
  #top {
	height: 35px;
	width: 100%;
	line-height: 35px;
	text-align: center;
	font-family: "微软雅黑";
	font-size: 18px;
	color: #FFFFFF;
	font-weight: bolder;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #0CF;
}
  #zhong {
	width: 100%;
}
  .xiao {
	height: 35px;
	width: 96%;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #95B1FD;
	color: #FFF;
	font-family: "微软雅黑";
	line-height: 35px;
	margin-right: auto;
	margin-left: auto;
}
  #zhong_zhong {
	height: 90px;
	width: 96%;
	color: #FFF;
    overflow-y: auto;
	font-family: "微软雅黑";
	margin-right: auto;
	margin-left: auto;
}

body{
	background-image: url(../../img/sleep.jpg);
	}
  .zuo {
	float: left;
	width: 80%;
}
  .you {
	float: right;
	width: 10%;
	text-align: center;
	padding-top: 6px;
}
    a{
      color: #FFFFFF;
    }
  </style>
  </head>
  <body>
  <form name="form1" method="post" action=""><div id="dada">
  <div id="top">留言板</div>
  <div id="zhong">
    <c:forEach items="${list}" var="msg">
  <div class="xiao"><div class="zuo">留言人：${msg.sendusername}</div>
  <div class="you">
    <label for="select"></label>
    <select name="select" id="select">
      <option value="引用">引用</option>

      <option value="删除"><a href="https://www.baidu.com/">删除</a></option>
    </select>
  </div>
  </div>
  <div id="zhong_zhong">${msg.messageContext}</div>
  <div class="xiao">${msg.careatTime}</div>
    </c:forEach>

  </div><div class="xiao"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    当前第${pages}页&nbsp;&nbsp;&nbsp;
    <c:forEach var="p" begin="1" end="${count}">
     <a href="msg?p=${p}">${p}</a>&nbsp;&nbsp;
    </c:forEach>&nbsp;
    总共${count}页</div>
  </div>  
  </form>
  </body>
</html>
