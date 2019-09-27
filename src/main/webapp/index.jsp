<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-09-24
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>index page</title>
</head>
<body>

<!--
jsp是一种简化servlet的设计，可以调用java库
jsp（java page servlet）中文含义是java服务端语言，核心技术是java技术，以servlet的形式来处理用户的访问和处理数据，
在服务端jsp文件会被编译成类文件，扩展名为 .class


-->

<h2>Test</h2>

<%
    out.println(request.getLocalAddr());
%>

</body>
</html>